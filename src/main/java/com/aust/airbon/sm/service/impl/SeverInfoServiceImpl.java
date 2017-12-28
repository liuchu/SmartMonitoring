package com.aust.airbon.sm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aust.airbon.sm.dao.impl.ServerInfoDaoImpl;
import com.aust.airbon.sm.pojo.ServerInformation;
import com.aust.airbon.sm.service.SeverInfoService;
import com.aust.airbon.sm.util.HttpServletContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.time.LocalDate;
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

    private ServerInfoDaoImpl serverInfoDao;

    @Autowired
    public SeverInfoServiceImpl(ServerInfoDaoImpl serverInfoDao) {
        this.serverInfoDao = serverInfoDao;
    }

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
                //System.out.println("IP IS:"+ip+"VALUE IS:"+context.getAttribute(ip));
                array.add(context.getAttribute(ip));
            }
        }

        data.put("response",array);

        return data.toJSONString();
    }

    public String getServerInfoAtDay(String ip, String date) {

        JSONObject data = new JSONObject();
        JSONArray array = new JSONArray();

        //获取这一天24小时的所有数据
        for (int hour=1;hour<25;hour++){

            ServerInformation infoAtHour = null;

            synchronized (serverInfoDao){
                infoAtHour = serverInfoDao.selectOneHourServerInfoAtDay(ip,date,hour);
            }

            if (infoAtHour==null) {
                infoAtHour = new ServerInformation(0,0,0,0,
                        0,0,0); //没有相关结果, 手动new一个对象
            }

            //infoAtHour一定不为空，且有数据

            String infoAtHourString = JSONObject.toJSONString(infoAtHour);

            JSONObject infoAtHourJSON = JSON.parseObject(infoAtHourString);

            JSONObject obj = new JSONObject();
            obj.put(String.valueOf(hour),infoAtHourJSON);

            array.add(obj);
        }

        data.put(ip,array);

        return data.toJSONString();
    }
}
