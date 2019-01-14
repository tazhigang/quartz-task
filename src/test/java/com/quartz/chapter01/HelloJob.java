package com.quartz.chapter01;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: ittzg
 * @CreateDate: 2018/12/21 17:09
 * @Description: 创建任务
 */
public class HelloJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("HELLO WORLD");
    }
}
