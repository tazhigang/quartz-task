package com.quartz.config;

import com.quartz.repository.CronRepository;
import com.quartz.repository.entity.CronEntity;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/14 15:24
 * @Description: 动态获取cron
 */
@Configuration
@Component
@EnableScheduling
public class SchedulerRedreshDataBase {
    @Autowired
    private CronRepository cronRepository;
    @Resource(name = "jobDetail")
    private JobDetail jObDetail;
    @Resource(name = "trigger")
    private CronTrigger cronTrigger;
    @Resource(name = "scheduler")
    private Scheduler scheduler;

    /**
     * 每5000ms去查数据库中的cron 对Cron进行定时更新
     * @throws SchedulerException
     */
    @Scheduled(fixedRate = 5000)
    public void schedulerUpdateCronTrigger() throws SchedulerException {
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
        String currentCron = trigger.getCronExpression();
        String searchCron  = cronRepository.findOneById(1L).getCron();
        /**
         * 当本地的cron与数据库中的cron不一致时候 采用数据库中cron
         */
        if(!currentCron.equals(searchCron)){
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
            trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
            trigger = trigger.getTriggerBuilder()
                    .withIdentity(cronTrigger.getKey())
                    .withSchedule(scheduleBuilder)
                    .build();

            scheduler.rescheduleJob(cronTrigger.getKey(),trigger);
            currentCron = searchCron;
        }
    }
}
