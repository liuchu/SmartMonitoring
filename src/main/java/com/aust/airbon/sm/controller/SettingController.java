package com.aust.airbon.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by no one on 2017/12/24.
 *
 */
@RequestMapping("/setting")
@Controller
public class SettingController {

    @RequestMapping("changeLanguage")
    public ModelAndView changeLanguage(HttpServletRequest request, String lang){

        //logger.debug("切换语言中。。。当前语言为:"+lang);
        System.out.println("切换语言中。。。当前语言为:"+lang);

        ModelAndView mav = new ModelAndView("redirect:/monitoring/setting_language");
        return mav;
    }
}
