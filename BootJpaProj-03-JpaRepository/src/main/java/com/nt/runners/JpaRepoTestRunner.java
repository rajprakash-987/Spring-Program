package com.nt.runners;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.service.IArtistMgmtService;
@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistMgmtService artistService1;

	@Override
	public void run(String... args) throws Exception {
		/*try {
			String msg=artistService1.removeAtristByIdsInBatch(Arrays.asList(103,104,48,null));
			System.out.println(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//*************************************************************************************
		
		/*try {
			List<Artist> list=artistService1.searchArtistByGivenData("suresh", 30000.0);
			list.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//**************************************************************************************
		
		/*try {
			Optional<Artist> opt =artistService1.fetchArtistById(109);
			if(opt.isEmpty()) {
				System.out.println("Artist not found");
			}
			else {
				System.out.println("Artist found"+opt.get());
				}
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("===============================================");
		
		try {
			Artist proxy=artistService1.loadArtistById(100);
			System.out.println("proxy object class name::"+proxy.getClass()+"super class"+proxy.getClass().getSuperclass());
			
			System.out.println(proxy.getAid());
			System.out.println(proxy.getAname());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}//class
