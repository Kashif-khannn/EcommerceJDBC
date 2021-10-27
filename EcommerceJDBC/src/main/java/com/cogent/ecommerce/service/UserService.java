package com.cogent.ecommerce.service;

import com.cogent.ecommerce.model.User;

public interface UserService {
	public String addUser(User user);
	public User getUserName(String userName );
	public String getUserById(String userId);

	public void deleteAll();
	public String deleteUserById(String userId);
}
