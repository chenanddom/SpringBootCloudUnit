package com.flexible;

import com.flexible.constant.MailContentType;
import com.flexible.core.MailSender;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-12-17
 * Time: 14:23
 */
public class TestDemo {

    @Test
    public void sendEmail() throws UnsupportedEncodingException, MessagingException {
        new MailSender()
                .mailTiltle("测试邮件")
                .mailContent("测试邮件的内容")
                .mailContentType(MailContentType.HTML.getValue())
                .mailTargets(new ArrayList<String>(){{
                        add("2842477515@qq.com");
                        add("2546128417@qq.com");
                    }
                })
                .sendEmail();
    }

}
