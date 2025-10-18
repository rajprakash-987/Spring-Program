package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ISessionFinderSService;
import com.nt.service.SessionFinderServiceImpl;

@Controller
@RequestMapping("/season") //Controller class level global path
public class SessonFinderOperationController {

	@Autowired
	private ISessionFinderSService service;

    
	
	@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}
	@RequestMapping("/season")
	public String showSession(Map<String,Object> map) {
		//use service
		String result=service.FindSession();
		//keep the data in shsred memory
		map.put("resultMsg", result);
		//return LVN
		return "display";
		
	}
	//**************************************************************************
	/*@RequestMapping({"/report1","/report2","/report3"})
	public String showReport1() {
		System.out.println("SessonFinderOperationController.showReport1()");
		return "display_report1";
	}
	
	@RequestMapping("/REPORT")
	public String showReport2() {
		System.out.println("SessonFinderOperationController.showReport2()");
		return "display_report2";
	}*/
	//*****************************************************************************
	
//	@RequestMapping("/report")   //byDefault GET mode request
//	@RequestMapping(value="/report",method=RequestMethod.GET) 
	@GetMapping("/report")
	public String showReport1() {
		System.out.println("SessonFinderOperationController.showReport1()");
		return "redirect:/tester/report";
	}
	
//	@RequestMapping(value="/report",method=RequestMethod.POST)
//	@PostMapping("/report")
//	public String showReport2() {
//		System.out.println("SessonFinderOperationController.showReport2()");
//		return "display_report2";
//	}

}
