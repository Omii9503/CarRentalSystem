package com.carrental.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.carrental.entities.User;
import com.carrental.service.UserService;

@Controller
public class BookingController {
	@Autowired
	public UserService userService;
	
	@PostMapping("/processBooking")
    public String processPayment(@Valid @ModelAttribute("user")User user,Model model) {
		try {
		    User user1=this.userService.saveUser(user);
			return "redirect:/";
		    }catch(Exception e) {
			e.printStackTrace();
			return "CarsDetailView";
		   }
    }
}
