package org.sf.samples.model;

import java.io.Serializable;

public class Student implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private int studentId;
	private String studentName;
	private int studentAge;
	
	public Student(){}
	
	public Student(int studentId, String studentName, int studentAge){
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	@Override
	public int hashCode() {
		return studentId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		
		if( obj instanceof Student){
			Student student = (Student)obj;
			if(studentId == student.getStudentId()){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "[" + studentId + " " + studentName + " " + studentAge + "]";
	}
}
