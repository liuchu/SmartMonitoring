package com.aust.airbon.sm.dao.impl;

import com.aust.airbon.sm.dao.ServerInfoDao;
import com.aust.airbon.sm.mapper.ServerInfoMapper;
import com.aust.airbon.sm.pojo.ServerInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by no one on 2017/12/24.
 *
 */
@Repository("serverInfoDao")
public class ServerInfoDaoImpl implements ServerInfoDao {


    final private ServerInfoMapper serverInfoMapper;

    @Autowired
    public ServerInfoDaoImpl(ServerInfoMapper serverInfoMapper) {
        this.serverInfoMapper = serverInfoMapper;
    }


    public int insertServerInfo(ServerInformation serverInformation) {

        int affectedRow = 0;
        affectedRow = serverInfoMapper.mapperInsertServerInfo(serverInformation);
        return affectedRow;

    }

    //24 hours per day, begin with 1.
    public ServerInformation selectOneHourServerInfoAtDay(String ip, String date, int hour) {
        //Time formate: 2017-03-03 17:39:05

        String startTime =  date+" "+(hour-1)+":00:00";

        String endTime = date+" "+(hour-1)+":59:59";

        return serverInfoMapper.mapperSelectOneHourServerInfoAtDay(ip,startTime,endTime);

    }
}
