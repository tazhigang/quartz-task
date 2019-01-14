package com.quartz.chapter02;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/14 13:53
 * @Description:
 */
public interface QuartzTaskDemo02 {
    static void main(String[] args) throws SchedulerException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();

        JobDetail job  = newJob(HelloJob.class)
                .withIdentity("hello","group")
                .usingJobData("job","hello")
                .build();

        Trigger trigger=newTrigger()
                        .withIdentity("trigger")
                        .startNow()
                        .withSchedule(dailyAtHourAndMinute(17, 46)) //14:32执行
                        .build();

        scheduler.scheduleJob(job, trigger);

    }
}
