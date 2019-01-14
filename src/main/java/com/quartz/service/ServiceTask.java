package com.quartz.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/14 15:00
 * @Description:
 */
@Configuration
@Component
@EnableScheduling
public class ServiceTask {
    public void task(){
        System.out.println("hello word");
    }
}
