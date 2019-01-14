package com.quartz.config;

import com.quartz.service.ServiceTask;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/14 15:11
 * @Description: quartz配置
 */
@Configuration
public class QuartzConfiguration {
    /**
     *  设置任务详情
     * @param task
     * @return
     */
    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean methodInvokingFactoryBean(ServiceTask task){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(false);
        jobDetail.setName("quartz-task");
        jobDetail.setGroup("quartz");
        jobDetail.setTargetObject(task);
        jobDetail.setTargetMethod("task");
        return jobDetail;
    }

    /**
     * 设置定时任务执行时间
     * @param jobDetail
     * @return
     */
    @Bean(name = "trigger")
    public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobDetail){
        CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
        cronTrigger.setJobDetail(jobDetail.getObject());
        cronTrigger.setCronExpression("0 * * * * ?");
        cronTrigger.setName("quartz");
        return cronTrigger;
    }

    /**
     * 定时任务启动
     * @param trigger
     * @return
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger trigger){
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setOverwriteExistingJobs(true);
        scheduler.setStartupDelay(1);
        scheduler.setTriggers(trigger);
        return scheduler;
    }
}
