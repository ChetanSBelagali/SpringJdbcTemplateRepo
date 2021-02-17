package com.aroha.SpringJDBCTemplate.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.aroha.SpringJDBCTemplate.dao.StudentDAO;
import com.aroha.SpringJDBCTemplate.model.Student;
import com.aroha.SpringJDBCTemplate.model.StudentMapper;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	private JdbcTemplate stdJdbcTemplate;

	@Override
	public Student addStudent(Student student) {

		Integer returnPrimaryKey = -1;
		try {
			String sql = "INSERT INTO STUDENT(id,name,marks) "
				+ " VALUES (?,?,?);";

			stdJdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, student.getId());
					ps.setString(2, student.getName());
					ps.setInt(3, student.getMarks());

					return ps;
				}
			});
			return student;
		} catch (Exception e) {
			return null;

		}
	}
	
	@Override
	public List<Student> getStudentList() {
		String sqlSelect = "SELECT * FROM student; ";
		return stdJdbcTemplate.query(sqlSelect, new StudentMapper());
	}

}
