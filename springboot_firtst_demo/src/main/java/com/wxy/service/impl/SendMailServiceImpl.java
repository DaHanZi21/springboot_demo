package com.wxy.service.impl;

import com.wxy.service.SendMailService;
import com.wxy.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;
    //发送人
    private String from = "1574351429@qq.com";
    //接收人
//    private String to = "1574351429@qq.com";
    //标题
    private String subject = "验证码信息";
    @Override
    public String sendMail(String to) {
        //验证码
        String code = UUIDUtils.getUUID();
        //正文内容
        String context = "请输入激活码："+ code;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from + "(小可爱 ^_^)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
        return code;
    }
}
