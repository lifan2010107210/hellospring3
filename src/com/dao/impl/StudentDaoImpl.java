package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.commons.StrKit;
import com.dao.IStudentDao;
import com.dbutils.QueryRunnerTemplate;
import com.entity.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Resource
	private QueryRunnerTemplate qr ;
	
	public QueryRunnerTemplate getQr() {
		return qr;
	}

	public void setQr(QueryRunnerTemplate qr) {
		this.qr = qr;
	}

	@Override
	public List<Student> listStudents() {
		List<Student> slist = null;
		try {
			slist = qr.query("select * from student ", new BeanListHandler<>(Student.class));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return slist;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentDao sdao = ctx.getBean("studentDaoImpl", IStudentDao.class);
		System.out.println(sdao.listStudents());
	}

	@Override
	public void saveStudent(Student stu) {
		try {
			qr.update("insert into student values(?,?,?)", new Object[]{StrKit.uuid(),stu.getStuName(),stu.getClsName()});
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
