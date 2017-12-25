package com.aust.airbon.sm.task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by no one on 2017/12/24.
 *
 */
public class InitPullServerStatusThreads {

    private Map<String,Integer> serverList = new HashMap<String, Integer>();

    public InitPullServerStatusThreads() {
        serverList.put("211.211.211.101",10201);
        serverList.put("211.211.211.102",10204);
        serverList.put("211.211.211.103",10207);
        serverList.put("211.211.211.104",10210);
        serverList.put("211.211.211.105",10213);
        serverList.put("211.211.211.106",10216);
        serverList.put("211.211.211.107",10219);
        serverList.put("211.211.211.108",10222);
        serverList.put("211.211.211.109",10225);
        serverList.put("211.211.211.110",10228);
    }


    public void startPullServerStatus(){

        for (String ip :serverList.keySet()) {

            PullServerStatusRunnable pullThreadRunnable = new PullServerStatusRunnable(ip,serverList.get(ip));

            try {
                ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
                service.scheduleAtFixedRate(pullThreadRunnable, 10, 5, TimeUnit.SECONDS);
                //serversStatusLog.info(getIP()+"状态定时更新服务启动成功");
            } catch (Exception e){
                //errorLog.fatal(getIP()+"状态定时更新服务启动失败！");
            }

        }

        System.out.println("!!!START PULL TASK!!!");

    }

}
