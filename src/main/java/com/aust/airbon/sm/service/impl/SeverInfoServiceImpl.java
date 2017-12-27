package com.aust.airbon.sm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aust.airbon.sm.dao.impl.ServerInfoDaoImpl;
import com.aust.airbon.sm.pojo.ServerInformation;
import com.aust.airbon.sm.service.SeverInfoService;
import com.aust.airbon.sm.util.HttpServletContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static ArrayList<String> serverIpList = null;

    /*@Autowired
    private ServerInfoDaoImpl serverInfoDao;*/



    public static void setParam(ServletContext context){

        synchronized (context) {
            SeverInfoServiceImpl.context = context;
        }

    }

    public String getLatestServersInfo() {

        if (serverIpList == null){
            serverIpList = (ArrayList<String>)context.getAttribute("serverIpList");
        }

        JSONObject data = new JSONObject();
        JSONArray array = new JSONArray();

        if (serverIpList!=null){
            for (String ip : serverIpList){
                System.out.println("IP IS:"+ip+"VALUE IS:"+context.getAttribute(ip));
                array.add(context.getAttribute(ip));
            }
        }

        data.put("response",array);

        //System.out.println("userDao:"+serverInfoDao);

        return data.toJSONString();
    }

    public String getServerInfoAtDay(String ip, String date) {
        return null;
    }
}
