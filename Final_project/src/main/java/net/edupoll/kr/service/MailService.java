package net.edupoll.kr.service;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class MailService {

	@Autowired
	JavaMailSender mailSender;
	
	public boolean sendTestMail(String target) {
		
		
		//SimpleMessage : text
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setSubject("[test]");
		message.setText("test");
		message.setTo(target);
		message.setFrom("edupoll");
		
		try {
		mailSender.send(message);
		}catch(Exception e) {
			e.getMessage();
			return false;
			
		}
		
		return true;
	}
	
	public boolean sendTestHTMLMail(String target,String uuid) {
		
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);		
		
		try {
			helper.setSubject("test");
			
			
			String text = "<h1>인증메일</h1><hr/>"
					+ "<h1>인증 번호 = " +uuid+"</h1>";
			helper.setText(text,true);
			helper.setTo(target);
			
			
			
			
			mailSender.send(message);
			}catch(Exception e) {
				e.getMessage();
				return false;
				
			}
			
			return  true;
	}
	
	
}


