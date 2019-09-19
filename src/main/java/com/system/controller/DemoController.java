package com.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengyu
 * @Date 2019/6/18
 * @Description
 */
@RestController
@RequestMapping("/demo")
public class DemoController {


    @GetMapping
    public String hello(){
        return "hello word";
    }


}