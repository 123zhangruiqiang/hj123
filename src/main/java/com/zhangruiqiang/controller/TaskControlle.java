package com.zhangruiqiang.controller;

import com.zhangruiqiang.pojo.T_submit_platform_base_info;
import com.zhangruiqiang.pojo.T_submit_project_base_info;
import com.zhangruiqiang.pojo.T_submit_repay_info;
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
    public void dotask(String subject_no){


        logger.info("平台注册地址编码校验，结果应当为0");
       int res= taskService.platformregistercheck(subject_no);
       logger.info("检查结果为："+res);
        logger.info("平台机构或者公司编码校验  结果必须等于0");
        res =taskService.companycodecheck(subject_no);
       logger.info("检查结果为："+res);
        List<T_submit_platform_base_info> list=taskService.companycode(subject_no);
        logger.info("查询结果为："+list);
        logger.info("借款人类型为平台用户 机构或者公司编码校验  结果必须等于0");
        res=taskService.borrcodecheck(subject_no);
        logger.info("检查结果为："+res);
        logger.info("代偿人 机构或者公司编码校验   结果等于0");
        res=taskService.checkdccode(subject_no);
        logger.info("检查结果为："+res);
        logger.info("标的期限为0占比统计");
        res=taskService.projecttime(subject_no);
        logger.info("检查结果为："+res);
        logger.info(" 标的记录与放款明细校验   ******* 验证标的是否存在出借明细，查到的结果是不存在出借记录的标的");
        List<T_submit_project_base_info> list1=taskService.projecthasloancheck(subject_no);
        logger.info("检查结果为："+list1);
        logger.info("判断标的的个数和出借人所出借的标的是否相等，结果最好一致");
        res=taskService.chepjandloanpj(subject_no);
        logger.info("检查结果为："+res);
        res=taskService.pjcount(subject_no);
        logger.info("实际标的的个数"+res);
        logger.info("统计还款记录中的代偿人不在代偿人文件中的个数    结果显示没有代偿人信息的代偿记录");
        List<T_submit_repay_info> list2=taskService.checkhasnodccount(subject_no);
        logger.info("检查结果为："+list2);
        logger.info("校验存在标的是否都存在出借明细");
        res=taskService.checkpjloan(subject_no);
        logger.info("检查结果为："+res);
        logger.info("借款人借款次数与标的数的对比，展示的结果为出借次数与实际标的个数不相同的数量");
        res=taskService.checkbrandpjcount(subject_no);
        logger.info("检查结果为："+res);
    }
}
