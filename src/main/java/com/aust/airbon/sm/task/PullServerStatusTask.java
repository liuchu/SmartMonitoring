package com.aust.airbon.sm.task;

import com.aust.airbon.sm.dao.ServerInfoDao;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by no one on 2017/12/24.
 *
 */
public class PullServerStatusTask {

    private ServerInfoDao serverInfoDao;
    private ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
    private Integer[] serverList = new Integer[]{
            10201,
            10204,
            10207,
            10210,
            10213,
            10216,
            10219,
            10222,
            10225,
            10228
    };

    static {
        //startPullServerStatus();
    }

    private void startPullServerStatus(){

        for (Integer port:serverList) {


        }


        /*try {
            Socket socket = new Socket("localhost",port+i*3+1);
            System.out.println(socket.getSoTimeout());
            socket.setSoTimeout(1000*10);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.write("HELLO!");
            pw.flush();

            socket.shutdownOutput();

            //3、获取输入流，并读取服务器端的响应信息
            String info = "";
            StringBuilder stringBuffer = new StringBuilder("");
            while((info=br.readLine())!=null){
                //System.out.println("在while之中: "+info);
                stringBuffer.append(info);
            }
            socket.shutdownInput();
            System.out.println("服务器说："+stringBuffer.toString());
                *//*JSONObject serverStatus = JSON.parseObject(stringBuffer.toString());
                String outcome = serverStatus.getString("outcome");
                if ("online".equals(outcome)) {
                    System.out.println("Server"+i+" online");
                }*//*
        } catch (SocketTimeoutException e){
            System.out.println("This server is offline!!");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    class pullThreadRunnable implements Runnable{

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

        }
    }
}
