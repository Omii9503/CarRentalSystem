package com.carrental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.entities.Admin;
import com.carrental.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	public AdminRepository adminRepository;
	
	@Override
	public String findByEmailAndPassword(String email, String password) {
		Optional<Admin> admin=this.adminRepository.findByEmailAndPassword(email, password);
		if (admin.isPresent()) {
            return "EXIST";
        } else {
        	return "NOTEXIST";
        }
	}

}
