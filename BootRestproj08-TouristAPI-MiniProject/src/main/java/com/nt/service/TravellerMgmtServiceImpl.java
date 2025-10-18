package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Traveller;
import com.nt.repository.ITravellerRepository;
@Service
public class TravellerMgmtServiceImpl implements ITravellerMgmtService {
	@Autowired
	private ITravellerRepository travellerRepo;

	@Override
	public String registerTraveller(Traveller traveller) {
		int idVal=travellerRepo.save(traveller).getTid();
		return "Traveller is add with the id value"+idVal;
	}
	
	@Override
	public List<Traveller> showAlltraveller() {
		
		return travellerRepo.findAll().stream().sorted((t1,t2)->t1.getTid().compareTo(t2.getTid())).toList();
	}
	
	@Override
	public Traveller fetchTravellerById(int id) {
		
		return travellerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
	}
	
	@Override
	public String updateTraveller(Traveller traveller) {
		Optional<Traveller> opt=travellerRepo.findById(traveller.getTid());
		if(opt.isPresent()) {
		
			travellerRepo.save(traveller);
			return traveller.getTid()+"Traveller is updated";
		}
		return traveller.getTid()+"Traveller is not found";
	}
	
	@Override
	public String updateTravellerAddress(int tid, String newaddrs) {
		//load object
		Optional<Traveller> opt=travellerRepo.findById(tid);
		if(opt.isPresent()) {
			Traveller traveller=opt.get();
			traveller.setTaddrs(newaddrs);
			travellerRepo.save(traveller);
			return traveller.getTid()+"Traveller is updated";
		}
		return tid+"Traveller is not found";
	}
@Override
	public List<Traveller> showTravellersByAge(int minAge) {
		//use repo
		List<Traveller> list=travellerRepo.fetchTravellersByAge(minAge);
		return list;
	}

}
