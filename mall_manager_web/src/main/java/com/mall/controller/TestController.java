package com.mall.controller;

import com.mall.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试框架集成
 * @author Sam
 * @date 2018/9/18
 * @time 19:04
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test/queryNow")
    @ResponseBody
    public String query() {
        return testService.queryNow();
    }
}
