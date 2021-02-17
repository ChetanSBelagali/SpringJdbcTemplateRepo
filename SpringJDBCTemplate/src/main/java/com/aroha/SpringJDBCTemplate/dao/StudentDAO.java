package com.aroha.SpringJDBCTemplate.dao;

import java.util.List;

import com.aroha.SpringJDBCTemplate.model.Student;



public interface StudentDAO {
	
	public Student addStudent(Student student);
	
	public List<Student> getStudentList();

}
