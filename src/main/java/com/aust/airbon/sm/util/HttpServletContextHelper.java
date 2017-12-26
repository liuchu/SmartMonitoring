package com.aust.airbon.sm.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by no one on 2017/12/24.
 *
 */
@Component
public class HttpServletContextHelper implements ServletContextAware {

    private static ServletContext context;

    public static ServletContext getServletContext(){

        return context;
    }

    public void setServletContext(ServletContext servletContext) {
        context = servletContext;
    }
}
