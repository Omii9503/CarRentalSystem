package com.carrental.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.razorpay.*;

@Controller
@RequestMapping("/user")
public class UserController {
	//creating order for payment
	
	@PostMapping("/create_order")
	@ResponseBody
	public String createOrder(@RequestBody Map<String,Object>data) throws Exception
	{
		System.out.println(data);
		int amt=Integer.parseInt(data.get("amount").toString());
		
		var client=new RazorpayClient("rzp_test_nfc97ZVxdEK7lD","gII4QlXRdXR4dRGhmCbi2GCJ");
		
		JSONObject ob=new JSONObject();
		ob.put("amount",amt*100);
		ob.put("currency","INR");
		ob.put("receipt","txn_235425");

		//creating new order
		
		Order order=client.orders.create(ob);
		System.out.println(order);
		
		return order.toString();
	}
}
