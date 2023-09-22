package com.myproject.emailservice.adapters;

public interface EmailSenderGateway {
	public void senderEmail(String to, String subject, String body);
}
