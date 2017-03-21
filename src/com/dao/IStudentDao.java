package com.dao;

import java.util.List;

import com.entity.Student;

public interface IStudentDao {
	
	List<Student> listStudents();

	void saveStudent(Student stu);
}
