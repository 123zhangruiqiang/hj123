package com.zhangruiqiang.mapper;

import com.zhangruiqiang.pojo.T_submit_platform_base_info;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface PlatformMapper {

  public List<T_submit_platform_base_info> select_platform();
}
