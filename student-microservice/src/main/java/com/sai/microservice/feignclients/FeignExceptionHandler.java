package com.sai.microservice.feignclients;

import javax.servlet.http.HttpServletResponse;

//import org.json.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class FeignExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
		response.setStatus(e.status());
		return "feignError";
	}

}
