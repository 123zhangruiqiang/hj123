package com.zhangruiqiang.controller;

import com.zhangruiqiang.pojo.T_submit_platform_base_info;
import com.zhangruiqiang.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class TaskControlle {
    @Autowired
    private TaskService taskService;
    private String subject_no="100000356";

    Logger logger=LoggerFactory.getLogger(TaskControlle.class);

    @RequestMapping(value = "dotask",method =RequestMethod.GET)
    public void dotask(){

       int res= taskService.platformregistercheck(subject_no);
       logger.info("平台地址编码校验，结果应当为0");
       logger.info("检查结果为："+res);

        List<T_submit_platform_base_info> list=taskService.companycode(subject_no);
        logger.info("查询结果为："+list);



    }
}
