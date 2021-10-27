package com.cogent.ecommerce.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cogent.ecommerce.config.config;

public class SpringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2 ways to get the object
		//1. Bean factory
		// 2. application context
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);
		EmployeeService employeeService= applicationContext.getBean(EmployeeService.class);
		// if no name provided in get bean
		// by default it will take an empty stringz`
		System.out.println(employeeService.hashCode());
		System.out.println(employeeService.hashCode());
		
	}

}
