package com.varxyz.jv300.mod007;

import java.util.*;

public class UserService {
	private static final UserService userService = new UserService();
	private List<User> userList = new ArrayList<User>();
	
	private UserService() {
		
	}
	public static UserService getInstance() {
		return userService;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}

}
