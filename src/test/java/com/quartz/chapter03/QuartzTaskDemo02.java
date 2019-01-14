package com.quartz.chapter03;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/14 13:53
 * @Description:
 */
@SuppressWarnings("all")
public interface QuartzTaskDemo02 {
     static void main(String[] args) throws SchedulerException, ParseException {
        Date  formatTime= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-1-14 14:48:00");
        int month = formatTime.getMonth();
        int date = formatTime.getDate();
        int hours = formatTime.getHours();
        int minutes = formatTime.getMinutes();
        int seconds = formatTime.getSeconds();
        String cron=seconds+" "+minutes+" "+hours+" "+date+" "+(month+1)+" ?";
        System.out.println(cron);
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
                        .withSchedule(cronSchedule(cron))
                        .build();

        scheduler.scheduleJob(job, trigger);

    }
}
