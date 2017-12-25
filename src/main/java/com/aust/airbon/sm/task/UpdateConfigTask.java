package com.aust.airbon.sm.task;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chuliu on 2017/12/25.
 */
public class UpdateConfigTask {

    private static Map<String,Integer> serverList = new HashMap<String, Integer>();

    public UpdateConfigTask() {
        serverList.put("211.211.211.101",10202);
        serverList.put("211.211.211.102",10205);
        serverList.put("211.211.211.103",10208);
        serverList.put("211.211.211.104",10211);
        serverList.put("211.211.211.105",10214);
        serverList.put("211.211.211.106",10217);
        serverList.put("211.211.211.107",10220);
        serverList.put("211.211.211.108",10223);
        serverList.put("211.211.211.109",10226);
        serverList.put("211.211.211.110",10229);
    }

    public String modifyConfig(String ip, String type, String value ){
        return "success";
    }

}
