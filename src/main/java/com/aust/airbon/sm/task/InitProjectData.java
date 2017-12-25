package com.aust.airbon.sm.task;

import com.aust.airbon.sm.util.HttpServletContextHelper;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by no one on 2017/12/25.
 *
 */
public class InitProjectData {

    private static ServletContext context = HttpServletContextHelper.getHttpContext();

    public void loadServerIpList(){
        List<String> serverIpList = new ArrayList<String>();
        serverIpList.add("211.211.211.101");
        serverIpList.add("211.211.211.102");
        serverIpList.add("211.211.211.103");
        serverIpList.add("211.211.211.104");
        serverIpList.add("211.211.211.105");
        serverIpList.add("211.211.211.106");
        serverIpList.add("211.211.211.107");
        serverIpList.add("211.211.211.108");
        serverIpList.add("211.211.211.109");
        serverIpList.add("211.211.211.110");

        context.setAttribute("serverIpList",serverIpList);

        System.out.println("!!!LOAD SERVER DATA!!!");

    }
}
