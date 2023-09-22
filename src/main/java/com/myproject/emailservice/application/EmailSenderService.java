package com.myproject.emailservice.application;

import com.myproject.emailservice.adapters.*;
import com.myproject.emailservice.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class EmailSenderService implements EmailSenderUseCase {

	private final EmailSenderGateway emailSenderGateway;

	@Autowired
	public EmailSenderService(EmailSenderGateway emailSenderGateway) {
		this.emailSenderGateway = emailSenderGateway;
	}

	@Override
	public void sendEmail(String to, String subject, String body) {
		this.emailSenderGateway.senderEmail(to,subject,body);
	}
}
