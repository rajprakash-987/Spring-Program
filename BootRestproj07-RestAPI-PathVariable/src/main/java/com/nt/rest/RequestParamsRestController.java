package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param-api")
public class RequestParamsRestController {
	/*@GetMapping({"/data/{sno}/{sname}","/data/{sno}","/data"})
	public ResponseEntity<String> showData(@PathVariable(value="sno",required = false)Integer no,
												@PathVariable(required = false) String sname){
	return new ResponseEntity<String>(no+".."+sname, HttpStatus.OK);*/
	
	
	@GetMapping("/data/100/raja")
	public String showData1(@PathVariable(value="sno",required = false)Integer no,
												@PathVariable(value="sname" ,required = false) String sname){
	return "fetch data1";
	}
	@GetMapping("/data/{sno}/{sname}")
	public String showData2(@PathVariable(value="sno",required = false)Integer no,
												@PathVariable(value="sname" ,required = false) String sname){
	return "fetch data2";
	}

}