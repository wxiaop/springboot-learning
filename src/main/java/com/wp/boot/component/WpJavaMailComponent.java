package com.wp.boot.component;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.wp.boot.configuration.WpJavaMailSenderImpl;
/**
 * 
 * 右键发送组件
 * WpJavaMailComponent
 * 创建人:wenpeng
 * 时间：2017年7月8日-下午5:31:37
 */
@Component
public class WpJavaMailComponent {

	@Autowired
	private WpJavaMailSenderImpl javaMailSender;


	public String send(String email, String text) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		InternetAddress from = new InternetAddress();
		from.setAddress(javaMailSender.getUsername());
		from.setPersonal("WenPengBlog", "UTF-8");
		helper.setFrom(from);
		helper.setTo(email);
		helper.setSubject("测试邮件");
		helper.setText(text, true);
		javaMailSender.send(message);
		return text;
	}



}
