package com.myproject.emailservice.infra.ses;

import com.amazonaws.*;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;
import com.myproject.emailservice.adapters.*;
import com.myproject.emailservice.core.exception.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class SesEmailSender implements EmailSenderGateway {
	private final AmazonSimpleEmailService amazonSimpleEmailService;

	@Autowired
	public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
		this.amazonSimpleEmailService = amazonSimpleEmailService;
	}

	@Override
	public void senderEmail(String to, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest()
						.withSource("jozimarjo@gmail.com")
						.withDestination(new Destination().withToAddresses(to))
						.withMessage(new Message()
										.withSubject(new Content(subject))
										.withBody(new Body().withText(new Content(body)))
						);
		try {
			this.amazonSimpleEmailService.sendEmail(request);
		}catch (AmazonServiceException e){
			throw new EmailServiceException("Failure while sending email",e);
		}
	}
}
