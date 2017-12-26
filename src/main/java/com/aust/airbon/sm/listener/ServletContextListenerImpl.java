package com.aust.airbon.sm.listener;

import com.aust.airbon.sm.service.impl.SeverInfoServiceImpl;
import com.aust.airbon.sm.task.PullServerStatusRunnable;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by no one on 2017/12/26.
 *
 */
public class ServletContextListenerImpl implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext context = servletContextEvent.getServletContext();
        System.out.println("WEB CONTEXT:"+context);
        SeverInfoServiceImpl.setParam(context);
        PullServerStatusRunnable.setParam(context);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
