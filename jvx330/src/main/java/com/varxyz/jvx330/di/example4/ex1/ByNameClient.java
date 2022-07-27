package com.varxyz.jvx330.di.example4.ex1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ByNameClient {
	private NamingService namingService;
	
	public NamingService getJmsNamingService() {
		return namingService;
	}
	public void setJmsNamingService(NamingService namingService) {
		this.namingService = namingService;
	}
	public void services(String name) {
		Object o = namingService.lookup(name);
		System.out.println(o);
	}
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example4/ex1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		ByNameClient client = context.getBean("byNameClient", ByNameClient.class);
		client.services("myQueue");
		context.close();
	}
}
