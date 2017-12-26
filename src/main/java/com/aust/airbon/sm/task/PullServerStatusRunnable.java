package com.aust.airbon.sm.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aust.airbon.sm.dao.ServerInfoDao;
import com.aust.airbon.sm.pojo.ServerInformation;
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
import java.util.Enumeration;

/**
 * Created by no one on 2017/12/25.
 *
 */
public class PullServerStatusRunnable implements Runnable {

    private String ip;
    private int dataTransferPort;
    private static ServletContext context = null;

    @Autowired
    private ServerInfoDao serverInfoDao;

    public static void setParam(ServletContext context){
        PullServerStatusRunnable.context = context;
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

            String jsonString = stringBuffer.toString();

            JSONObject serverStatus = JSON.parseObject(stringBuffer.toString());
            ServerInformation serverInfo = new ServerInformation(
                    serverStatus.getString("CPU"),
                    serverStatus.getIntValue("memory"),
                    serverStatus.getIntValue("disk"),
                    serverStatus.getString("IP"),
                    serverStatus.getIntValue("maxAllowedThreads"),
                    serverStatus.getBooleanValue("online"),
                    serverStatus.getIntValue("usedCPU"),
                    serverStatus.getIntValue("usedMemory"),
                    serverStatus.getIntValue("usedDisk"),
                    serverStatus.getIntValue("currentThreads")
                    );

            //save to web servlet context
            context.setAttribute(ip,jsonString);
            //System.out.println("Just now:"+ip+"->"+context.getAttribute(ip));

            /*Enumeration<String> a = context.getAttributeNames();

            while (a.hasMoreElements()){
                String attr = a.nextElement();
                System.out.println("!ATTRIBUTE:"+attr);
            }*/

            //save the status to database
            /*synchronized (serverInfoDao){
                serverInfoDao.insertServerInfo(serverInfo);
            }*/

            //System.out.println(ip+"PULL SERVER STATUS"+jsonString);

        } catch (SocketTimeoutException e){
            context.setAttribute(ip,"Offline");
            System.out.println("SocketTimeoutException: This server is offline!!");
        } catch (SocketException e) {
            context.setAttribute(ip,"Offline");
            System.out.println("SocketException: This server is offline!!");
        } catch (IOException e) {
            context.setAttribute(ip,"Offline");
            System.out.println("IOException: This server is offline!!");
        }

    }
}
