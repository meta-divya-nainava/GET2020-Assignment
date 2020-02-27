/*
 * @author: Divya Nainava
 * @date: 14-02-2020
 */
package DependencyInjectionWithPrimary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import DependencyInjectionWithPrimary.mail.MailSender;
/*
 * AppContorller class for implementing name injection and primary annotation with annotations to solve multiple bean problem.
 */
@RestController
public class AppController {
	
	@Autowired
	private MailSender mailSenderObject;
	
	
	/*
	 * method for printing message on browser.
	 */
	@GetMapping("/sendPrimary")
	public String sendMail() {

		mailSenderObject.sendmail();

		return "Mail sent successfully";
	}
}
