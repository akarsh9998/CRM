package com.project.crm.emailIntegration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
	
	private String recepient;
	
	private String msgBody;
	
	private String subject;
	
	private String attachment;

}
