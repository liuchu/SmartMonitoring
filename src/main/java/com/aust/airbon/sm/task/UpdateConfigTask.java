package com.aust.airbon.sm.task;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chuliu on 2017/12/25.
 */
public class UpdateConfigTask {

    private static Map<String,Integer> serverList = new HashMap<String, Integer>();

    public UpdateConfigTask() {
        serverList.put("211.211.211.101",10202);
        serverList.put("211.211.211.102",10205);
        serverList.put("211.211.211.103",10208);
        serverList.put("211.211.211.104",10211);
        serverList.put("211.211.211.105",10214);
        serverList.put("211.211.211.106",10217);
        serverList.put("211.211.211.107",10220);
        serverList.put("211.211.211.108",10223);
        serverList.put("211.211.211.109",10226);
        serverList.put("211.211.211.110",10229);
    }

    public String modifyConfig(String ip, String type, String value ){

        int port =  serverList.get(ip);

        //

        try {
            Socket socket = new Socket("localhost",port);
            //System.out.println(socket.getSoTimeout());
            socket.setSoTimeout(1000*10);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            JSONObject obj = new JSONObject();
            obj.put("ip",ip);
            obj.put("type",type);

            if ("status".equals(type)) {
                boolean online = Boolean.parseBoolean(value);
                obj.put("value",online);
            } else if ("threads".equals(type)) {
                int threads = Integer.parseInt(value);
                obj.put("value",threads);
            } else {
                JSONObject response = new JSONObject();
                response.put("response","fail");
                return response.toJSONString();
            }

            pw.write(obj.toJSONString());
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

            return jsonString;
            //System.out.println(ip+"PULL SERVER STATUS"+jsonString);

        } catch (SocketTimeoutException e){
            JSONObject response = new JSONObject();
            response.put("response","fail");
            return response.toJSONString();
        } catch (SocketException e) {
            JSONObject response = new JSONObject();
            response.put("response","fail");
            return response.toJSONString();
        } catch (IOException e) {
            JSONObject response = new JSONObject();
            response.put("response","fail");
            return response.toJSONString();
        }

    }

}
