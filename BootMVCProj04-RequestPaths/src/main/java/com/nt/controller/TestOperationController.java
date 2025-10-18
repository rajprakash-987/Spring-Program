package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tester") //Controller class level global path
public class TestOperationController {
	
	@GetMapping("/report")
	public String showReport() {
		System.out.println("TestOperationController.showReport()");
		return "display_report2";
	}

}
