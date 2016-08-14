package org.sf.samples.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sf.samples.model.Student;
import org.sf.samples.service.StudentService;
import org.springframework.stereotype.Repository;

@Repository
public class StudentServiceImpl implements StudentService {
	
	private static Map<Integer, Student> studentMap = Collections.emptyMap();
	
	public StudentServiceImpl(){
		studentMap = new HashMap<Integer, Student>();
		studentMap.put(1, new Student(1,"Bhargav 1",29));
		studentMap.put(2, new Student(2,"Bhargav 2",28));
		studentMap.put(3, new Student(3,"Bhargav 3",30));
		studentMap.put(4, new Student(4,"Bhargav 4",27));
		studentMap.put(5, new Student(5,"Bhargav 5",31));
	}

	public Student getStudent(int studentId) {
		return studentMap.get(studentId);
	}

	public void addStudent(Student student) {
		int id = studentMap.size()+1;
		student.setStudentId(id);
		studentMap.put(id, student);
	}

	public Student updateStudent(Student student) {
		studentMap.put(student.getStudentId(), student);
		return student;
	}

	public void deleteStudent(int studentId) {
		studentMap.remove(studentId);
	}

	public List<Student> getStudentList() {
		List<Student> studentList = new ArrayList<Student>(studentMap.values());
		return studentList;
	}
}
