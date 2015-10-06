package com.techNarayana.ejobzz.util;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.techNarayana.ejobzz.domain.JobseekerRegisterDomain;
 
/**
 * @author Crunchify.com
 * 
 */
 
@Service("EmailServ")
public class EmailAPI {
 
	@Autowired
	private MailSender mailSender; // MailSender interface defines a strategy
										// for sending simple mails
	@Autowired
	JavaMailSenderImpl javaMailSender;
	@Autowired
	FilePath filePath;
	
	public void sendTextMail(String toAddress, String fromAddress, String subject, String msgBody) {
 
		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
		crunchifyMsg.setFrom(fromAddress);
		crunchifyMsg.setTo(toAddress);
		crunchifyMsg.setSubject(subject);
		crunchifyMsg.setText(msgBody);
		mailSender.send(crunchifyMsg);
	}
	public void sendHTMLMail(String toAddress, String fromAddress, String subject, String msgBody) {
		 
		
		Properties mailProperties=new Properties();
		
		
		mailProperties.setProperty("mail.smtp.auth", "true");
		
		mailProperties.setProperty("mail.smtp.ssl.trust", "mail.ejobzz.com");
		
		mailProperties.setProperty("mail.smtp.starttls.enable", "true");
		mailProperties.setProperty("mail.debug", "true");
		javaMailSender.setUsername("admin@ejobzz.com");
		javaMailSender.setPassword("wel123");
		javaMailSender.setHost("mail.ejobzz.com");
		javaMailSender.setPort(587);
		javaMailSender.setJavaMailProperties(mailProperties);
		MimeMessage message = javaMailSender.createMimeMessage();
		System.out.println("mail conf :"+javaMailSender.getHost() +"user :"+javaMailSender.getUsername());
		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("admin@ejobzz.com");
			helper.setTo(toAddress);
			helper.setSubject(subject);
			// use the true flag to indicate the text included is HTML
			helper.setText(msgBody, true);

			// let's include the infamous windows Sample file (this time copied to c:/)

			javaMailSender.send(message);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}
public void sendHTMLMail(String[] toAddress, String fromAddress, String subject, String msgBody) {
		 
		
		Properties mailProperties=new Properties();
		
		
		mailProperties.setProperty("mail.smtp.auth", "true");
		
		mailProperties.setProperty("mail.smtp.ssl.trust", "mail.ejobzz.com");
		
		mailProperties.setProperty("mail.smtp.starttls.enable", "true");
		mailProperties.setProperty("mail.debug", "true");
		javaMailSender.setUsername("admin@ejobzz.com");
		javaMailSender.setPassword("wel123");
		javaMailSender.setHost("mail.ejobzz.com");
		javaMailSender.setPort(587);
		javaMailSender.setJavaMailProperties(mailProperties);
		MimeMessage message = javaMailSender.createMimeMessage();
		System.out.println("mail conf :"+javaMailSender.getHost() +"user :"+javaMailSender.getUsername());
		InternetAddress[] addressTo = new InternetAddress[toAddress.length];
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
		} catch (MessagingException e1) {
			
			e1.printStackTrace();
		}
		for (int i = 0; i < toAddress.length; i++) {
			try {
				addressTo[i] = new InternetAddress(toAddress[i]);
				helper.setTo(addressTo[i]);
			} catch (AddressException e) {
				
				e.printStackTrace();
			} catch (MessagingException e) {
				
				e.printStackTrace();
			}
		}
		
		
		// use the true flag to indicate you need a multipart message
		
		try {
			
			helper.setFrom("admin@ejobzz.com");
			helper.setTo(addressTo);
			
			helper.setSubject(subject);
			// use the true flag to indicate the text included is HTML
			helper.setText(msgBody, true);
			

			// let's include the infamous windows Sample file (this time copied to c:/)

			javaMailSender.send(message);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}
	
public void sendHTMLMail(String toAddress, String subject) {
		 
		
		Properties mailProperties=new Properties();
		
		
		mailProperties.setProperty("mail.smtp.auth", "true");
		
		mailProperties.setProperty("mail.smtp.ssl.trust", "mail.ejobzz.com");
		
		mailProperties.setProperty("mail.smtp.starttls.enable", "true");
		mailProperties.setProperty("mail.debug", "true");
		javaMailSender.setUsername("admin@ejobzz.com");
		javaMailSender.setPassword("wel123");
		javaMailSender.setHost("mail.ejobzz.com");
		javaMailSender.setPort(587);
		javaMailSender.setJavaMailProperties(mailProperties);
		MimeMessage message = javaMailSender.createMimeMessage();
		System.out.println("mail conf :"+javaMailSender.getHost() +"user :"+javaMailSender.getUsername());
		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("admin@ejobzz.com");
			helper.setTo(toAddress);
			helper.setSubject(subject);
			// use the true flag to indicate the text included is HTML
			helper.setText(subject, true);

			// let's include the infamous windows Sample file (this time copied to c:/)

			javaMailSender.send(message);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}


public void sendHTMLMail(String toAddress, String fromAddress, String subject, String msgBody,JobseekerRegisterDomain dom) {
	 
	
	Properties mailProperties=new Properties();
	
	
	mailProperties.setProperty("mail.smtp.auth", "true");
	
	mailProperties.setProperty("mail.smtp.ssl.trust", "mail.ejobzz.com");
	
	mailProperties.setProperty("mail.smtp.starttls.enable", "true");
	mailProperties.setProperty("mail.debug", "true");
	javaMailSender.setUsername("admin@ejobzz.com");
	javaMailSender.setPassword("wel123");
	javaMailSender.setHost("mail.ejobzz.com");
	javaMailSender.setPort(587);
	javaMailSender.setJavaMailProperties(mailProperties);
	MimeMessage message = javaMailSender.createMimeMessage();
	System.out.println("mail conf :"+javaMailSender.getHost() +"user :"+javaMailSender.getUsername());
	// use the true flag to indicate you need a multipart message
	MimeMessageHelper helper;
	try {
		helper = new MimeMessageHelper(message, true);
		helper.setFrom("admin@ejobzz.com");
		helper.setTo(toAddress);
		helper.setSubject(subject);
		// use the true flag to indicate the text included is HTML
		helper.setText(msgBody, true);
		FileSystemResource file = new FileSystemResource(filePath.getResumePath()+"resume\\"+dom.getResumePath());
		helper.addAttachment(file.getFilename(), file);
		

		// let's include the infamous windows Sample file (this time copied to c:/)

		javaMailSender.send(message);
	} catch (MessagingException e) {
		
		e.printStackTrace();
	}
	
}
}
