package com.aroha.SpringJDBCTemplate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroha.SpringJDBCTemplate.dao.StudentDAO;
import com.aroha.SpringJDBCTemplate.model.Student;
import com.aroha.SpringJDBCTemplate.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentdao;
	
	public Student addStudent(Student student) {
		return studentdao.addStudent(student);
	}
	
	@Override
	public List<Student> getStudentList() {
		return studentdao.getStudentList();
	}

}
