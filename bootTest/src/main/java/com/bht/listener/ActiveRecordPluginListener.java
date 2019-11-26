package com.bht.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class ActiveRecordPluginListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        initActiveRecord();
    }

    private void initActiveRecord() {
        System.out.println(123);
    }

}
