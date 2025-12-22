package com.carrental.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carrental.entities.Cars;
import com.carrental.entities.User;
import com.carrental.helper.Message;
import com.carrental.service.CarService;
import com.carrental.service.UserService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	public CarService carService;
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/{id}")
    public String showCarDetails(@PathVariable("id") int id, Model model) {
        Cars car = carService.getCarById(id);
        model.addAttribute("car", car);
        System.out.println(car);
        return "CarsDetailView";
    }
	
	@PostMapping("/book-car")
	public String bookCar(@Valid @ModelAttribute("user")User user,Model model) {	
		try {
			User user1=this.userService.saveUser(user);
			model.addAttribute("user",new Cars()); 
		    model.addAttribute("message",new Message("Successfully Add A New Car !!","alert-success"));
			return "success";
		    }catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			model.addAttribute("message",new Message("Something Went Wrong !!"+e.getMessage(),"alert-danger"));
			return "CarsDetailView";
		   }
	}
}
