package com.wjb.service;

import com.github.pagehelper.PageInfo;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/**
 * Created by wjb on 2017/6/6.
 */
public interface LogService {
    List<Object> getJobIds(String key , String value) throws UnknownHostException;

    List<Object> getJobIdLog(String key , String value, String startDate, String endDate,Integer pageNo,Integer pageSize) throws UnknownHostException;

}
