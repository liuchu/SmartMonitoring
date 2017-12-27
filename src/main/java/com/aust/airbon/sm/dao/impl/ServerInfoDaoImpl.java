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

    public ArrayList<ServerInformation> getServerInfoAtDay(String ip) {
        return null;
    }
}
