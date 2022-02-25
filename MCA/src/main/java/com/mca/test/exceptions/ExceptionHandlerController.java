package com.mca.test.exceptions;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.mca.test.api.DTO.ErrorResponse;
import com.mca.test.config.ApiErrorMessages;


@RestControllerAdvice
public class ExceptionHandlerController {
	/*
	 * All methods returns 404 because there is just have one endpoint, and this
	 * endpoint only returns 200 or 404
	 */
	Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

	@Autowired
	private ApiErrorMessages apiErrorMessages;

	@ExceptionHandler(value = { RuntimeException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse runtimeException(RuntimeException e, HttpServletRequest req, HttpServletResponse res) {
		logRequest(req, e);
		return ErrorResponse.builder().
				date(new Date())
				.errorMessage(apiErrorMessages.getGeneral())
				.build();
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND)
	public ErrorResponse notFoundException(HttpServletRequest req, HttpServletResponse res, NotFoundException e){
		logRequest(req, e);
		return ErrorResponse.builder()
				.date(new Date())
				.errorMessage(apiErrorMessages.getNotFound())
				.build();
	}

	private void logRequest(HttpServletRequest req, RuntimeException e) {
		String path = req.getRequestURI();
		Integer port = req.getServerPort();
		String serverName = req.getServerName();
		logger.error("endpoint: " + serverName + ":" + port + path,  e);
	}
}
