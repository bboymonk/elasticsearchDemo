package com.wjb.controller;

import com.wjb.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public String hello(String username){
        System.out.println(username);
        String user = username;
        return SUCCESS_FAIL_N(user!=null,user,"error");
    }


}
