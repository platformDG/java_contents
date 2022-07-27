package com.varxyz.jvx330.lifecyle.example3;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecyle.AppConfig;

public class Horse implements InitializingBean , DisposableBean {
	private static int count;
	
	public Horse() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(count + "hores aps");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println(count + "hores des");
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context  =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		System.out.println("Horse's final count " + Horse.getCount());
		context.close();
	}

	

	
}
