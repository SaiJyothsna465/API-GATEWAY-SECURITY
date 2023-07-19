package com.sai.microservices.studentmicroservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sai.microservice.entity.Student;
import com.sai.microservice.repo.StudentRepository;
import com.sai.microservice.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMicroserviceApplicationTests {
	
	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentRepository studentRepository;
	
	
	@Test
	public void getAllStudentsTest() {
		when(studentRepository.findAll()).
		thenReturn((List<Student>)Stream.of(new Student(1L,"sai","jyothsna","sai@gmail.com",1L)).
				collect(Collectors.toList()));
		assertEquals(1,studentService.findAllStudents().size());
	}
	
	

}
