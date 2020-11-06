package com.demo.sharing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2020/10/30 18:34
 * @Created by cai
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "hello security";
    }
}
