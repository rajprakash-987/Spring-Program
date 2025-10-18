package com.nt.service;

import java.util.List;

import com.nt.entity.Traveller;

public interface ITravellerMgmtService {
	public String registerTraveller(Traveller traveller);
	public List<Traveller> showAlltraveller();
	public Traveller fetchTravellerById(int id);
	public String updateTraveller(Traveller traveller);
	public String updateTravellerAddress(int tid,String newaddrs);
	public List<Traveller> showTravellersByAge(int minAge);

}
