package com.mca.test.exceptions;

import org.springframework.stereotype.Component;

@Component
public class MCAException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4887890621851274526L;
	protected String errorMessage;
}
