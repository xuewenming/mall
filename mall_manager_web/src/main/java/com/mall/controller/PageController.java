package com.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 页面跳转
 * @author Sam
 * @date 2018/9/18
 * @time 19:04
 */
@Controller
public class PageController {


    @RequestMapping(value = "/")
    public String showIndex() {
        return "index";
    }

}
