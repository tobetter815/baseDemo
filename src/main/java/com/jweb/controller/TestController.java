package com.jweb.controller;

import com.jweb.common.StateMsg;
import com.jweb.model.Base_demo_user;
import com.jweb.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试
 * Created by chenlong on 2016/5/11.
 */
@Controller
public class TestController {
    @Resource
    TestService testService;

    @ResponseBody
    @RequestMapping(value = "getTestUser.do",method = RequestMethod.GET)
    public String test(ModelMap map){
        String jsonStr;
        String msg;
        List<Base_demo_user> list=testService.getTestUser();
        if(list==null){
            msg="数据操作错误";
            map.addAttribute("error",msg);
            jsonStr = StateMsg.toJson(-1, map);
            return jsonStr;
        }
        if(list.size()<1){
            msg="获取数据为空";
            map.addAttribute("error",msg);
            jsonStr = StateMsg.toJson(-2, map);
            return jsonStr;
        }
        map.addAttribute("test",list);
        jsonStr= StateMsg.toJson(1, map);
        return jsonStr;
    }

    @ResponseBody
    @RequestMapping(value = "view.do",method = RequestMethod.GET)
    public String page(ModelMap map){

        return "/login";
    }
}
