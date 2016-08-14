package org.sf.samples.service.util;

import java.util.List;

import org.sf.samples.model.Student;
import org.sf.samples.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceUtil {

	
	private static StudentService studentService;
	
	@Autowired
	public StudentServiceUtil(StudentService studentService){
		StudentServiceUtil.studentService = studentService;
	}
	
	public static Student getStudent(int studentId) {
		return studentService.getStudent(studentId);
	}

	public static void addStudent(Student student) {
		studentService.addStudent(student);
	}

	public static Student updateStudent(Student student) {
		return studentService.updateStudent(student);
	}

	public static void deleteStudent(int studentId) {
		studentService.deleteStudent(studentId);
	}

	public static List<Student> getStudentList() {
		return studentService.getStudentList();
	}
}
