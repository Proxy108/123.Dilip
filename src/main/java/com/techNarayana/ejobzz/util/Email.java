package com.techNarayana.ejobzz.util;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Email {
	private Properties mailProperties;
	private String fromMail;
	private String password;
	private Logger logger=Logger.getLogger(Email.class);
    public String getFromMail() {
		return fromMail;
	}
	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Properties getMailProperties() {
		return mailProperties;
	}
	public void setMailProperties(Properties mailProperties) {
		this.mailProperties = mailProperties;
	}
	public MimeMessage getMimeMessage(String to){
    	final String username = this.fromMail;
		final String password = this.password;
 
		
		Session session = Session.getInstance(this.getMailProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		try{
			  message.setFrom(new InternetAddress(this.fromMail));
			  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			  message.setReplyTo(InternetAddress.parse(fromMail, false));
              message.setSentDate( new java.util.Date());
			  }catch(Exception ex){
				  
			  }

		return message;
    }
  public void email(String to,String message1,String subject)
  {
	  MimeMessage message=getMimeMessage(to);
	  try{	  
	  message.setText(message1);
	  message.setSubject(subject);
	  Transport.send(message);
	  
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }
	  
  }
  public void invoiceMailToAdmin(String headerHtml, String htmlMessage,HttpServletRequest request){
MimeMessage message=getMimeMessage("orders@sayitwithflowers.in");
	  
	  String subject="Customer Ordered";
	  MimeMultipart multipart = new MimeMultipart("related");
      BodyPart messageBodyPart = new MimeBodyPart();
      
      try {
    	  messageBodyPart.setContent(headerHtml+ htmlMessage, "text/html");
    	  multipart.addBodyPart(messageBodyPart);
          messageBodyPart = new MimeBodyPart();
          String imgpath=request.getSession().getServletContext().getRealPath("/resources/images/logo.jpg");
          InputStream imageStream = new FileInputStream(imgpath); 
          DataSource fds = new ByteArrayDataSource(IOUtils.toByteArray(imageStream), "image/jpg");
          messageBodyPart.setDataHandler(new DataHandler(fds));
          messageBodyPart.setHeader("Content-ID","<image>");
          multipart.addBodyPart(messageBodyPart);
          message.setContent(multipart);
          message.setSubject(subject);
          Transport.send(message);
      	}
      	catch (Exception e) {
		      e.printStackTrace();
		  }
  }
  
  public void sendHtmlEmail(String to,String message1,String subject){
	  MimeMessage message=getMimeMessage(to);
	  
	  try{
		  System.out.println("mail area");
		  message.setContent(message1, "text/html");
		  message.setSubject(subject);
		  Transport.send(message);
	  
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }
  
}
  }
