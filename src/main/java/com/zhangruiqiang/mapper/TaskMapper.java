package com.zhangruiqiang.mapper;

import com.zhangruiqiang.pojo.T_submit_platform_base_info;

import java.util.List;

public interface TaskMapper {

    public Integer platformregistercheck(String subject_no);
    public List<T_submit_platform_base_info> companycode(String subject_no);
}
