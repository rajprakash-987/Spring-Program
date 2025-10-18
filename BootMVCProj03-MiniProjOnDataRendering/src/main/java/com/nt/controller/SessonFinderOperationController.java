package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISessionFinderSService;

@Controller
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

}
