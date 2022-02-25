package com.mca.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.mca.test.config.ApiErrorMessages;
import com.mca.test.config.ExistingApi;
import com.mca.test.exceptions.RestTemplateResponseErrorHandling;

@SpringBootApplication
@EnableConfigurationProperties({ExistingApi.class, ApiErrorMessages.class})
public class McaApplication {

	public static void main(String[] args) {
		SpringApplication.run(McaApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandling())
				.build();
	}
}
