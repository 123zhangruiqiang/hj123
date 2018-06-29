package com.zhangruiqiang.mapper;

import java.util.List;
import java.util.Map;

public interface UpdateDateMapper {

    public List<Map<String,String>> getCompay();
    public void updateComName(String name,String userNo);
    public List<Map<String,String>> getBr();
    public void updateBrName(String name,String userNO);
    public List<String> getPjNo();
    public void updatePjName(String pjNo,String name);

}
