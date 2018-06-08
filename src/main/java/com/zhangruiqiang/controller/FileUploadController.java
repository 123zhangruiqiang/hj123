package com.zhangruiqiang.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileUploadController {
    @Value("${filepath.osx}")
    private String filepath;
    @Value("${filepath.win}")
    private String filepp;

    @RequestMapping(value = "/uploadfile",method = RequestMethod.GET)
    public String showupload(){
            return "second";
    }
   // public ResponseBody
   @RequestMapping(value = "/dofileupload",method = RequestMethod.POST)
   @ResponseBody
    public  String uploadFile(@RequestParam("file") MultipartFile  multipartFile, HttpServletResponse httpServletResponse,Model model,HttpSession session){
       System.out.println("conmmint");
       // httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        String filename=multipartFile.getOriginalFilename();
            //String filepath="/Users/zhangruiqiang/Desktop/work/hj/src/main/resources";
        File file=new File(filepath,filename);
        System.out.println(filepath);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
      /*  ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("filename",filename);*/
       // model.addAttribute("filename",filename);
        session.setAttribute("filepath",filepath);
        session.setAttribute("filename",filename);
        return filepath+"/"+filename;
    }
    @RequestMapping("/success")
    public String tosuccess(){

        return "success";
    }
    @RequestMapping(value = "download",method = RequestMethod.GET)
    public void download(String filename, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {

        File file=new File(filename);
        BufferedOutputStream bufferedOutputStream=null;
        RandomAccessFile randomAccessFile=null;
        FileInputStream fileInputStream=null;
        System.out.println(file.length());
        long startbyte=0;
        long endbyte=file.length()-1;
        long contentLength=endbyte-startbyte+1;
        long overreadbytes=0;
        int len=0;
        String contentType=httpServletRequest.getServletContext().getMimeType(file.getName());
        System.out.println(contentType);

        httpServletResponse.setContentType(contentType);
        String nfilename=filename.substring(filename.lastIndexOf("/")+1);
     //   String nfilename=new String(filename.substring(filename.indexOf(".")+1).getBytes(),"utf-8");
        System.out.println(nfilename);
        String filen=URLEncoder.encode(nfilename,"utf8");
        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" +filen+";filename*=utf-8"+filen);
       // httpServletResponse.setHeader("content-type","application/octet-streams");
        try {
            randomAccessFile=new RandomAccessFile(file,"r");
            OutputStream outputStream=httpServletResponse.getOutputStream();
            byte[] buff=new byte[2048];
          // len=fileInputStream.read(buff);
            len=randomAccessFile.read(buff);
            while( len !=-1){
                outputStream.write(buff,0,buff.length);
                overreadbytes+=buff.length;
                len=randomAccessFile.read(buff);
            }

            outputStream.flush();
            httpServletResponse.flushBuffer();
            outputStream.close();
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
