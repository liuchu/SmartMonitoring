package com.aust.airbon.sm.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aust.airbon.sm.dao.ServerInfoDao;
import com.aust.airbon.sm.dao.impl.ServerInfoDaoImpl;
import com.aust.airbon.sm.pojo.ServerInformation;
import com.aust.airbon.sm.util.ApplicationContextHelper;
import com.aust.airbon.sm.util.HttpServletContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.util.Enumeration;

/**
 * Created by no one on 2017/12/25.
 *
 */

public class PullServerStatusRunnable implements Runnable {

    private String ip;
    private int dataTransferPort;
    private static ServletContext context = null;

    private static Integer number = 0;

    private static ServerInfoDaoImpl serverInfoDao = null;

    public static void setParam(ServletContext context){
        PullServerStatusRunnable.context = context;
    }

    public static void setDao(ServerInfoDaoImpl serverInfoDao){
        PullServerStatusRunnable.serverInfoDao = serverInfoDao;
    }

    public PullServerStatusRunnable(String ip, int dataTransferPort) {
        this.ip = ip;
        this.dataTransferPort = dataTransferPort;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {

        if (PullServerStatusRunnable.context == null) {
            return;
        }

        /*if (serverInfoDao == null) {
            System.out.println("DAO IS NULL");
        } else {
            System.out.println("DAO IS:"+serverInfoDao);
        }*/

        String jsonString = "";

        try {
            Socket socket = new Socket("localhost",dataTransferPort);
            //System.out.println(socket.getSoTimeout());
            socket.setSoTimeout(1000*10);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.write("PING");
            pw.flush();

            socket.shutdownOutput();

            //3、获取输入流，并读取服务器端的响应信息
            String info = "";
            StringBuilder stringBuffer = new StringBuilder("");
            while((info=br.readLine())!=null){
                stringBuffer.append(info);
            }
            socket.shutdownInput();

            jsonString = stringBuffer.toString();

            //save to web servlet context
            context.setAttribute(ip,jsonString);

            //System.out.println(ip+"PULL SERVER STATUS"+jsonString);

        } catch (SocketTimeoutException e){
            context.setAttribute(ip,"Offline");
            System.out.println(ip+"SocketTimeoutException: This server is offline!!");
        } catch (SocketException e) {
            context.setAttribute(ip,"Offline");
            System.out.println(ip+"SocketException: This server is offline!!");
        } catch (IOException e) {
            context.setAttribute(ip,"Offline");
            System.out.println(ip+"IOException: This server is offline!!");
        }

        JSONObject serverStatus = JSON.parseObject(jsonString);
        ServerInformation serverInfo = new ServerInformation(
                serverStatus.getString("IP"),
                serverStatus.getString("CPU"),
                serverStatus.getIntValue("memory"),
                serverStatus.getIntValue("disk"),
                serverStatus.getIntValue("maxAllowedThreads"),
                serverStatus.getBooleanValue("online"),
                serverStatus.getIntValue("usedCPU"),
                serverStatus.getIntValue("usedMemory"),
                serverStatus.getIntValue("usedDisk"),
                serverStatus.getIntValue("currentThreads"),
                LocalDateTime.now()
        );

        //save the status to database
        System.out.println("serverDao:"+serverInfoDao);
        try {
            synchronized (number) {
                synchronized (serverInfoDao){
                    System.out.println("TRIED TO INSERT A RECORD");
                    int affectedRow = serverInfoDao.insertServerInfo(serverInfo);

                    if (affectedRow == 0) {
                        System.out.println("FAILED!");
                    } else {
                        System.out.println("SUCCESS!");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Could NOT write into database!!!");
            e.printStackTrace();
        }


    }
}
