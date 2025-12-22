package com.carrental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.entities.User;
import com.carrental.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}
	
	public List<User> getBookingDetails(String email) {
		if(userRepository.existsByEmail(email)) {
			List<User> users=this.userRepository.findByEmail(email);
			return users;
		}else {
			return null;
		}
	}

}
