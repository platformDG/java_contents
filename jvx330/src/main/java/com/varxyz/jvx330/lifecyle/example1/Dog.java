package com.varxyz.jvx330.lifecyle.example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecyle.AppConfig;

public class Dog implements InitializingBean , DisposableBean{
	private String name;
	
	public Dog() {
		
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet 호출");
		if(name == null) {
			System.out.println("Property Name must be set");
		}else {
			System.out.println(name);
		}
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destory 호출");
	}

	public static void main(String[] args) {
		GenericApplicationContext context  =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Dog dog = context.getBean("dog", Dog.class);
		System.out.println("Dog's final name " + dog.getName());;
		context.close();
	}
	
	

}
