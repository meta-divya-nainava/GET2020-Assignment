/*
 * @author: Divya Nainava
 * @date: 14-02-2020
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mail.MailSender;
/*
 * AppContorller class for implementing setter injection and constructor injection with java config.
 */
@RestController
public class AppController {
	
	private MailSender mailSenderObject;
	
	/*
	 * method for constructor injection
	 */
	@Autowired
	public AppController(MailSender beanMock) {
		this.mailSenderObject = beanMock;
	} 
	 
	//uncomment below code for setter injection.
	/*
	 * @Autowired public void setMailSender(MailSender beanMock) {
	 * this.mailSenderObject = beanMock; }
	 */
	/*
	 * method for printing message on browser.
	 */
	@GetMapping("/send")
	public String sendMail() {

		mailSenderObject.sendmail();

		return "Mail sent successfully";
	}
}
