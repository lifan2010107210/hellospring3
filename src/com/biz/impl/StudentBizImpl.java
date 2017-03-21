package com.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IStudentBiz;
import com.dao.IStudentDao;
import com.entity.Student;

@Service
public class StudentBizImpl implements IStudentBiz{

	@Resource
	private IStudentDao sdao;
	
	public IStudentDao getSdao() {
		return sdao;
	}

	public void setSdao(IStudentDao sdao) {
		this.sdao = sdao;
	}


	@Override
	public List<Student> listStudents() {
		List<Student> slist = null;
		try {
			slist = sdao.listStudents();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return slist;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentBiz sbiz = ctx.getBean("studentBizImpl", IStudentBiz.class);
		System.out.println(sbiz.listStudents());
	}
	
	@Transactional(rollbackFor=RuntimeException.class)
	public void saveStudent(Student stu) {
		try {
			sdao.saveStudent(stu);
			Integer.parseInt("aaa");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
