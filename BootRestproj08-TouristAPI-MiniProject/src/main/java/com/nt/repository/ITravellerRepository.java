package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Traveller;

public interface ITravellerRepository extends JpaRepository<Traveller, Integer> {
	
	@Query(nativeQuery = true,value="select * from TRAVER_INFO where((sysdate-DOB)/365.25)>=:minAge")
	public List<Traveller> fetchTravellersByAge(int minAge);

}
