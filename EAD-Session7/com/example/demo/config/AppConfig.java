
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.mail.MailSender;
import com.example.demo.mail.mockMailSender;
import com.example.demo.mail.smtpMailSender;
/*
 * Configuration class for mapping object
 */
@Configuration
public class AppConfig {
	/*
	 * method will return mockMailSender object.
	 */
	@Bean("beanMock")
	public MailSender getMockMailSender() {
		return new mockMailSender();
	}
	/*
	 * method will return smtpMailSender object.
	 */

	@Bean("beanSmtp")
	public MailSender getSmtpMailSender() {
		return new smtpMailSender();
	}

}
