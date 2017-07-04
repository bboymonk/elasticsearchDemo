package com.wjb.controller;

import com.wjb.base.BaseController;
import com.wjb.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wjb on 2017/6/16.
 */
@Controller
public class TestFreemarkerController extends BaseController{

    @GetMapping(value = "test")
    public String test(){
        return "test";
    }

    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello(){
        User user = new User();
        user.setId(10);
        user.setName("wjb");
        user.setAge(20);
        user.setAddress("杭州");
        return SUCCESS_FAIL_N(true,user,null);
    }



}
