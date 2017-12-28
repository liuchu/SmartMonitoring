package com.aust.airbon.sm.mapper;

import com.aust.airbon.sm.pojo.ServerInformation;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by no one on 2017/12/26.
 *
 */
@Component
public interface ServerInfoMapper {

    int mapperInsertServerInfo(ServerInformation serverInformation);

    ServerInformation mapperSelectOneHourServerInfoAtDay(String ip, String startTime,String endTime);

}
