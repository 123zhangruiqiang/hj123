package com.zhangruiqiang.service;

import com.zhangruiqiang.mapper.PlatformMapper;
import com.zhangruiqiang.pojo.T_submit_platform_base_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class platform_Service {

    @Autowired
    private PlatformMapper ptmapper;

    public List<T_submit_platform_base_info> select_platform(){
        List<T_submit_platform_base_info> list=ptmapper.select_platform();
        return list;
    }
}
