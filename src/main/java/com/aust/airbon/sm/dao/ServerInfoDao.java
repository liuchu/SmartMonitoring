package com.aust.airbon.sm.dao;

import com.aust.airbon.sm.pojo.ServerInformation;

import java.util.ArrayList;

/**
 * Created by no one on 2017/12/24.
 *
 */

public interface ServerInfoDao {

    //将从·一台·服务器获取的数据写入数据库
    public int insertServerInfo(ServerInformation serverInformation);

    //从数据库获取·一台·服务器的具体某一天的历史数据。24小时，每小时取这一个小时内所有数据的平均值

    public ServerInformation selectOneHourServerInfoAtDay(String ip, String date, int hour);
}
