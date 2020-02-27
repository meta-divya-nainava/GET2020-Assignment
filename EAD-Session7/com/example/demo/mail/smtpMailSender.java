package com.example.demo.mail;

import org.springframework.stereotype.Component;
/*
 * send mail class to print message on console.
 */
public class smtpMailSender implements MailSender{

	@Override
	public void sendmail() {
		System.out.println("smtp mail");
		
	}

}
