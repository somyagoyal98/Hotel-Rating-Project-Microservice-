package com.microservice.user.service.Services;

import java.util.List;

import com.microservice.user.service.entity.User;

public interface UserService {

	User saveUser(User user);
	List<User> getAllUsers();
	User getUser(String id);
}
