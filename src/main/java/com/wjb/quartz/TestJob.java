package com.wjb.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by wjb on 2017/6/16.
 */
public class TestJob {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS");
        System.out.println("开始时间:" + format.format(Calendar.getInstance().getTime()));
        try {
//            通过schedulerFactory获取一个调度器
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//            创建jobDetail实例，绑定Job实现类,指明job的名称，所在组的名称，以及绑定job类
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("wjb", "bboyGroup").build();
//            使用simpleTrigger规则
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withRepeatCount(8))
                    .startNow().build();


//            使用cornTrigger规则
//            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger","triggerGroup")
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0/15 * * * * ? *"))
//                    .startNow().build();
//            把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail, trigger);
//            启动调度
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }
}
