package org.sf.samples.web;

import java.util.List;

import org.sf.samples.model.Student;
import org.sf.samples.service.util.StudentServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {
	
	@RequestMapping(value = "/getStudents", method = {RequestMethod.GET})
	public ModelAndView getStudents(){
		ModelAndView modelAndView = new ModelAndView("view");
		List<Student> studentList = StudentServiceUtil.getStudentList();
		modelAndView.addObject("student",new Student());
		modelAndView.addObject("studentList", studentList);
		return  modelAndView;
	}
	
	@RequestMapping(value = "/getStudent/{id}", method = {RequestMethod.GET})
	public ModelAndView getStudent(@PathVariable (value = "id") int studentId){
		Student student = StudentServiceUtil.getStudent(studentId);
		return new ModelAndView("edit", "student", student);
	}
	
	@RequestMapping(value ="/addStudent", method = {RequestMethod.POST})
	public ModelAndView addStudent(@ModelAttribute(value="student") Student student){
		logger.info("Add student : "+student.toString());
		StudentServiceUtil.addStudent(student);
		//prevents duplicate form submission		 
		return new ModelAndView("redirect:getStudents");
	}
	
	@RequestMapping(value = "/updateStudent/{id}",  method = {RequestMethod.GET})
	public ModelAndView updateStudent(@PathVariable(value = "id") int studentId){
		Student student = StudentServiceUtil.getStudent(studentId);
		ModelAndView modelAndView = new ModelAndView("view");
		modelAndView.addObject("student", student);
		modelAndView.addObject("operation","UPDATE");
		return modelAndView;
	}
	
	@RequestMapping(value = "/studentUpdate", method = {RequestMethod.POST})
	public ModelAndView studentUpdate(@ModelAttribute(value="student") Student student){
		student = StudentServiceUtil.updateStudent(student);		
		return new ModelAndView("redirect:getStudents");
	}
	
	@RequestMapping(value ="/deleteStudent/{id}")
	public ModelAndView removeStudent(@PathVariable (value = "id") int studentId){
		logger.info("Student id to delete ::"+studentId);
		StudentServiceUtil.deleteStudent(studentId);
		return new ModelAndView("redirect:/getStudents");
	}
	Logger logger = LoggerFactory.getLogger(getClass());
}


