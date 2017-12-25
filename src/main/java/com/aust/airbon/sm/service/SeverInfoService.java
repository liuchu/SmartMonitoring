package com.aust.airbon.sm.service;

import com.aust.airbon.sm.pojo.ServerInformation;

import java.util.ArrayList;

/**
 * Created by no one on 2017/12/24.
 *
 */
public interface SeverInfoService {

    //获取·所有·服务器的最新信息
    public String getLatestServersInfo();

    //从数据库获取一台服务器的具体某一天的历史数据。24小时，每小时取这一个小时内所有数据的平均值
    //处理成JSON
    public String getServerInfoAtDay(String ip, String date);


}
