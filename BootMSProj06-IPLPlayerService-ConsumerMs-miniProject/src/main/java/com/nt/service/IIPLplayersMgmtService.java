package com.nt.service;

import java.util.List;

import com.nt.entity.IPLPlayer;

public interface IIPLplayersMgmtService {
	public String registerplayers(IPLPlayer players);
	public IPLPlayer findplayersbyid(int id);
	public List<IPLPlayer> findallplayers();

}
