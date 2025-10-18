package com.nt.controller;

import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class showHomeController {
	
//	@RequestMapping("/home")
//	public String dispHomePage() {
//		//return LVN
//		return "welcome";
//	}
	
//	@RequestMapping("/")
//	public String dispHomePage(Map<String,Object> map) {                  //best
//		System.out.println("Shared memory name::"+map.getClass());
//		//add data/results to shared Memory as the model attribute having name-value pair
//		map.put("sysdate", new Date());
//		map.put("age", new Random().nextInt(100));
//		//return LVN
//		return "welcome";
//	}
	
	//******************************************************************************
	
	/*@RequestMapping("/")
	public String dispHomePage(Model model) {                             //Model
		System.out.println("Shared memory name::"+model.getClass());
		//add data/results to shared Memory as the model attribute having name-value pair
		model.addAttribute("sysdate", new Date());
		model.addAttribute("age", new Random().nextInt(100));
		//return LVN
		return "welcome";
	}*/
	//***********************************************************************************
	/*@RequestMapping("/")
	public String dispHomePage(ModelMap map) {                            //Model Map
		System.out.println("Shared memory name::"+map.getClass());
		//add data/results to shared Memory as the model attribute having name-value pair
		map.addAttribute("sysdate", new Date());
		map.addAttribute("age", new Random().nextInt(100));
		//return LVN
		return "welcome";
	}*/
	//************************************************************************************
	/*@RequestMapping("/home")                                  // we will create our own shared memory
	public Model dispHomePage() {                              // we should change the jsp file name as home.jsp
		//create shared memory
		Model model=new BindingAwareModelMap();
		//add data/results to shared Memory as the model attribute having name-value pair
		model.addAttribute("sysdate", new Date());
		model.addAttribute("age", new Random().nextInt(100));
		//return LVN
		return model;
	}*/
	//***************************************************************************************
	/*@RequestMapping("/home")
	public Map<String,Object> dispHomePage() {
		Map<String,Object> map=new HashMap<>();
		
		//add data/results to shared Memory as the model attribute having name-value pair
		map.put("sysdate", new Date());
		map.put("age", new Random().nextInt(100));
		//return LVN
		return map;
	}*/
	//**************************************************************************************
	/*@RequestMapping("/home")
	public ModelAndView dispHomePage(Model model) {
		//our own shared memory
		ModelAndView mav=new ModelAndView();
		//add data/results to shared Memory as the model attribute having name-value pair
		mav.addObject("sysdate", new Date());
		mav.addObject("age", new Random().nextInt(100));
		//return LVN
		return mav;
	}*/
     //*****************************************************************************
	/*@RequestMapping("/home")
	public void dispHomePage(Map<String,Object> map) {
		//add data/results to shared Memory as the model attribute having name-value pair
		map.put("sysdate", new Date());
		map.put("age", new Random().nextInt(100));
		//return LVN
		
	}*/
	//*******************************************************************************
	/*@RequestMapping("/home")                                        //forwarding
	public String dispHomePage(Map<String,Object> map) {
		System.out.println("showHomeController.dispHomePage()");
		//add data/results to shared Memory as the model attribute having name-value pair
		map.put("sysdate", new Date());
		map.put("age", new Random().nextInt(100));
		//return LVN
		return "forward:report";
		
	}
	@RequestMapping("/report")
	public String showReport(Map<String,Object> map) {
		System.out.println("showHomeController.showReport()");
		map.put("sysTime", LocalTime.now());
		return "show_report";
		
	}*/
	//*********************************************************************************
	@RequestMapping("/home")                                   //reDirecting
	public String dispHomePage(Map<String,Object> map) {
		System.out.println("showHomeController.dispHomePage()");
		//add data/results to shared Memory as the model attribute having name-value pair
		map.put("sysdate", new Date());
		map.put("age", new Random().nextInt(100));
		//return LVN
		return "redirect:report?p1=val1&p2=val2";
		
	}
	@RequestMapping("/report")
	public String showReport(Map<String,Object> map) {
		System.out.println("showHomeController.showReport()");
		map.put("sysTime", LocalTime.now());
		return "show_report";
		
	}
	

}
