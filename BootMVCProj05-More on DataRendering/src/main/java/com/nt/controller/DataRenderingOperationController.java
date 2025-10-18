package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Student;

@Controller
public class DataRenderingOperationController {
	
	@GetMapping("/data")
	public String showData(Map<String,Object> map) {
		/*
		//add model attribute(Simple value)
		map.put("name", "raja");
		map.put("age", "30");*/
		
		//************************************************************
		//add model attribute(Arrays and Collection)
		/*map.put("favColor", new String[] {"red","maron","cylon"});
		map.put("friends", List.of("raja","rani","hari","gulu"));
		map.put("PhoneNumber", Set.of("99999999999","8888888888","777777777"));
		map.put("iddetails", Map.of("adhar",89898979,"pan",789789,"panNo",34567654));*/
		
		//*************************************************************
		//add model Attribute(Model class object)
		Student std=new Student(1001,"raja","hyd",90.f);
		map.put("stdDetails", std);
		
		//*************************************************************
		//add model Attribute(Collection of Model class object)
		Student std1=new Student(1001,"raja","hyd",90.f);
		Student std2=new Student(1002,"gudu","blr",80.f);
		Student std3=new Student(1003,"suresh","odi",78.f);
		Student std4=new Student(1004,"ramesh","mark",60.f);
		List<Student> list=List.of(std1,std2,std3);
		map.put("stdList", list);
		
		
		//return LVN
		return "show_data";
		
		
		
	}

	
	

}
