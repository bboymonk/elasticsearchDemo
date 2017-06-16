package com.wjb.base;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wjb on 2017/6/16.
 */
public class BaseController {
    public Map<String,Object> baseMap = new HashMap<String,Object>();

    /**
     * 混合判断输出  整体抛出
     */
    public static String SUCCESS_FAIL_N(boolean  expr, Object success, Object error){
        JSONObject json = new JSONObject();
        if(expr){
            json.put("MSG",true);
            json.put("DATA",success);
        }else{
            json.put("MSG",false);
            json.put("DATA",error);
        }
        return json.toJSONString();
    }




}
