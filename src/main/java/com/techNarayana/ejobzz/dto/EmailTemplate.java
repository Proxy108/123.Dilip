/*package com.techNarayana.ejobzz.dto;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplate {
	public String from;
	public String to;
	public String subject;
	public String password;
	public String bodytxt;
	
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBodytxt() {
		return bodytxt;
	}
	public void setBodytxt(String bodytxt) {
		this.bodytxt = bodytxt;
	}
	
	
	public Properties getMailProperties() {
		return mailProperties;
	}
	public void setMailProperties(Properties mailProperties) {
		this.mailProperties = mailProperties;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MimeMessage getMimeMessage(String to){
    	
		
		MimeMessage message = javaMailSender.createMimeMessage();
		try{
			 
			  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			
              message.setSentDate( new java.util.Date());
			  }catch(Exception ex){
				  
			  }

		return message;
    }
	
	
}
*/