package com.aust.airbon.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by no one on 2017/12/20.
 *
 */
@RequestMapping("/monitoring")
@Controller
public class PageController {

    @RequestMapping("")
    public ModelAndView viewDashboard(){
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
    }

    @RequestMapping("/live/basic")
    public ModelAndView viewLiveStatus(){
        ModelAndView mav = new ModelAndView("live_status");
        return mav;
    }

    @RequestMapping("/report/line")
    public ModelAndView viewHistoryReportLineReport(){
        ModelAndView mav = new ModelAndView("history_report_line_chart");
        return mav;
    }

    @RequestMapping("/setting_language")
    public ModelAndView viewSettingLanguage(){
        ModelAndView mav = new ModelAndView("setting_language");
        return mav;
    }
}
