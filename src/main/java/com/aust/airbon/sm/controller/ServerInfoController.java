package com.aust.airbon.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by no one on 2017/12/24.
 *
 */
@RequestMapping("/serverInfo")
@Controller
public class ServerInfoController {

    /*
     * 获取最新的服务器信息, 从session中取
     * */
    @RequestMapping("latest")
    public String getServersInformationLatest() {
        //ModelAndView mav = new ModelAndView("dashboard");
        return "";
    }

    /*
     * 获取服务器信息历史记录, 从数据库中获取
     * */
    @RequestMapping("history")
    public ModelAndView getServersInformationHistory(@RequestParam("ip") String ip){
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
    }

}
