package com.wjb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjb.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by wjb on 2017/6/6.
 */
@Controller
public class LogController {
    @Autowired
    private LogService logService;

    @ResponseBody
    @GetMapping("getJobIds")
    public List<Object> getJobIds(String key,String value) throws UnknownHostException {
        List<Object> log = logService.getJobIds(key, value);
        return log;
    }

    @ResponseBody
    @GetMapping("getJobIdLog")
    public List<Object> getJobIdLog(String key,String value,String startDate,String endDate,Integer pageNo,Integer size) throws UnknownHostException {
        int start = pageNo == null || pageNo < 1 ? 0 : (pageNo-1);
        start = start * size;
        int pageSize = size == null ? 20 : size;
        List<Object> log = logService.getJobIdLog(key, value,startDate,endDate,start,pageSize);
        return log;
    }





}
