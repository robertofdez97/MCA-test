package com.mca.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "apierrors")
@PropertySource("errors.yaml")
public class ApiErrorMessages {
	@Value("${general}")
	private String general;

	@Value("${notFound}")
	private String notFound;

}
