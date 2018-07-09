import com.zhangruiqiang.UtilEntity.MailContentTypeEnum;
import com.zhangruiqiang.util.MailSender;

import java.util.ArrayList;

public class TestMail {

    public static void main(String[] args) {
        try {
            new MailSender().title("邮件发送").content("fasong").contentType(MailContentTypeEnum.TEXT).target(new ArrayList<String>(){{
                add("15386943425@163.com");
            }}).send();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
