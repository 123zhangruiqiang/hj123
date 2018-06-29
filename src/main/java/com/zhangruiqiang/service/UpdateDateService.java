package com.zhangruiqiang.service;

import com.zhangruiqiang.mapper.UpdateDateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UpdateDateService {


    @Autowired
    UpdateDateMapper updateDateMapper;



    public List<Map<String,String>> getCompay(){

       List<Map<String,String>> list= updateDateMapper.getCompay();

       return  list;
    }

    @Transactional
    public void updateComName(String name,String userNo){

        updateDateMapper.updateComName(name,userNo);
        System.out.println("更新成功");
    }

    public List<Map<String,String>> getBr(){
        List<Map<String,String>> list= updateDateMapper.getBr();

        return  list;
    }
    public void updateBrName(String name,String userNo){
        updateDateMapper.updateBrName(name,userNo);
        System.out.println("更新成功");
    }


    public List<String> getPjNo(){


        List<String> list= updateDateMapper.getPjNo();

        return  list;
    }
    public void updatePjName(String pjNo,String name){

        updateDateMapper.updateBrName(pjNo,name);
        System.out.println("更新成功");
    }

}
