package com.zhangruiqiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


    @GetMapping("/indexpage")
    public String indexpage(){
        return "index1";

    }
}
