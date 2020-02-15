/*
 * @author: Divya Nainava
 * @date: 14-02-2020
 */
package DependencyInjectionByNameWithQualifiers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import DependencyInjectionByNameWithQualifiers.mail.MailSender;
/*
 * AppContorller class for implementing name injection and qualifiers annotation with annotations to solve multiple bean problem.
 */
@RestController
public class AppController {
	
	@Autowired
	@Qualifier("mockmail")
	private MailSender mailSenderObject;
	
	/*
	 * method for printing message on browser.
	 */
	@GetMapping("/sendQualifier")
	public String sendMail() {

		mailSenderObject.sendmail();

		return "Mail sent successfully";
	}
}
