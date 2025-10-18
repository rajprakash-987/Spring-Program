package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class RequestParamDataBindingOperationsController {
	
//	@GetMapping("/data")
//	public String processData(@RequestParam("sno") int no,
//								@RequestParam("sname") String name) {
//		System.out.println("Request Param::"+no+" "+name);
//		
//		//return LVN
//		return "show_result";
//	}
	
//	@GetMapping("/data")
//	public String processData(@RequestParam int sno,
//								@RequestParam(required = false,defaultValue = "pushpa2-The Rule") String sname) {
//		System.out.println("Request Param::"+sno+" "+sname);
//		
//		//return LVN
//		return "show_result";
//	}
	
//	@GetMapping("/data")
//	public String processData(@RequestParam(defaultValue ="3001") int sno,
//								@RequestParam String sname) {
//		System.out.println("Request Param::"+sno+" "+sname);
//		
//		//return LVN
//		return "show_result";
//	}
	
//	@GetMapping("/data")
//	public String processData(@RequestParam(required = false) Integer sno,
//								@RequestParam String sname) {
//		System.out.println("Request Param::"+sno+" "+sname);
//		
//		//return LVN
//		return "show_result";
//	}
	
//	@GetMapping("/data")
//	public String processData(@RequestParam(required = false) Integer sno,
//								@RequestParam String sname,
//								@RequestParam String sadd[],
//								@RequestParam("sadd") List<String> adress,
//								@RequestParam("sadd") Set<String> location) {
//		System.out.println("Request Param::"+sno+" "+sname+" "+Arrays.toString(sadd)+" "+adress+" "+location);
//		
//		//return LVN
//		return "show_result";
//	}
	
//	@GetMapping("/data")
//	public String processData(@RequestParam(required = false) Integer sno,
//								@RequestParam String sname,
//								@RequestParam String sadd) {
//		System.out.println("Request Param::"+sno+" "+sname+" "+sadd);
//		
//		//return LVN
//		return "show_result";
//	}
	@Autowired
	private ServletContext sc;
	@Autowired
	private ServletConfig cg;
	
	@GetMapping("/")
	public String processData(Map<String,Object> map,HttpServletRequest req,HttpServletResponse res,HttpSession ses)throws Exception {
		System.out.println("webApplication name: "+sc.getContextPath());
		System.out.println("DispaterServlet logical name: "+cg.getServletName());
		System.out.println("Request path: "+req.getServletPath());
		System.out.println("Session ID: "+ses.getId());
		//keep the above data in the shared memory as the model attribute
		map.put("webappname", sc.getContextPath());
		map.put("Dslogicalname", cg.getServletName());
		map.put("path", req.getServletPath());
		map.put("sessionID", ses.getId());
		return "show_data";
	}

}
