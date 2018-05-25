package com.zhangruiqiang.service;

import com.zhangruiqiang.mapper.TaskMapper;
import com.zhangruiqiang.pojo.T_submit_platform_base_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskMapper taskMapper;

    public Integer platformregistercheck(String subject_no){
       int res= taskMapper.platformregistercheck(subject_no);
       return res;
    }

    public List<T_submit_platform_base_info> companycode(String subject_no){
         List<T_submit_platform_base_info> list=taskMapper.companycode(subject_no);
        return list;
    }


}
