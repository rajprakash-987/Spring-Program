package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IArtistRepository;

@Component
public class FinderMethodTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistRepository artistRepo;

	@Override
	public void run(String... args) throws Exception {
		/*artistRepo.findByCategoryEqualsIgnoreCase("HERO").forEach(System.out::println);
		System.out.println("---------------------------");
		artistRepo.readByCategoryIs("HERO").forEach(System.out::println);
		System.out.println("---------------------------");
		artistRepo.getByCategoryIs("HERO").forEach(System.out::println);*/
		
		
		
		/*artistRepo.findByAnameStartingWith("r").forEach(System.out::println);
		System.out.println("---------------------------");
		artistRepo.findByAnameEndingWith("sh").forEach(System.out::println);
		System.out.println("---------------------------");
		artistRepo.findByAnameContaining("m").forEach(System.out::println);
		System.out.println("---------------------------");
		artistRepo.findByAnameContainingIgnoreCase("m").forEach(System.out::println);*/
		
		
		/*artistRepo.findByAnameLike("r%").forEach(System.out::println);  //starting 
		artistRepo.findByAnameLike("%r").forEach(System.out::println);  //ending
		artistRepo.findByAnameLike("%r%").forEach(System.out::println); //containig */
		
//		artistRepo.findByFeeBetween(10000, 1000000).forEach(System.out::println);
		
//		artistRepo.findByCategoryIn(List.of("HERO","villian","electrician")).forEach(System.out::println);
//		artistRepo.readByCategoryIn("HERO","villian","electrician").forEach(System.out::println);
		artistRepo.readByCategoryInOrderByAnameAsc("HERO","villian","electrician").forEach(System.out::println);
		
		

	}

}//class
