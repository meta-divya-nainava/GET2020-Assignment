package DependencyInjectionWithPrimary.mail;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/*
 * mock mail class to print message on console.
 */
@Component
public class mockMailSender implements MailSender {

	@Override
	public void sendmail() {
		System.out.println("mock mail sender");
		
	}

}
