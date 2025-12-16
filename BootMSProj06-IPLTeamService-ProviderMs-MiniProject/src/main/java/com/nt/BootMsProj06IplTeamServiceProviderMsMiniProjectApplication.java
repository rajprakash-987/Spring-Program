package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootMsProj06IplTeamServiceProviderMsMiniProjectApplication {

	public static void main(String[] args) {
		log.debug("start main(-) method is iplteam ms");
		SpringApplication.run(BootMsProj06IplTeamServiceProviderMsMiniProjectApplication.class, args);
		log.debug("end main(-) method is iplteam ms");
	}

}
