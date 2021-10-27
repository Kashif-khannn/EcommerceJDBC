package com.cogent.ecommerce.service;

import com.cogent.ecommerce.model.User;


public class UserServiceImpl implements UserService{
	private static UserServiceImpl userService;
	
	private UserServiceImpl() {
			
		}
	public static UserService getInstance() {
		if(userService == null) {
			synchronized(UserServiceImpl.class) {
				if(userService == null) {
					userService = new UserServiceImpl();
					return userService;
				}
			}
			
		}
		return userService;
	}

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String deleteUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
