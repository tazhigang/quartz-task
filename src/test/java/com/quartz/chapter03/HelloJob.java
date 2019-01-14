package com.quartz.chapter03;

import org.quartz.*;

/**
 * @Author: ittzg
 * @CreateDate: 2018/12/21 17:09
 * @Description: 创建任务
 */
public class HelloJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("job");

        System.err.println("job:"+jobSays);
    }
}
