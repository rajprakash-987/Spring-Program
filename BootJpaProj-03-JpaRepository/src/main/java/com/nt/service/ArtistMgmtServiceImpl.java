package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.IArtistRepository;

@Service("artistservice")
public class ArtistMgmtServiceImpl implements IArtistMgmtService {
	@Autowired
	private IArtistRepository artistRepo;
	
	@Override
	public String removeAtristByIdsInBatch(List<Integer> ids) {
		//Load obj by ids
		List<Artist> list=artistRepo.findAllById(ids);
		//delete obj by ids in batch processing
		artistRepo.deleteAllByIdInBatch(ids);
		return list.size()+"record deleted";
	}
	
	@Override
	public List<Artist> searchArtistByGivenData(String name, double income) {
		Artist artist=new Artist();
		artist.setAname(name);
		artist.setFee(income);
		Example<Artist> example=Example.of(artist);
		List<Artist> list=artistRepo.findAll(example);
		return list;
	}

	@Override
	public Optional<Artist> fetchArtistById(int id) {
		return artistRepo.findById(id);
	}

	@Override
	public Artist loadArtistById(int id) {	
		return artistRepo.getReferenceById(id);
	}
	
	
		


}//class

