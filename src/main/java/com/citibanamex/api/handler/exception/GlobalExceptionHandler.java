package com.citibanamex.api.handler.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.citibanamex.api.model.exception.CustomException;
import com.citibanamex.api.model.exception.ExceptionResponse;


@ControllerAdvice
@RestController
@EnableWebMvc
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(Exception e) throws Exception {
		ExceptionResponse eR = new ExceptionResponse();
		eR.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		eR.setErrorMessage("Internal server error");
		eR.setDescription(e.getMessage());
		eR.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
		logger.info("Http response -" + eR.getCode() + "-" + eR.getDescription() + "-" + eR.getErrorMessage());
		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<ExceptionResponse> specialException(CustomException e) throws Exception {
		ExceptionResponse eR = new ExceptionResponse();
		eR.setCode(HttpStatus.BAD_REQUEST.value());
		eR.setErrorMessage("Bad Request");
		eR.setDescription(e.getMessage());
		logger.info("Http response -" + eR.getCode() + "-" + eR.getDescription() + "-" + eR.getErrorMessage());
		return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<?> handleResourceNotFoundException(final NoHandlerFoundException ex) {
		ExceptionResponse eR = new ExceptionResponse();
		eR.setCode(HttpStatus.NOT_FOUND.value());
		eR.setErrorMessage("Resource Not Found");
		eR.setDescription("Resource you are trying to reach is not found");
		logger.info("Http response -" + eR.getCode() + "-" + eR.getDescription() + "-" + eR.getErrorMessage());
		return new ResponseEntity<ExceptionResponse>(eR, null, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public  ResponseEntity<?> handleUnsupportedMediaTypeException(HttpMediaTypeNotSupportedException ex){
		ExceptionResponse eR = new ExceptionResponse();
		eR.setCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
		eR.setErrorMessage("Unsupported Media Type");
		eR.setDescription("The Media Type used is not allowed");
		return new ResponseEntity<ExceptionResponse>(eR, null, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> handleMissingParams(MissingServletRequestParameterException ex) {
		ExceptionResponse resp = new ExceptionResponse();
		resp.setDescription("Missing Request Parameters");
		resp.setStatus("Fail");
		resp.setCode(HttpStatus.BAD_REQUEST.value());
		resp.setErrorMessage("Parameters missing in the request");
		return new ResponseEntity<ExceptionResponse>(resp, null, HttpStatus.BAD_REQUEST);
	}
}
