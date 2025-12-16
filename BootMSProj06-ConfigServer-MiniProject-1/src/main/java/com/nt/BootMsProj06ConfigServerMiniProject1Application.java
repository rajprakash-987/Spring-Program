package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableConfigServer
@Slf4j
public class BootMsProj06ConfigServerMiniProject1Application {

	public static void main(String[] args) {
		log.debug("start of main() method in config server");
		SpringApplication.run(BootMsProj06ConfigServerMiniProject1Application.class, args);
		log.debug("end of main() method in config server");
	}

}
