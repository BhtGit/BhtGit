package jy.test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author BHT 2021/5/16 12:54
 */
public class Test08 {
    public static void main(String[] args) {

        try {
            sendMail("baiht@jyzq.cn", "ceshi", "ceshiceshi123");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 发送邮件的方法
     *
     * @param to  邮箱地址
     * @param msg 发送的信息
     */
    public static void sendMail(String to, String title, String msg) throws Exception {

        // 1.创建连接对象，连接到邮箱服务器
        Properties prop = new Properties();
        // 设置邮件服务器主机名
        prop.setProperty("mail.host", "10.32.50.202");
        // 发送邮件协议名称
        prop.setProperty("mail.transport.protocol", "smtp");
        // 发送服务器需要身份验证
        prop.setProperty("mail.smtp.auth", "false");

        /*
            注意：使用qq邮箱发送需要开启ssl加密
        */
        /*
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.setProperty("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        */

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                //设置发送人的帐号和密码
                return new PasswordAuthentication("", "");
            }
        });

        // 2.创建邮件对象
        Message message = new MimeMessage(session);
        // 2.1 设置发件者
        message.setFrom(new InternetAddress("woca@dell.com"));
        // 2.2 设置收件者
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        // 2.3 设置邮件主题
        message.setSubject(title);
        // 2.4 设置邮件的正文
        message.setContent(msg, "text/html;charset=utf-8");
        message.setSentDate(new Date());

        // 3.发送邮件
        Transport.send(message);
    }

}
