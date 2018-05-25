package com.zhangruiqiang.controller;

import com.zhangruiqiang.pojo.T_submit_platform_base_info;
import com.zhangruiqiang.service.platform_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private platform_Service platform_service;

    @GetMapping("/index")
    public String index(Model model){
       List<T_submit_platform_base_info> list2= platform_service.select_platform();
       model.addAttribute("list",list2);
       return "index1";

    }





}
