package com.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 初始化页面跳转
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


    @RequestMapping(value = "/{uri}")
    public String showItemList(@PathVariable String uri) {
        return uri;
    }

}
