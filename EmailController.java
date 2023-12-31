package com.emailIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.crm.emailIntegration.EmailDetails;
import com.project.crm.emailIntegration.EmailService;


@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		String status=emailService.sendSimpleMail(details);
		
		return status;
	}
	
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details)
	{
		String status=emailService.sendMailWithAttachment(details);
		return status;
	}

}
