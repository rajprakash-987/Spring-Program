  package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationController {
	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/report")   //Get mode handler method (GET -G)
	public String showReport(Map<String,Object> map) {
		try {
		//use service
		List<Employee> list=empService.showAllEmployee();
		//keep the result in shared memory
		map.put("empList", list);
		//return LVN
		return "show_report";
		}
		catch(Exception e) {
			e.printStackTrace();
			map.put("errmsg", e.getMessage());
			return "error";
		}
		
	}
	@GetMapping("/register") //form lunching for addEmp
	public String showEmployeeRegistrationPage(@ModelAttribute("emp")Employee emp) {
		//return form page LVN
		return "employee_register";
	}
	
	/*@PostMapping("/register") //form submission for addEmp           //raises double posting prob                             //not a great code
	public String registerEmployee(Map<String,Object>map,@ModelAttribute("emp")Employee emp){
		try {
			//use service
			String msg=empService.registerEmployee(emp);
			List<Employee> list=empService.showAllEmployee();
			
			map.put("resultmsg", msg);
			map.put("empList", list);
			//return lvn
			return "show_report";
		}
		catch(Exception e) {
			e.printStackTrace();
			map.put("errmsg", e.getMessage());
			return "error";
		}
	}*/
	
	/*@PostMapping("/register") //form submission for addEmp (POST -P)                                             // great code
	public String registerEmployee(Map<String,Object>map,@ModelAttribute("emp")Employee emp){
		try {
			String msg=empService.registerEmployee(emp);
			map.put("resultmsg", msg);
			return "redirect:report";   //(Redirection -R) 
			
		}
		catch(Exception e) {
			e.printStackTrace();
			map.put("errmsg", e.getMessage());
			return "error";
		}
		}*/
	
	/*@PostMapping("/register") //form submission for addEmp (POST -P)                                             // great code
	public String registerEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp){
		try {
			String msg=empService.registerEmployee(emp);
			attrs.addFlashAttribute("resultmsg", msg);
			return "redirect:report";   //(Redirection -R) 
			
		}
		catch(Exception e) {
			e.printStackTrace();
			attrs.addFlashAttribute("errmsg", e.getMessage()); //request scop attribute
			return "error";
		}
		}*/
	
	@PostMapping("/register") //form submission for addEmp (POST -P)                                             // great code
	public String registerEmployee(HttpSession ses,@ModelAttribute("emp")Employee emp){
		try {
			String msg=empService.registerEmployee(emp);
			ses.setAttribute("resultmsg", msg);
			return "redirect:report";   //(Redirection -R) 
			
		}
		catch(Exception e) {
			e.printStackTrace();
			ses.setAttribute("errmsg", e.getMessage()); //request scop attribute
			return "error";
		}
		}
	
	@GetMapping("/edit")
	public String showEditFrompage(@RequestParam("no")int no,
									@ModelAttribute("emp")Employee emp)  {
		
		//use service
		Employee emp1=empService.fetchEmployeebyiD(no);
		//copy emp1 obj data to emp obj
		BeanUtils.copyProperties(emp1,emp);
		//return LVN
		return "employee_edit";
			
		
	}
	@PostMapping("/edit")
	public String updateEmployeeDetails(@ModelAttribute("emp")Employee emp,
										RedirectAttributes attrs) {
	try {	
	//use service
	String msg=empService.editEmployee(emp);
	//keep the data in model attribute
	attrs.addFlashAttribute("resultmsg",msg);
	//return lvn
	return "redirect:report";
	}catch(Exception e) {
		e.printStackTrace();
		attrs.addAttribute("errmsg", e.getMessage()); //request scop attribute
		return "error";
	}
 }  
	@GetMapping("/delete")
	public String removeEmployee(@RequestParam("no")int no,
									Map<String,Object> map) {
		try {
		String msg=empService.deleteEmployeeById(no);
		map.put("resultmsg", msg);
		//return lvn
		return "forward:report";
		}catch(Exception e) {
			e.printStackTrace();
			map.put("errmsg", e.getMessage()); //request scop attribute
			return "error";
		}
		
	}
}
