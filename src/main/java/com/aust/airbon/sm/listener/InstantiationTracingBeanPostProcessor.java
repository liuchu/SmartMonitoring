package com.aust.airbon.sm.listener;

import com.aust.airbon.sm.service.impl.SeverInfoServiceImpl;
import com.aust.airbon.sm.task.InitProjectData;
import com.aust.airbon.sm.task.InitPullServerStatusThreads;
import com.aust.airbon.sm.util.ApplicationContextHelper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;

/**
 * Created by no one on 2017/12/25.
 *
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    private int tag = 0;

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println("HAHAHA"+contextRefreshedEvent);
        System.out.println("bbbbbb"+contextRefreshedEvent.getApplicationContext());
        System.out.println("cccccc"+contextRefreshedEvent.getApplicationContext().getDisplayName());

        if(contextRefreshedEvent.getApplicationContext().getDisplayName().equals("WebApplicationContext for namespace 'spring-mvc-servlet'")){
            //Set context to Service SeverInfoServiceImpl
            System.out.println("XXXXXX");
            ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
            System.out.println("WEB CONTEXT:"+context);
            SeverInfoServiceImpl.setParam(context);

            ApplicationContext appContext = ApplicationContextHelper.getApplicationContext();
            System.out.println("Spring CONTEXT:"+context);
            //Get bean to init lazy bean
            //Init project data
            InitProjectData initData = (InitProjectData)appContext.getBean("initData");
            initData.loadServerIpList();
            //Init pull tasks
            InitPullServerStatusThreads initTasks = (InitPullServerStatusThreads)appContext.getBean("initPullTasks");
            initTasks.startPullServerStatus();

            tag++;
        }
    }
}
