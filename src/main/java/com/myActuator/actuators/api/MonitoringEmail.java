package com.myActuator.actuators.api;

import com.sun.mail.util.MailSSLSocketFactory;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <h1>  发送邮件类 </h1>
 *
 * @author 风清扬
 * @date 2020/10/19 14:48
 */
@Component
public class MonitoringEmail {

    @Value ("${email.config.myAddress}")
    private  String   myAddress;
    @Value ("${email.config.addresss}")
    private  String addresss;
    @Value ("${email.config.passwordEmail}")
    private  String passwordEmail;
    @Value ("${email.config.monitorEmailTemplate}")
    private  String   monitorEmailTemplate;


    //发送邮件的模板引擎
    @Autowired
    private FreeMarkerConfigurer configurer;




    /**
     * 使用加密的方式,利用465端口进行传输邮件,开启ssl
     */
    @Async
    public  void  templet(String title,Object params) {

        try {
            MimeMessage msg = new MimeMessage(getSessionEmail());
            //发件人地址
            msg.setFrom(new InternetAddress(myAddress));
            //设置收件人,to为收件人,cc为抄送,bcc为密送
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresss, false));
            //设置主题
            msg.setSubject(title);
            msg.setSentDate(new Date());
            //邮件模板设置
            Template template = null;
                template = configurer.getConfiguration().getTemplate(monitorEmailTemplate);
            Map<String, Object> model = new HashMap<>();
            model.put("params", params);
            String text = null;
            text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            Multipart mp = new MimeMultipart();
            MimeBodyPart body = new MimeBodyPart();
            body.setContent(text, "text/html; charset=UTF-8");
            mp.addBodyPart(body);
            msg.setContent(mp);
            msg.saveChanges();
            Transport.send(msg);
            System.out.println("**----**邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取邮件session会话
    public Session getSessionEmail() throws GeneralSecurityException {

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = new Properties();
        //设置发送的协议
        props.setProperty("mail.transport.protocol", "smtp");
        // SSL加密
        MailSSLSocketFactory sf = null;
        sf = new MailSSLSocketFactory();
        // 设置信任所有的主机
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //邮箱发送服务器端口,这里设置为465端口
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

        //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAddress, passwordEmail);
            }
        });
        return session;
        // msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
        //  msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
    }

}
