package com.zhangruiqiang.service;

import com.zhangruiqiang.mapper.TaskMapper;
import com.zhangruiqiang.pojo.T_submit_borrower_newlys;
import com.zhangruiqiang.pojo.T_submit_platform_base_info;
import com.zhangruiqiang.pojo.T_submit_project_base_info;
import com.zhangruiqiang.pojo.T_submit_repay_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    @Autowired
    private TaskMapper taskMapper;

    public Integer platformregistercheck(String subject_no){
       int res= taskMapper.platformregistercheck(subject_no);
       return res;
    }
    public Integer companycodecheck (String subject_no){
        int res =taskMapper.companycodecheck(subject_no);
        return res;
    }

    public List<T_submit_platform_base_info> companycode(String subject_no){
         List<T_submit_platform_base_info> list=taskMapper.companycode(subject_no);
        return list;
    }

    public Integer borrcodecheck(String subject_no){

        int res=taskMapper.borrcodecheck(subject_no);
        return  res;
    }

    public Integer checkdccode(String subject_no){
        int res=taskMapper.checkdccode(subject_no);
        return  res;
    }

    public Integer projecttime(String subject_no){
        int res=taskMapper.projecttime(subject_no);
        return  res;
    }

    public List<T_submit_project_base_info> projecthasloancheck(String subject_no){
        List<T_submit_project_base_info> list=   taskMapper.projecthasloancheck(subject_no);
        return  list;
    }

    public Integer chepjandloanpj(String subject_no){
        int res=taskMapper.chepjandloanpj(subject_no);
        return res;
    }
    public Integer pjcount(String subject_no){
        int res=taskMapper.pjcount(subject_no);
        return res;
    }
    public List<T_submit_repay_info> checkhasnodccount(String subject_no){
        List<T_submit_repay_info> list=taskMapper.checkhasnodccount(subject_no);
        return list;
    }
    public Integer checkpjloan(String subject_no){
        int res=taskMapper.checkpjloan(subject_no);
        return  res;
    }
    public Integer checkbrandpjcount(String subject_no){
        int res=taskMapper.checkbrandpjcount(subject_no);
        return  res;
    }

    public List<T_submit_borrower_newlys>  checknopjbr(String subject_no){
        List<T_submit_borrower_newlys> list=taskMapper.checknopjbr(subject_no);
        return list;
    }

    public  List<T_submit_project_base_info> checknobrpj(String subject_no){
        List<T_submit_project_base_info> list=taskMapper.checknobrpj(subject_no);
        return list;
    }

    public List<Map<String,String>> checktzwithpj(String subject_no){
        List<Map<String,String>> list= taskMapper.checktzwithpj(subject_no);
        return  list;
    }

    public List<Map<String,String>> checkthreeequal(String subject_no){
        List<Map<String,String>> list=taskMapper.checkthreeequal(subject_no);
        return  list;
    }

    public Integer checkthreerepayequal(String subject_no){
        int res=taskMapper.checkthreerepayequal(subject_no);
        return  res;
    }

}
