package com.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.biz.IStudentBiz;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class StudentAction extends ActionSupport {
	
	@Resource
	private IStudentBiz sbiz ;
	
	private Student stu;
	
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public IStudentBiz getSbiz() {
		return sbiz;
	}

	public void setSbiz(IStudentBiz sbiz) {
		this.sbiz = sbiz;
	}
	
	@SuppressWarnings("unchecked")
	public String listStudents(){
		List<Student> slist = sbiz.listStudents();
		Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
		request.put("slist", slist);
		return "success";
	}
	
	public String saveStudent(){
		sbiz.saveStudent(stu);
		return "success";
	}

}
