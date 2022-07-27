package com.varxyz.jv300.mod011;

import java.util.*;

public class UserService {
	private static final UserService userService = new UserService();
	private List<User> userList = new ArrayList<User>();
	private UserDao userDao;
	
	private UserService() {
		userDao = new UserDao();
	}
	public static UserService getInstance() {
		return userService;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	public void addUserInfo(User user) {
		userDao.addUser(user);
	}
	public List<User> getAllUsers() {
		return userDao.findAllUsers();
	}
	
	public User getFindUser(String name) {
		return userDao.findUserByName(name);
	}
	
	public void setUpdateUser(User user) {
		userDao.updateUser(user);
	}
	public boolean isValidUser(String userId, String passwd) {
		if(userDao.isValidUser(userId, passwd)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
