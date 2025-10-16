package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeManagementService;

@Controller("empController")
public class EmployeeOperationController {
	@Autowired
	private IEmployeeManagementService empService;
	
	public List<Employee> processEmployessByDesg(String desg1,String desg2,String desg3) throws Exception {
		//use service
		List<Employee> list=empService.fetchEmployeeByDesg(desg1, desg2, desg3);
		return list;		
	}
	
	public String processEmployee(Employee emp)throws Exception {
		//use service
		  String resultmsg=empService.registerEmployee(emp); 
		  return resultmsg; 
	}

}
