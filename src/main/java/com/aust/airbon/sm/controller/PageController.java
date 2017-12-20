package com.aust.airbon.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chuliu on 2017/12/20.
 */
@Controller
public class PageController {

    @RequestMapping("/monitoring")
    public ModelAndView viewHome(){
        ModelAndView mav = new ModelAndView("monitoring");
        return mav;
    }
}
