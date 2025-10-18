package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param-api")
public class RequestParamsRestController {
	@GetMapping("/data")
	public ResponseEntity<String> showData(@RequestParam("sno")int no,
												@RequestParam String sname){
	return new ResponseEntity<String>(no+".."+sname, HttpStatus.OK);

}
}