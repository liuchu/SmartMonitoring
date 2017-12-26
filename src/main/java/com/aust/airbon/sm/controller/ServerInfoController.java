package com.aust.airbon.sm.controller;

import com.aust.airbon.sm.service.SeverInfoService;
import com.aust.airbon.sm.service.impl.SeverInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

/**
 * Created by no one on 2017/12/24.
 *
 */
@RequestMapping("/serverInfo")
@Controller
public class ServerInfoController {

    @Autowired
    private SeverInfoServiceImpl severInfoService;

    /*
     * 获取最新的服务器信息, 从session中取
     * */
    @ResponseBody
    @RequestMapping("/latest")
    public String getServersInformationLatest() {
        //ModelAndView mav = new ModelAndView("dashboard");
        System.out.println("OOOOO "+severInfoService.getLatestServersInfo());
        return severInfoService.getLatestServersInfo();
        //return "";
    }

    /*
     * 获取服务器信息历史记录, 从数据库中获取
     * */
    @RequestMapping("/history")
    public ModelAndView getServersInformationHistory(@RequestParam("ip") String ip){
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
    }

    /*
     * 更新服务器配置
     * */
    @RequestMapping("/config")
    public ModelAndView updateServersConfig(@RequestParam("ip") String ip){
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
    }

}
