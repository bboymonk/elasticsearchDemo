package com.wjb.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by wjb on 2017/6/16.
 */
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS");
        System.out.println("测试quartz任务:" + format.format(Calendar.getInstance().getTime()));
    }
}
