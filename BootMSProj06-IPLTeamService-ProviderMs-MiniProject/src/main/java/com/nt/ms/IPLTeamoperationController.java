package com.nt.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.IPLTeam;
import com.nt.service.IIPLTeamMgmtService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/team-api")
@Slf4j
public class IPLTeamoperationController {
	@Autowired
	private IIPLTeamMgmtService teamservice;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team)throws Exception{
		//use service
		String resultMsg=teamservice.registerIPLTeam(team);
		log.info("register team method controller");
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
	}
	
    @GetMapping("/all")
	public  ResponseEntity <List<IPLTeam>> showAllTeams()throws Exception{
		//use service
		List<IPLTeam> list=teamservice.getAllTeam();
		log.info("register team method controller");
		return new ResponseEntity<List<IPLTeam>>(list,HttpStatus.OK);
	}
    
    @GetMapping("/find/{id}")
	public  ResponseEntity <IPLTeam> showAllTeams(@PathVariable int id)throws Exception{
		//use service
		IPLTeam team=teamservice.getTeamById(id);
		log.info("show  team id method controller");
		return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
	}
    
    

}
