package com.varxyz.jvx330.di.example6;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example5/s01/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		MenuItemController controller = context.getBean("menuItemController", MenuItemController.class);

		controller.addMenu("아메리카노", 2500);
		controller.addMenu("바닐라라떼", 3000);
		controller.addMenu("카페모카(Ice)", 5000);
		controller.addMenu("아이스티", 2000);
		
		System.out.println("전체메뉴 : ");
		for(MenuItem m : controller.getMenuItemList()) {
			System.out.print(m.toString());
		}
		System.out.println("");
		System.out.println("검색 : " + controller.searchMenuItem("아메리카노"));

		context.close();
	}
}
