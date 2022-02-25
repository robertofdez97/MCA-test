package com.mca.test.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

@Component
public class RestTemplateResponseErrorHandling extends DefaultResponseErrorHandler {
	
	@Override 
	public void handleError(ClientHttpResponse response) throws IOException {
		Series serie = response.getStatusCode().series();
		if(serie.equals(HttpStatus.Series.SERVER_ERROR)) throw new MCAException();
		else if(serie.equals(HttpStatus.Series.CLIENT_ERROR)) throw new NotFoundException();
	}
}