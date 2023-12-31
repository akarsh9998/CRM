package com.emailIntegration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;

import org.springframework.stereotype.Service;

import com.project.crm.emailIntegration.EmailDetails;
import com.project.crm.emailIntegration.EmailService;


@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	public String sendSimpleMail(EmailDetails details)
	{
		try {
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecepient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			
			mailSender.send(mailMessage);
			
			return "Mail sent successfully";
			
		}
		
		catch(Exception e)
		{
			return "Error while sending mail";
		}
	}
	
	public String sendMailWithAttachment(EmailDetails details)
	{
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		
		try {
			mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecepient());
			mimeMessageHelper.setSubject(details.getSubject());
			mimeMessageHelper.setText(details.getMsgBody());
			
			File file=new File(details.getAttachment());
			
			mimeMessageHelper.addAttachment(file.getName(), file);
			
			mailSender.send(mimeMessage);
			return "Mail sent successfully";
			
		}
		catch(MessagingException e)
		{
			return "Error while sending mail!!!";
		}
	}
	
	

}
