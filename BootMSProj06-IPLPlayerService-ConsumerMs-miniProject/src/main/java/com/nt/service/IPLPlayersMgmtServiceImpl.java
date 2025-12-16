package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.advice.PlayerNotfoundException;
import com.nt.entity.IPLPlayer;
import com.nt.repository.IPLPlayersRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class IPLPlayersMgmtServiceImpl implements IIPLplayersMgmtService {
	@Autowired
	private IPLPlayersRepository repo;

	@Override
	public String registerplayers(IPLPlayer players) {
		int idval=repo.save(players).getPid();
		log.info("player is register ");
		return "player is register with id"+idval;
	}

	@Override
	public IPLPlayer findplayersbyid(int id) {
		Optional<IPLPlayer> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		log.error("problem in finding the players");
		throw new PlayerNotfoundException("Players not found");
	}

	@Override
	public List<IPLPlayer> findallplayers() {
		 List<IPLPlayer> players=repo.findAll();
		 return players;
		 
	}

}
