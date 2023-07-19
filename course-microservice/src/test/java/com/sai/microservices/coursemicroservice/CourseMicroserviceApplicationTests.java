package com.sai.microservices.coursemicroservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sai.microservice.entity.Course;
import com.sai.microservice.repo.CourseRepository;
import com.sai.microservice.service.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseMicroserviceApplicationTests {

	@Autowired
	private CourseService courseService;
	

	@MockBean
	private CourseRepository courseRepository;
	
	@Test
	public void getCoursesTest() {
		when(courseRepository.findAll()).
		thenReturn((List<Course>) Stream.of(new Course(1L,"java","morning"),new Course(2L,"oracle","afternoon")).collect(Collectors.toList()));
		assertEquals(2,courseService.getCourses().size());
	}
}
	

