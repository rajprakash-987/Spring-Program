package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Dancer;

@Controller
public class DancerOperationController {
	@GetMapping("/")                       //form welcome page
	public String showHomeDetails() {
		//return LVN(welcome page)
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showDancerRegistrationFormPage(@ModelAttribute("dncr") Dancer dcr) {
		//return LVN(welcome page)
		return "dancer_register_form";
	}
	
	@PostMapping("/register")               //form page submission
	public String registerDancer(@ModelAttribute("dancer") Dancer dcr,
									Map<String,Object> map) {
		System.out.println("model class obj data::"+dcr);
		
		//b logic
		if(dcr.getFee()>10000) 
			map.put("feeRange", "costly dancer");  
		else if(dcr.getFee()<=0)
			map.put("feeRange", "Charity Dancer");
		else
			map.put("feeRange", "affodable Range");
	
		return "show_result";
	}

}
