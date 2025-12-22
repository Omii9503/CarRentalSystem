package com.carrental.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carrental.entities.Cars;
import com.carrental.entities.User;
import com.carrental.helper.Message;
import com.carrental.service.AdminService;
import com.carrental.service.CarService;
import com.carrental.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {
	
	@Autowired
	public CarService carService;
	@Autowired
	public AdminService adminService;
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/")
	public String getAllCars(Model model) {
		List<Cars> cars=carService.getAllCars();
		model.addAttribute("allcars",cars);
		System.out.println(cars);
		return "home";
	}
	
	
	
	@RequestMapping("adminlogin")
	public String getAdmin() {
		return "AdminLogin";
	}
	
	@PostMapping("/admin-login")
	public String adminLogin(@Valid @RequestParam(value="agreement",defaultValue = "false") boolean agreement,@Valid @RequestParam("email")String email,@Valid @RequestParam("password")String password, Model model) {	
		String result=adminService.findByEmailAndPassword(email, password);
		try {
			if(!agreement) {
				throw new Exception("You have Not Agreed Terms and Conditions");
			}
			
			if(result.equals("EXIST")) {
				return "AdminHome";
			}else {
				model.addAttribute("errormessage","Email and Password are not matched !!");
				return "AdminLogin";
			}
		    }catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("message",new Message("Something Went Wrong !!"+e.getMessage(),"alert-danger"));
			return "AdminLogin";
		   }
	}
	
	@RequestMapping("/addcar")
	public String addCar() {
		return "AddNewCar";
	}

	@PostMapping("/add-car")
	public String addNewCar(@Valid @ModelAttribute("cars")Cars cars,@RequestParam(value="agreement",defaultValue = "false") boolean agreement,Model model,BindingResult bindindResult) {	
		try {
			if(!agreement) {
				throw new Exception("You have Not Agreed Terms and Conditions");
			}
			if(bindindResult.hasErrors()) {
				model.addAttribute("user",cars);
				return "AddNewCar";
			}
			Cars car=this.carService.saveCar(cars);
			model.addAttribute("user",new Cars()); 
		    model.addAttribute("message",new Message("Successfully Add A New Car !!","alert-success"));
			return "AddNewCar";
		    }catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user",cars);
			model.addAttribute("message",new Message("Something Went Wrong !!"+e.getMessage(),"alert-danger"));
			return "AddNewCar";
		   }
	}
	
	@RequestMapping("/deletecar")
	public String deleteCar() {
		return "DeleteCar";
	}
	
	@PostMapping("/delete-car")
	public String deleteCarDetails(@ModelAttribute("cars")Cars cars,Model model) {
		String carName=cars.getCarName();
		String result=this.carService.deleteCar(carName);
		if(result.equals("EXIST"))
		{
			model.addAttribute("message",new Message("Successfully Delete Car Data !!","alert-success"));
			return "DeleteCar";
		}else {
			model.addAttribute("message",new Message("Error:The Car Name Not Found to Delete The Data...","alert-danger"));
			return "DeleteCar";
		}
	}
	
	@RequestMapping("/updatecar")
	public String updateCar(Model model) {
		List<Cars> cars=this.carService.getAllCars();
		model.addAttribute("allcarsdata",cars);
		return "Choose";
		//return "UpdateCarData";
	}
	
	@RequestMapping("/updatecardata")
	public String updateCarData(@RequestParam("oldCar")String oldCarName,Model model) {
		if(oldCarName.equals("Select")||oldCarName.equals("")) {
			model.addAttribute("updatecardataerror","Please Select an Car From Given DropDown");
			return "redirect:/updatecar";
		}else {
			Cars car=this.carService.findByCarName(oldCarName);
			model.addAttribute("oldCarName",oldCarName);
			model.addAttribute("carDataToUpdate",car);
			return "UpdateCarData";
		}
	}

	@PostMapping("/update-car")
	public String updateCarDetails(
	        @Valid @RequestParam("oldcarName") String oldCarName,
	        @ModelAttribute("cars") Cars cars,
	        Model model,
	        @RequestParam(value = "agreement", defaultValue = "false") boolean agreement,
	        BindingResult bindingResult
	        ) {
	    try {
	        if (!agreement) {
	            throw new Exception("You have Not Agreed to Terms and Conditions");
	        }
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("carDataToUpdate", cars); // Ensure car data persists on validation error
	            return "UpdateCarData";
	        }
	        String result = this.carService.updateCar(oldCarName, cars);
	        
	        if ("FIND".equals(result)) {
	        	model.addAttribute("updateSuccess","Car Will Update Successfully");
	        	 return "AdminHome";
		        
	        } else {
	            model.addAttribute("updatecardata", "Error: The Car Name Not Found to Update The Data...");
	            model.addAttribute("carDataToUpdate", cars); // Keep the object for Thymeleaf
		        return "UpdateCarData";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("carDataToUpdate", cars);
	        model.addAttribute("message", new Message("Something Went Wrong! " + e.getMessage(), "alert-danger"));
	        return "UpdateCarData";
	    }
	}
	
	@RequestMapping("/get-cars-data")
	public String getCars(Model model) {
		List<Cars> list=this.carService.getAllCars();
		model.addAttribute("allcars",list);
		System.out.println(list);
		return "AllCarDetails";
	}
	
	@PostMapping("/book-car")
	public String bookCar(@Valid @ModelAttribute("user")User user,Model model) {	
		try {
			//User user1=this.userService.saveUser(user);
			model.addAttribute("user",user); 
		    model.addAttribute("message",new Message("Successfully Add A New Car !!","alert-success"));
			return "UserDetail";
		    }catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			model.addAttribute("message",new Message("Something Went Wrong !!"+e.getMessage(),"alert-danger"));
			return "CarsDetailView";
		   }
	}
	
	@GetMapping("/get-user")
	public String userDetails() {
		return "UserDetail";
	}
	
	@GetMapping("/booking-history")
	public String getHistory() {
		return "BookingHistory";
	}
	
	@PostMapping("/get-booking-history")
	public String getBookingDetails(@RequestParam("email")String email,Model model) {
		List<User> user=this.userService.getBookingDetails(email);
		if(user!=null) {
			model.addAttribute("users",user);
			return "BookingDetails";
		}
		else {
			model.addAttribute("message",new Message("Error:User is not Found","alert-danger"));
			return "BookingHistory";
		}
//		
	}
	
	
//	this controller is used for the controlling the filtering operations
	
	@PostMapping("/search-car")
	public String searchCar(@RequestParam("seats")int seat,@RequestParam("segment")String segment,Model model, RedirectAttributes redirectAttributes) {
		List<Cars>cars=this.carService.findBySeatAndCategory(seat,segment);
		if(cars.isEmpty()) {
			redirectAttributes.addFlashAttribute("filtermsg","No cars found with " + seat + " seats in the " + segment + " category. Please try another search or check other cars !!");
			//model.addAttribute("filtermsg","Cars Not Found See Related Cars");
			
			return "redirect:/";
		}
			model.addAttribute("allcars",cars);
			return "home";
	}
	
	
}
