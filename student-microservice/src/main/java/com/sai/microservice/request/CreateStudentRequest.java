package com.sai.microservice.request;

public class CreateStudentRequest {
	
	private long id;

	private String firstName;

	private String lastName;

	private String email;

	private long courseId;
	
	

	public CreateStudentRequest(long id,String firstName, String lastName, String email, long courseId) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseId = courseId;
	}
	
	

	public CreateStudentRequest() {
		super();
	}

	
	


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	

}

