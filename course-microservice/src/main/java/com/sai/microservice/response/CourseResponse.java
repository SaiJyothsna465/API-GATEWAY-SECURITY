package com.sai.microservice.response;

import com.sai.microservice.entity.Course;

public class CourseResponse {
	private long courseId;
	private String title;
	private String slot;
	
	public CourseResponse(Course course) {
		this.courseId=course.getId();
		this.title=course.getTitle();
		this.slot=course.getSlot();
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	
}
