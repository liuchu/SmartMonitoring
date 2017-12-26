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
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(contextRefreshedEvent.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
            //Set context to Service SeverInfoServiceImpl

            ApplicationContext appContext = ApplicationContextHelper.getApplicationContext();
            System.out.println("Spring IOC CONTEXT:"+appContext);
            //Get bean to init lazy bean
            //Init project data
            InitProjectData initData = (InitProjectData)appContext.getBean("initData");
            initData.loadServerIpList();
            //Init pull tasks
            InitPullServerStatusThreads initTasks = (InitPullServerStatusThreads)appContext.getBean("initPullTasks");
            initTasks.startPullServerStatus();

        }
    }
}
