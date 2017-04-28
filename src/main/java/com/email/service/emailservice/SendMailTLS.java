package com.email.service.emailservice;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SendMailTLS {

	public static void main(String[] args) {

		final String username = "xyz@gmail.com";
		final String password = "******";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		EmailUtil.sendEmail(session, username, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");

	}
}

/*
 * try {
 * 
 * Message message = new MimeMessage(session); message.setFrom(new
 * InternetAddress("jyotiskhomane@gmail.com"));
 * message.setRecipients(Message.RecipientType.TO,
 * InternetAddress.parse("jyotiskhomane@gmail.com"));
 * message.setSubject("Testing Subject"); message.setText("Dear Mail Crawler," +
 * "\n\n No spam to my email, please!");
 * 
 * Transport.send(message);
 * 
 * System.out.println("Done");
 * 
 * 
 * } catch (MessagingException e) { throw new RuntimeException(e); }
 */