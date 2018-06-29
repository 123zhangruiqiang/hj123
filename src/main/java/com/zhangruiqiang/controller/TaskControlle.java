package com.zhangruiqiang.controller;

import com.zhangruiqiang.pojo.T_submit_borrower_newlys;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TaskControlle {
    @Autowired
    private TaskService taskService;
    private String subject_no="100000356";


    Logger logger=LoggerFactory.getLogger(TaskControlle.class);

    @RequestMapping(value = "dotask",method =RequestMethod.GET)
    public void dotask(String subject_no){

        int platformcount=taskService.selectptcount(subject_no);

        logger.info("-------------------平台注册地址编码校验-----------------------");
        logger.info("平台注册地址编码校验，结果应该大于1");
        int res= taskService.platformregistercheck(subject_no);
        logger.info("检查结果为："+res);
        if(res==1){
           logger.error("请检查平台的注册地址编码，可能存在问题");
        }
        logger.info("-------------------结束平台注册地址编码校验-----------------------");

        logger.info("-------------------开始平台机构或者公司编码校验------------------------");
        logger.info("平台机构或者公司编码校验  结果必须等于0");
        res =taskService.companycodecheck(subject_no);
       logger.info("检查结果为："+res);

        List<T_submit_platform_base_info> list=taskService.companycode(subject_no);
        logger.info("查询结果为："+list);
        if(res!=0){
            logger.error("请检查平台的注册公司编码，可能存在问题");
            logger.error("结果"+list);
        }
        logger.info("-------------------结束平台机构或者公司编码校验------------------------");

        logger.info("-------------------开始校验企业用户借款人和代偿人的注册编码------------------------");
        logger.info("借款人类型为平台用户 机构或者公司编码校验  结果必须等于0");
        res=taskService.borrcodecheck(subject_no);
        logger.info("检查结果为："+res);
        logger.info("代偿人 机构或者公司编码校验   结果等于0");
        res=taskService.checkdccode(subject_no);
        logger.info("检查结果为："+res);
        logger.info("-------------------平台机构或者公司编码校验结束------------------------");

        logger.info("标的期限为0占比统计");
        float res1=taskService.projecttime(subject_no);
        logger.info("检查结果为："+res1);
        if(res1==0){
            logger.error("标的期限都为0");
        }
        logger.info(" 标的记录与放款明细校验   ******* 验证标的是否存在出借明细，查到的结果是不存在出借记录的标的");
        List<T_submit_project_base_info> list1=taskService.projecthasloancheck(subject_no);
        logger.info("检查结果为："+list1);
        if(list1.size()>0){
            logger.error("存在没有出借明细的标的");
            logger.error("没有出借明细的标的如下:"+list1);
        }
        logger.info("判断标的是否都有出借明细，结果最好一致");
        res=taskService.chepjandloanpj(subject_no);
        logger.info("检查结果为："+res);
        int target=res;
        res=taskService.pjcount(subject_no);
        int end =res;
        if(end >target){
            logger.error("可能存在标的没有出借明细，请检查");
            logger.error("没有存在出借明细的标的的个数可能有"+(end-target));
        }
        logger.info("实际标的的个数"+res);
        logger.info("统计还款记录中的代偿人不在代偿人文件中的个数    结果显示没有代偿人信息的代偿记录");
        List<T_submit_repay_info> list2=taskService.checkhasnodccount(subject_no);
        logger.info("检查结果为："+list2);
        if(list2.size()>0){
            logger.error("还款文件中存在没有代偿人信息的代偿记录,没有代偿人的信息如下"+list2);
        }
        logger.info("校验存在标的是否都存在出借明细");
        res=taskService.checkpjloan(subject_no);
        logger.info("检查结果为："+res);
        logger.info("借款人借款次数与标的数的对比，展示的结果为出借次数与实际标的个数不相同的数量");
        res=taskService.checkbrandpjcount(subject_no);
        if(res>0){
            logger.error("借款人的借款次数与实际标的个数不同，请检查");
        }
        logger.info("检查结果为："+res);
        logger.info("校验没有标的的借款人 ");
        List<T_submit_borrower_newlys>  list3=taskService.checknopjbr(subject_no);
        logger.info("检查结果为："+list3);
        if(list3.size()>0){
            logger.error("没有标的的借款人"+list3);
        }
        logger.info("统计没有借款人的标的");
        List<T_submit_project_base_info> list4=taskService.checknobrpj(subject_no);
        logger.info("检查结果为："+list4);
        if(list4.size()>0){
            logger.error("没有借款人的标的"+list4);
        }

        logger.info("校验标的的总投资人数与出借标的人数的汇总是否一致 ");
        List<Map<String,String>> list5=  taskService.checktzwithpj(subject_no);
        logger.info("检查结果为："+list5);
        if(list5.size()>0){
            logger.error("标的上的总投资人数，和出借标的的人数不一致"+list5);
        }
        logger.info("交易量等于放款交易汇总等于借款人交易汇总的平台个数 ");
        List<Map<String,String>> list6=taskService.checkthreeequal(subject_no);
        logger.info("检查结果为："+list6);
        logger.error("三个数值展示"+list6);
        logger.info("平台待还量等于放款金额汇总减去还款金额汇总减去代偿金额汇总的个数 ");
        res=taskService.checkthreerepayequal(subject_no);
        logger.info("检查结果为："+res);
        if(platformcount>res){
            logger.error("未还款总金额不等于出借金额减去还款金额");
            logger.error("一共有"+res+"个");
            logger.error("检查结果三个值相等的有"+res);
        }
        logger.info("检查标的金额和出借标的金额不相等的个数");
        List<Map<String,String>> list7=taskService.checkpjmwithlom(subject_no);
        logger.info("检查结果为"+list7);
        if(list7.size()>0){
         logger.error("存在标的的借款金额和出借人出借金额不相等的数据");
         logger.error("不相同的个数为"+list7.size());
         logger.error("结果为"+list7);
        }
        logger.info("统计没有标的的出借明细和没有出借明细的标的");
        List<Map<String,String>> list8=taskService.checkpjandloan(subject_no);
        if (list8.size()>0) {
            logger.error("存在没有标的的出借明细或者没有出借明细的标的");
            logger.error("结果如下"+list8);

        }

        logger.info("统计投资人中的充值或提现金额字段是否为0");
        res=taskService.checkinvesbyzero(subject_no);
        if(res>0){
            logger.error("检查投资人的流入资金和流出资金");

        }

        logger.info("借款人的借款金额与其所借的所有标的的金额汇总是否相等");
        List<Map<String,String>> list9=taskService.checkbrmoneywithpjmoney(subject_no);
        if (list9.size()>0){
            logger.error("存在借款人的借款金额与其所借的总标金额大小不相等");
            logger.error("检查结果为"+list9);
        }


        logger.info("还款和标的相对应的个数是否相等");
        List<Map<String,Object>> list10=taskService.checkhkandpjcount(subject_no);
        if(list.size()>0){
          //  String a=list10.get(0).get("INN").toString();
            int inn =Integer.valueOf(list10.get(0).get("INN").toString());
            int lef=Integer.valueOf(list10.get(0).get("LEF").toString());
            if(lef-inn>0){
                logger.error("还款和标的相对应的个数不相等,存在没有标的的还款");
                logger.error("结果如下"+list10);
            }



        }

        logger.info("------------------------开始验证还款笔数和出借笔数数是否相等----------------------------");

        List<Map<String,Object>> list11=taskService.checkloanandhkcount(subject_no);
        if(list11.size()>0){
            //String a=list11.get(0).get("INN").toString();
            int inn =Integer.valueOf(list11.get(0).get("INN").toString());
            int lef=Integer.valueOf(list11.get(0).get("LEF").toString());
            if(lef-inn>0){
                logger.error("还款笔数和出借笔数不相等,请检查数据");
                logger.error("本次校验结果如下，差值为"+(lef-inn));
            }
        }

        logger.info("------------------------结束验证----------------------------");

    }
}
