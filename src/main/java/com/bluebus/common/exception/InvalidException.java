package com.bluebus.common.exception;

import org.springframework.http.HttpStatus;

public class InvalidException extends BaseException
{

	private static final long serialVersionUID = 1035567739424125356L;

	public InvalidException(String entityKey) {
		super("" + entityKey);
	}

	@Override
	public HttpStatus getHttpStatuCode() {
		return HttpStatus.OK;
	}

}
