package DependencyInjectionByNameWithQualifiers.mail;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/*
 * send mail class to print message on console.
 */
@Component("smtpmail")
public class smtpMailSender implements MailSender{

	@Override
	public void sendmail() {
		System.out.println("smtp mail");
		
	}

}
