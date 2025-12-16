package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootMsProj06ApiGateWayMiniProject1Application {

	public static void main(String[] args) {
		log.debug("start of main(-) in cloud API gateway");
		SpringApplication.run(BootMsProj06ApiGateWayMiniProject1Application.class, args);
		log.debug("end of main(-) in cloud API gateway");
	}

}
