package com.aroha.SpringJDBCTemplate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aroha.SpringJDBCTemplate.model.Student;

public interface StudentService {

	public Student addStudent(Student student);

	public List<Student> getStudentList();

}
