package com.myproject.emailservice.controllers;

import com.myproject.emailservice.application.*;
import com.myproject.emailservice.core.*;
import com.myproject.emailservice.core.exception.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

	private final EmailSenderService emailSenderService;

	@Autowired
	public EmailSenderController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	@PostMapping()
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
		try {
			this.emailSenderService.sendEmail(request.to(),request.subject(),request.body());
			return ResponseEntity.ok("Email enviado com sucesso");
		} catch (EmailServiceException e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
		}
	}
}
