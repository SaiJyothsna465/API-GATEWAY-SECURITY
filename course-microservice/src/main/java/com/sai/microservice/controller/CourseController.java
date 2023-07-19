package com.sai.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.microservice.entity.Course;
import com.sai.microservice.request.CreateCourseRequest;
import com.sai.microservice.response.CourseResponse;
import com.sai.microservice.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseService;

	@PostMapping("/create")
	public CourseResponse createCourse (@RequestBody CreateCourseRequest createCourseRequest) {
		return courseService.createCourse(createCourseRequest);
	}
	
	@GetMapping("/getById/{id}")
	public CourseResponse getById(@PathVariable long id) {
		return courseService.getById(id);
	}
	
	@GetMapping("/getCourses")
	public List<Course> findAllCourses(){
		return courseService.getCourses();
	}
	
}

