package com.order.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample {
	
	@GetMapping(path="/employees")
	public String getWelcomeMessage() {
		return "Hi Application is working";
	}
	@RequestMapping(value="/getEmployeeDetails", method = RequestMethod.GET)
	public String getWelcomeMessage1() {
		return "Hi Application is working";
	}

}
