package com.playwiremock.customer.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<VndErrors> handleGenericExceptions(final Exception e) {
		String message = "Exception on API REST calls"; 
		logger.error(message, e);
		return new ResponseEntity<>(new VndErrors(e.getClass().getSimpleName(), message), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(WebClientResponseException.class)
	public ResponseEntity<VndErrors> handleWebClientException(final WebClientResponseException ex) {
		logger.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(), ex.getResponseBodyAsString(),
				ex);
		return new ResponseEntity<>(new VndErrors(ex.getClass().getSimpleName(), "Error from WebClient call"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
