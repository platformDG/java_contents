package com.varxyz.jvx330.lifecyle.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecyle.AppConfig;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Eagle {
	private String name;
	
	public void attachWings() {
		System.out.println("Eagle의 날개를 달아줍니다.");
	}
	public void  detachWings() {
		System.out.println("Eagle의 날개를 회수줍니다.");
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context  =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Eagle eagle = context.getBean("eagle", Eagle.class);
		System.out.println("Eagle's final name " + eagle.getName());;
		context.close();
	}
}
