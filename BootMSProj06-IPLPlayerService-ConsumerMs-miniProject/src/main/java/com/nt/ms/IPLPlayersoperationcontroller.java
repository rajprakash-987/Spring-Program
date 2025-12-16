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

import com.nt.client.IPLTeamServiceMsClient1;
import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.service.IIPLplayersMgmtService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/palyer-api")
@Slf4j
public class IPLPlayersoperationcontroller {
	@Autowired
	private IPLTeamServiceMsClient1 client;
	@Autowired
	private IIPLplayersMgmtService playerservice;
	
	@PostMapping("/save")
	@CircuitBreaker(name = "IPLPLAYER-SERVICE",fallbackMethod = "dofallBackForiplteamComm")
	public ResponseEntity<String> registerPlayers(@RequestBody IPLPlayer players){
		log.debug("register player beginning");
		//get team players id
		int tid=players.getTeam().getTeamId();
		log.debug("team id id gathered");
		//get IPLTeam object from target ms(IPLTeamms)
		IPLTeam team=client.getTeamById(tid);//(microservices intra communication)
		log.debug("ms intra comm is taking place");
		//set team object to players object
		players.setTeam(team);
		log.debug("team is assigned to player object");
		//use service to save player and his team info
		String msg=playerservice.registerplayers(players);
		log.debug("service method is invoke");
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<IPLPlayer>> showAllPlayers(){
		//use service
		List<IPLPlayer> list=playerservice.findallplayers();
		return new ResponseEntity<List<IPLPlayer>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLPlayer> showPlayersById(@PathVariable int id){
		//use service
		IPLPlayer player=playerservice.findplayersbyid(id);
		return new ResponseEntity<IPLPlayer>(player,HttpStatus.OK);
	}
	
	public ResponseEntity<String> dofallBackForiplteamComm(Exception e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
