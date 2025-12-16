package com.nt.service;

import java.util.List;

import com.nt.entity.IPLTeam;

public interface IIPLTeamMgmtService {
	public String registerIPLTeam(IPLTeam team);
	public List<IPLTeam> getAllTeam();
	public IPLTeam getTeamById(int teamid) throws Exception;

}
