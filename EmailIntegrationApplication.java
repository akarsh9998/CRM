package com.project.crm.emailIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.emailIntegration.controller","com.emailIntegration.services"})
public class EmailIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailIntegrationApplication.class, args);
		
	}

}
