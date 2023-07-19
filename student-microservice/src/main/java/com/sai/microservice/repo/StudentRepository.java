package com.sai.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.microservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
