package com.cogent.ecommerce.repository;

import java.util.Optional;

import com.cogent.ecommerce.model.User;

public interface UserRepository {
	public String addUser(User user);
	public User getUserName(String userName );
	public String getUserById(String userId);

	public void deleteAll();
	public Optional<String> deleteUserById(String userId);

}
