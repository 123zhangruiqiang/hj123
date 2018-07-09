package com.zhangruiqiang.util;

import com.zhangruiqiang.UtilEntity.MailContentTypeEnum;
import com.zhangruiqiang.UtilEntity.MailEntity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import java.util.List;
import java.util.Properties;

public class MailSender {
    private static MailEntity mail=new MailEntity();

    public MailSender title(String title){
        mail.setTitle(title);
        return  this;
    }

    public MailSender content(String content){
        mail.setContent(content);
        return  this;

    }

    public MailSender contentType(MailContentTypeEnum contentType){
        mail.setContentType(contentType.getValue());
        return  this;

    }

    public MailSender target(List<String> targets){

        mail.setList(targets);
        return  this;

    }

    public void send() throws Exception{
        if(mail.getContentType()==null){
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        }

        if(mail.getTitle()==null||mail.getTitle().trim().length()==0){
            throw  new  Exception("邮件标题没有设置，请调用title方法");
        }

        if(mail.getContent()==null||mail.getContent().trim().length()==0){
            throw  new Exception("邮件内容没有设置，请调用content方法");

        }
        if(mail.getList().size()==0){
            throw  new Exception(("邮件收件人没有设置，请调用list方法"));
        }

        final PropertiesUtil properties=new PropertiesUtil("mail");
        final Properties props=new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.host",properties.getValue("mail.smtp.service"));
        props.put("mail.smtp.port",properties.getValue("mail.smtp.port"));
        props.put("mail.user",properties.getValue("mail.from.address"));
        props.put("mail.password",properties.getValue("mail.from.stmp.pwd"));


        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("mail.smtp.host"),props.getProperty("mail.password"));
            }
        };

       //Authenticator authenticator=new Authenticator() {
        //    @Override
        //    protected PasswordAuthentication getPasswordAuthentication() {
        //        String userName=props.getProperty("mail.user");
        //        String password=props.getProperty("mail.password");
       //         return new PasswordAuthentication(userName,password);
        //    }
       // };
//
       // Session mailSession=
       // Session

        Session sessoin=Session.getInstance(props,authenticator);
        MimeMessage mimeMessage=new MimeMessage(sessoin);

        String nickName=MimeUtility.encodeText(properties.getValue("mail.from.nickname"));
        InternetAddress form=new InternetAddress(nickName+"<"+props.getProperty("mail.user")+">");

        mimeMessage.setSubject(mail.getTitle());
        if(mail.getContentType().equals(MailContentTypeEnum.HTML.getValue())){
            mimeMessage.setContent(mail.getContent(),mail.getContentType());

        }
        else if(mail.getContentType().equals(MailContentTypeEnum.TEXT.getValue())){
            mimeMessage.setText(mail.getContent());
        }

        List<String> targets=mail.getList();
        for(int i=0;i<targets.size();i++){
            InternetAddress to=new InternetAddress(targets.get(i));
            mimeMessage.setRecipients(Message.RecipientType.TO,to.getAddress());
            Transport.send(mimeMessage);
        }




    }
}
