package com.project.crm.emailIntegration;
import com.project.crm.emailIntegration.EmailDetails;
public interface EmailService {
	
	//method to send simple mail
	String sendSimpleMail(EmailDetails details);
	
	//method to send mail with attachment
	String sendMailWithAttachment(EmailDetails details);

}
