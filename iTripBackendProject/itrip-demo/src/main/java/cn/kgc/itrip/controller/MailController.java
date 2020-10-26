package cn.kgc.itrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

/**
 * <b>邮件控制层</b>
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
@RestController("mailController")
@RequestMapping("/mail")
public class MailController {
    // 邮件发送的核心对象
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/send")
    public String sendMail() throws Exception {
        // 创建邮件信息对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 创建 MimeMessageHelper,true 表示发送的文件含有html文本信息
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        // 设定收件人信息
        messageHelper.setTo("744614632@qq.com");
        // 设定发件人信息
        messageHelper.setFrom("beryttl@163.com");
        // 设置邮箱主题
        messageHelper.setSubject("这是一封来自外太空的邮件！");
        // 设定邮件内容
        String context = "<div style=\"width: 600px; margin: 0 auto;\">" +
                "<h3>亲爱的：</h3>" +
                "<p>你已经成功注册为<strong>爱旅行</strong>会员！</p" +
                "<p>只剩下最后激活您的账号，您的激活码是：<strong style=\"color: red;\">250520</strong></p>" +
                "<p>请在<strong>30</strong>分钟内进行账号激活！</p>" +
                "</div>";
        messageHelper.setText(context,true);
        // 发送邮件
        mailSender.send(mimeMessage);
        return "邮件发送成功！";
    }
}
