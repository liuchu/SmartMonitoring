package com.aust.airbon.sm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aust.airbon.sm.pojo.ServerInformation;
import com.aust.airbon.sm.service.SeverInfoService;
import com.aust.airbon.sm.util.HttpServletContextHelper;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by no one on 2017/12/24.
 *
 */
@Service("severInfoService")
public class SeverInfoServiceImpl implements SeverInfoService {

    private static ServletContext context = null;

    private static List<String> serverIpList = null;

    public static void setParam(ServletContext context){

        synchronized (context) {
            SeverInfoServiceImpl.context = context;
        }

    }

    public String getLatestServersInfo() {

        Enumeration<String> a = context.getAttributeNames();

        while (a.hasMoreElements()){
            String attr = a.nextElement();
            System.out.println("!ATTRIBUTE:"+attr);
        }


        if (serverIpList == null){
            serverIpList = (ArrayList)context.getAttribute("serverIpList");
        }

        System.out.println("KKKKK "+serverIpList.size());

        JSONObject data = new JSONObject();
        JSONArray array = new JSONArray();

        if (serverIpList!=null){
            for (String ip : serverIpList){
                System.out.println("IP IS:"+ip+"VALUE IS:"+context.getAttribute(ip));
                array.add(context.getAttribute(ip));
                /*data.put(ip,context.getAttribute(ip));
                System.out.println(ip+"-----"+context.getAttribute(ip));*/
            }
        }

        data.put("response",array);

        return data.toJSONString();
    }

    public String getServerInfoAtDay(String ip, String date) {
        return null;
    }
}
