package com.zhangruiqiang.controller;

import com.zhangruiqiang.service.UpdateDateService;
import com.zhangruiqiang.util.MadeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UpdateDataController {



    @Autowired
    UpdateDateService updateDateService;


    @RequestMapping("/updateDate")
    public void updateDate(){

       List<Map<String,String>> list= updateDateService.getCompay();


       for(int i=0;i<list.size();i++){
            String nname=MadeName.madeName();


            Map<String,String> map=list.get(i);
            Map.Entry<String,String> entry= (Map.Entry<String, String>) map.entrySet();
            String userNo=entry.getKey();
            String userType=entry.getValue();

            if("ORGANIZATION".equals(userType)){
                nname="天天乐透"+i;
            }
            updateDateService.updateComName(nname,userNo);



       }


        List<Map<String,String>> list1= updateDateService.getBr();

        for(int i=0;i<list1.size();i++){
            String nname=MadeName.madeName();


            Map<String,String> map=list1.get(i);
            Map.Entry<String,String> entry= (Map.Entry<String, String>) map.entrySet();
            String userNo=entry.getKey();
            String userType=entry.getValue();

            if("ORGANIZATION".equals(userType)){
                nname="洗车行"+i;
            }
            updateDateService.updateBrName(nname,userNo);



        }



        List<String> list2= updateDateService.getPjNo();

        for(int i=0;i<list2.size();i++){


            String pjNO=list2.get(i);
            String nname="借钱，借钱"+i;


            updateDateService.updatePjName(pjNO,nname);



        }

    }


}
