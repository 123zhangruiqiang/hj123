package com.zhangruiqiang.util;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ModelUtil {
    public static String directory="/Users/zhangruiqiang/Desktop/work/hj/src/main/resources/ftl/";

    public static Template getTemplate(String name){
        Configuration configuration=new Configuration(Configuration.getVersion());

        try {
            configuration.setDirectoryForTemplateLoading(new File(directory));
            Template template=configuration.getTemplate(name);
            return  template;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void print(String name, Map<String,Object> root){

        Template template=getTemplate(name);
        try {
            template.process(root,new PrintWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fprint(String name,Map<String,Object> root,String outFile){
        FileWriter fileWriter=null;

        try {
            fileWriter=new FileWriter(new File(outFile));
            Template template=getTemplate(name);
            template.process(root,fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }finally {

                try {
                    if(fileWriter !=null){
                    fileWriter.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void main(String[] args) {
        Map root=new HashMap();
        root.put("name","zrq");
        root.put("address","中国北京");
        print("hello.ftl",root);

        fprint("hello.ftl",root,directory+"/hello.html");
    }

}
