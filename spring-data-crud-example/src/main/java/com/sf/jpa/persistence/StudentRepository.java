package com.sf.jpa.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.jpa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	//public Student findBystudentName(String studentName);
	public List<Student> findBystudentNameLike(String studentName);
	public List<Student> findByStudentNameAndAge(String studentName, int age);
	public List<Student> findByLastName(String lastName);
	

}
