package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.advice.TeamNotFoundException;
import com.nt.entity.IPLTeam;
import com.nt.repository.IPLTeamRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IPLTeamMgmtServiceIMPl implements IIPLTeamMgmtService {
	@Autowired
	private IPLTeamRepository repo;

	@Override
	public String registerIPLTeam(IPLTeam team) {
		log.info("register ipl team method(service)");
		int idval=repo.save(team).getTeamId();
		return "ipl team saved with id value:"+idval;
	}

	@Override
	public List<IPLTeam> getAllTeam() {
		log.info("get all ipl team method(service)");
		return repo.findAll();
	}

	@Override
	public IPLTeam getTeamById(int teamid)throws Exception {
		log.info("get all ipl team method(service)");	
		return repo.findById(teamid).orElseThrow(()->new TeamNotFoundException("invalid team id"));
	}
	

}
