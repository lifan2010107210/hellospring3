package com.biz;

import java.util.List;

import com.entity.Student;

public interface IStudentBiz {

	List<Student> listStudents();

	void saveStudent(Student stu);
}
