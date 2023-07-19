package com.sai.microservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sai.microservice.response.CourseResponse;

@FeignClient(value = "course-microservice", path = "/course")
public interface CourseFeignClient {
	
	@GetMapping("/getById/{id}")
	public CourseResponse getById(@PathVariable long id);
	
}
