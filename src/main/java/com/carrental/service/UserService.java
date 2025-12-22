package com.carrental.service;

import java.util.List;

import com.carrental.entities.User;

public interface UserService {
	public User saveUser(User user);
	public List<User> getBookingDetails(String email);
}
