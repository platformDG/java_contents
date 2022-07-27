package com.varxyz.jv300.mod010;

import java.util.*;

public class NamingService {
	private static NamingService obj = new NamingService();
	private Map<String, Object> nmameValuePairs;
	
	private NamingService() {
		nmameValuePairs = new HashMap<String, Object>();
	}
	public static NamingService getInstance() {
		return obj;
	}
	
	public void setAttribute(String name, Object obj) {
		if(!nmameValuePairs.containsKey(name)) {
			nmameValuePairs.put(name, obj);
		}else {
			throw new IllegalArgumentException("This name,"+name+", is already in use.");
		}
	}
	
	public Object getAttribute(String name) {
		return nmameValuePairs.get(name);
	}
	
	public void removeAttribute(String name) {
		nmameValuePairs.remove(name);
	}
}
