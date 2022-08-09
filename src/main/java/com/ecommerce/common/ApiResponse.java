package com.ecommerce.common;

import lombok.Data;

@Data
public class ApiResponse {
private final boolean success;
private final String message;
public ApiResponse(boolean success, String message) {
	super();
	this.success = success;
	this.message = message;
}



}
