package com.aust.airbon.sm.util;

import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;

/**
 * Created by no one on 2017/12/24.
 *
 */
public class HttpServletContextHelper {

    public static ServletContext getHttpContext(){

        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }

}
