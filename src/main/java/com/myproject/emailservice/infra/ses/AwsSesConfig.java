package com.myproject.emailservice.infra.ses;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class AwsSesConfig {

	@Value("${aws.accessKeyId}")
	private String awsAccessKey;

	@Value("${aws.secretKey}")
	private String awsSecretKey;

	@Value("${aws.ses.region}")
	private String region;
@Bean
	public AmazonSimpleEmailService amazonSimpleEmailService(){
		return AmazonSimpleEmailServiceClientBuilder
						.standard()
						.withCredentials( new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
						.withRegion(region)
						.build();
	}

}
