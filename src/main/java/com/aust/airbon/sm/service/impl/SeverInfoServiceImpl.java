package com.aust.airbon.sm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aust.airbon.sm.pojo.ServerInformation;
import com.aust.airbon.sm.service.SeverInfoService;
import com.aust.airbon.sm.util.HttpServletContextHelper;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.ArrayList;
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

        SeverInfoServiceImpl.context = context;

        if (context!=null){
            serverIpList = (ArrayList)context.getAttribute("serverIpList");
        }

    }

    public String getLatestServersInfo() {

        JSONObject data = new JSONObject();

        if (serverIpList!=null){
            for (String ip : serverIpList){
                data.put(ip,context.getAttribute(ip));
                System.out.println(ip+"-----"+context.getAttribute(ip));
            }
        }

        return data.toJSONString();
    }

    public String getServerInfoAtDay(String ip, String date) {
        return null;
    }
}
