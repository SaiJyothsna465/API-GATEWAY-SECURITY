package com.sai.microservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.microservice.entity.Course;
import com.sai.microservice.repo.CourseRepository;
import com.sai.microservice.request.CreateCourseRequest;
import com.sai.microservice.response.CourseResponse;



@Service
public class CourseService {
	Logger logger = LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	CourseRepository courseRepository;

	public CourseResponse createCourse(CreateCourseRequest createCourseRequest) {
		
		Course course=new Course();
		course.setTitle(createCourseRequest.getTitle());
		course.setSlot(createCourseRequest.getSlot());
	
		courseRepository.save(course);
		return new CourseResponse(course);
		
	}
	
	public CourseResponse getById (long id) {
		
		logger.info("Inside getById " + id);
		Course course=courseRepository.findById(id).get();
		return new CourseResponse(course);
	}
	
	public List<Course> getCourses(){
		List<Course> courses=courseRepository.findAll();
		return courses;
	}
	
}
