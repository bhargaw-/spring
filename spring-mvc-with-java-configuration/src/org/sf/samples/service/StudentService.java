package org.sf.samples.service;

import java.util.List;

import org.sf.samples.model.Student;

public interface StudentService {
	
	public Student getStudent(int studentId);
	public void addStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteStudent(int studentId);
	public List<Student> getStudentList();
}
