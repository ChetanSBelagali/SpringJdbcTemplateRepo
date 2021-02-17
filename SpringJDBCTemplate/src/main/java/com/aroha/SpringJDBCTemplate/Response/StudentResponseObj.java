package com.aroha.SpringJDBCTemplate.Response;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import lombok.Data;

@Data
public class StudentResponseObj<T> implements Serializable {

	private ServerStatus status;//ERROR or SUCCESS
	private String statusMessage;
	private Map<String, String> errors;
	private T data;

	public void addError(String key, String errorMessage) {
		if (errors == null) {
			errors = new ConcurrentHashMap<String, String>(10);
		}
		errors.put(key, errorMessage);
	}

	public void setStatusAsErrorWithMessage(String errorMessage) {
		status = ServerStatus.ERROR;
		statusMessage = errorMessage;
	}

	public void setStatusAsSuccessWithMessage(String successMessage) {
		status = ServerStatus.SUCCESS;
		statusMessage = successMessage;
	}
}

