package com.lyl.mybatis_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 罗亚龙
 * @date 2021/10/29 10:13
 */
@Controller
public class ViewController {

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
