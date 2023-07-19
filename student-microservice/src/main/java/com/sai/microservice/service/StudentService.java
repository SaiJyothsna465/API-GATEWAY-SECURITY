package com.sai.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.microservice.entity.Student;
import com.sai.microservice.feignclients.CourseFeignClient;
import com.sai.microservice.repo.StudentRepository;
import com.sai.microservice.request.CreateStudentRequest;
import com.sai.microservice.response.StudentResponse;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseFeignClient courseFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setCourseId(createStudentRequest.getCourseId());
		student = studentRepository.save(student);
		StudentResponse studentResponse=new StudentResponse(student);
		studentResponse.setCourseResponse(courseFeignClient.getById(student.getCourseId()));
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student=studentRepository.findById(id).get();
		StudentResponse studentResponse=new StudentResponse(student);
		studentResponse.setCourseResponse(courseFeignClient.getById(student.getCourseId()));
		return studentResponse;
		
	}
	
	public List<Student> findAllStudents(){
		List<Student> students=studentRepository.findAll();
		return students;
	}
	
	

}
