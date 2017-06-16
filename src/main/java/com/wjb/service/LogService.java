package com.wjb.service;

import com.wjb.util.PageSupport;

import java.net.UnknownHostException;

/**
 * Created by wjb on 2017/6/6.
 */
public interface LogService {
    PageSupport getJobIds(String key , String value, Integer start, Integer pageSize) throws UnknownHostException;

    PageSupport getJobIdLog(String key , String value, String startDate, String endDate,Integer pageNo,Integer pageSize) throws UnknownHostException;

    PageSupport getLogText(String key , String value, String startDate, String endDate,Integer pageNo,Integer pageSize) throws UnknownHostException;


    
    
}
