package com.wjb.controller;

import com.wjb.service.LogService;
import com.wjb.util.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;

/**
 * Created by wjb on 2017/6/6.
 */
@Controller
public class LogController {
    @Autowired
    private LogService logService;

    @ResponseBody
    @GetMapping("getJobIds")
    public PageSupport getJobIds(String key, String value, Integer start, Integer size) throws UnknownHostException {
        int startPage = start == null || start < 1 ? 0 : (start-1);
        startPage = startPage * size;
        int pageSize = size == null ? 20 : size;
        PageSupport log = logService.getJobIds(key, value,startPage,size);
        return log;
    }

    @ResponseBody
    @GetMapping("getJobIdLog")
    public PageSupport getJobIdLog(String key,String value,String startDate,String endDate,Integer start,Integer size) throws UnknownHostException {
        int startPage = start == null || start < 1 ? 0 : (start-1);
        startPage = startPage * size;
        int pageSize = size == null ? 20 : size;
        PageSupport log = logService.getJobIdLog(key, value,startDate,endDate,startPage,pageSize);
        return log;
    }





}
