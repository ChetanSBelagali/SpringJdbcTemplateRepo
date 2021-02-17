package com.aroha.SpringJDBCTemplate.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aroha.SpringJDBCTemplate.Response.StudentResponseObj;
import com.aroha.SpringJDBCTemplate.errors.ErrorCodes;
import com.aroha.SpringJDBCTemplate.model.Student;
import com.aroha.SpringJDBCTemplate.service.StudentService;


@RestController
@RequestMapping("/src/studmaster")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/addStudent/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponseObj<Student>> createStudent(@RequestBody Student student){
		StudentResponseObj<Student> studResObj = new StudentResponseObj<>();
		studentService.addStudent(student);
		studResObj.setData(student);
		studResObj.setStatusAsSuccessWithMessage(ErrorCodes.SUCCESS_MESSAGE.getMessage());
		return new ResponseEntity<>(studResObj, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/getStudents/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponseObj<List<Student>>> getStudentList() {
		List<Student> studentData = studentService.getStudentList();
		StudentResponseObj<List<Student>> studentDataObj = new StudentResponseObj<>();
		studentDataObj.setStatusAsSuccessWithMessage(ErrorCodes.SUCCESS_MESSAGE.getMessage());
		studentDataObj.setData(studentData);
		return new ResponseEntity<>(studentDataObj, HttpStatus.OK);
	}
	
	public String hello(){
		return "Hello";
		
	}

}
