package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class BootMsProj06IplPlayerServiceConsumerMsMiniProjectApplication {

	public static void main(String[] args) {
		log.debug("main method statred of players");
		SpringApplication.run(BootMsProj06IplPlayerServiceConsumerMsMiniProjectApplication.class, args);
		log.debug("main method enddes of players");
	}

}
