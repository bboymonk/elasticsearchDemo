package com.wjb.controller;

import com.wjb.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wjb on 2017/6/6.
 */
@Controller
public class UrlController {
    @Autowired
    private UrlService urlService;
    @ResponseBody
    @GetMapping("getUrl")
    public String getUrl(String jobId){
        return urlService.getUrl(jobId);
    }


}
