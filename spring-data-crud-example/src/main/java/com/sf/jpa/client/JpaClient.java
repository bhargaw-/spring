package com.sf.jpa.client;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sf.jpa.Config;
import com.sf.jpa.model.Student;
import com.sf.jpa.persistence.StudentRepository;

public class JpaClient {

	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(Config.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		//addStudent(studentRepository);
		System.out.println(studentRepository.findBystudentNameLike("%Bhar%"));
		System.out.println(studentRepository.findByStudentNameAndAge("bhargav", 30));
	}
	public static void addStudent(StudentRepository studentRepository){
		Student student = new Student();
		student.setStudentName("Bhargav");
		student.setDob(new Date());
		student.setAge(30);
		student = studentRepository.save(student);		
		System.out.println("Student Created successfully");
	}

}
