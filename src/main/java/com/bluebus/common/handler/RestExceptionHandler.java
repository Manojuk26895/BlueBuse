package com.bluebus.common.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bluebus.common.exception.BaseException;
import com.bluebus.common.exception.InvalidException;
import com.bluebus.common.exception.RecordNotFoundException;




@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ com.bluebus.common.exception.RecordExistException.class, com.bluebus.common.exception.RecordAlreadyExist.class })
	protected ResponseEntity<Object> handleRecordExistException(final BaseException exe) {
		exe.getHttpStatuCode();
		final ApiResponseBody apiError = new ApiResponseBody(HttpStatus.OK, false);
		apiError.setMessage(exe.getMessage());
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(final ApiResponseBody apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler({ RecordNotFoundException.class })
	protected ResponseEntity<Object> handleRecordNotFoundException(final BaseException exe) {
		exe.getHttpStatuCode();
		final ApiResponseBody apiError = new ApiResponseBody(HttpStatus.OK, false);
		apiError.setMessage(exe.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler({ InvalidException.class })
	protected ResponseEntity<Object> handleInvalidExceptionException(final BaseException exe) {
		exe.getHttpStatuCode();
		final ApiResponseBody apiError = new ApiResponseBody(HttpStatus.OK, false);
		apiError.setMessage(exe.getMessage());
		return buildResponseEntity(apiError);
	}
}
