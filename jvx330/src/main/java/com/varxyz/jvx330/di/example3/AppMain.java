package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		//String config = "com/varxyz/jvx330/di/example3/beans.xml";
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService ms = context.getBean("memberService", MemberService.class);
		//case1. 람다식
		ms.getAllMember().forEach(member -> System.out.println(member));
		
		//case2. forEach
		for(Member m : ms.getAllMember()) {
			System.out.println(m.toString());
		}
		context.close();
	}

}
