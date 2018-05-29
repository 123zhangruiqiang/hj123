package com.zhangruiqiang.mapper;

import com.zhangruiqiang.pojo.T_submit_borrower_newlys;
import com.zhangruiqiang.pojo.T_submit_platform_base_info;
import com.zhangruiqiang.pojo.T_submit_project_base_info;
import com.zhangruiqiang.pojo.T_submit_repay_info;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TaskMapper {

    public Integer platformregistercheck(String subject_no);
    public Integer companycodecheck(String subject_no);
    public List<T_submit_platform_base_info> companycode(String subject_no);
    public Integer borrcodecheck(String subject_no);
    public Integer checkdccode(String subject_no);
    public Integer projecttime(String subject_no);

    public List<T_submit_project_base_info> projecthasloancheck(String subject_no);
    public Integer chepjandloanpj(String subject_no);
    public Integer pjcount(String subject_no);
    public List<T_submit_repay_info> checkhasnodccount(String subject_no);
    public Integer checkpjloan(String subject_no);
    public Integer checkbrandpjcount(String subject_no);
    public  List<T_submit_borrower_newlys>  checknopjbr(String subject_no);

    public List<T_submit_project_base_info> checknobrpj(String subject_no);
    public List<Map<String,String>> checktzwithpj(String subject_no);
    public List<Map<String,String>> checkthreeequal(String subject_no);
    public Integer checkthreerepayequal(String subject_no);
}
