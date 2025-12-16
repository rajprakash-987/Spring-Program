package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.entity.IPLTeam;

@FeignClient("TEAM-SERVICE")
public interface IPLTeamServiceMsClient1 {
	
	@GetMapping("/team-api/find/{id}")
	public IPLTeam getTeamById(@PathVariable int id);
}

