package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		IFirst first = new FirstImpl();
//		System.out.println(first.sayFirst("spring"));
		
		//这种做法只适合java project，如果想用到web project上要使用Listener
		//初始化一个"控制反转"容器，ClassPathXmlApplicationContext查找的是类路径下的主配置文件(src，config,)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//当IoC容器被初始化后，对象已经在容器中了，直接从容器中取出对象，转换了一个接口的变量
		IFirst first = ctx.getBean("firstImpl", IFirst.class);
		//调用对应的方法
		System.out.println(first.sayFirst("my spring!!!!!"));
	}

}
