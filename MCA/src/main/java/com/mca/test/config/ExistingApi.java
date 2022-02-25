package com.mca.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties(prefix = "client.existingapi" )
@PropertySource("clientUrl.yaml")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Primary
public class ExistingApi {

	@Value("${baseUrl}")
	private String baseURL;
	
	@Value("${getProduct}")
	private String getProduct;
	
	@Value("${getSimilar}")
	private String getSimilar;

}
