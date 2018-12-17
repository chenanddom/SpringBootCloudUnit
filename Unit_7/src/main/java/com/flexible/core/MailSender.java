package com.flexible.core;

import com.flexible.bean.MailEntity;
import com.flexible.constant.MailContentType;
import com.flexible.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-12-17
 * Time: 13:58
 */
public class MailSender {
    Logger logger = LoggerFactory.getLogger(MailSender.class);

    public static MailEntity entity = new MailEntity();

    /**
     * 设置邮件的标题
     *
     * @param title
     * @return
     */
    public MailSender mailTiltle(String title) {
        entity.setTitle(title);
        return this;
    }

    /**
     * 设置邮件的内容
     *
     * @param content
     * @return
     */
    public MailSender mailContent(String content) {
        entity.setContent(content);
        return this;
    }

    /**
     * 设置邮件内容的类型
     *
     * @param contentType
     * @return
     */
    public MailSender mailContentType(String contentType) {
        entity.setContentType(contentType);
        return this;
    }

    /**
     * 设置发送邮件的目的地址
     *
     * @param targets
     * @return
     */
    public MailSender mailTargets(List<String> targets) {
        entity.setAcceptAddress(targets);
        return this;
    }

    /**
     * 发送邮件
     *
     * @return
     */
    public boolean sendEmail() throws MessagingException, UnsupportedEncodingException {
        //默认使用html内容发送
        if (entity.getContentType() == null) {
            entity.setContentType(MailContentType.HTML.getValue());
        }

        if (StringUtils.isEmpty(entity.getTitle())) {
            logger.warn("mailentity title can not null");
            return false;
        }

        if (StringUtils.isEmpty(entity.getContent())) {
            logger.warn("mailentity content can not null");
            return false;
        }

        if (CollectionUtils.isEmpty(entity.getAcceptAddress())) {
            logger.warn("mailentity targets can not null");
            return false;
        }

        //读取/resource/mail_zh_CN.properties文件内容
        final PropertiesUtil properties = new PropertiesUtil("mail");
        // 创建Properties 类用于记录邮箱的一些属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", properties.getValue("mail.smtp.service"));
        //设置端口号，QQ邮箱给出了两个端口465/587
        props.put("mail.smtp.port", properties.getValue("mail.smtp.prot"));
        // 设置发送邮箱
        props.put("mail.user", properties.getValue("mail.from.address"));
        // 设置发送邮箱的16位STMP口令
        props.put("mail.password", properties.getValue("mail.from.smtp.pwd"));
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");

                return new PasswordAuthentication(userName, password);
            }
        };

        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        String nickName = MimeUtility.encodeText(properties.getValue("mail.from.nickname"));
        InternetAddress form = new InternetAddress(nickName + " <" + props.getProperty("mail.user") + ">");
        message.setFrom(form);

        // 设置邮件标题
        message.setSubject(entity.getTitle());
        //html发送邮件
        if (entity.getContentType().equals(MailContentType.HTML.getValue())) {
            // 设置邮件的内容体
            message.setContent(entity.getContent(), entity.getContentType());
        }
        //文本发送邮件
        else if (entity.getContentType().equals(MailContentType.TEXT.getValue())) {
            message.setText(entity.getContent());
        }
        //发送邮箱地址
        List<String> targets = entity.getAcceptAddress();
        for (int i = 0; i < targets.size(); i++) {
            try {
                // 设置收件人的邮箱
                InternetAddress to = new InternetAddress(targets.get(i));
                message.setRecipient(Message.RecipientType.TO, to);
                // 最后当然就是发送邮件啦
                Transport.send(message);
            } catch (Exception e) {
                continue;
            }

        }
        return true;
    }


}
