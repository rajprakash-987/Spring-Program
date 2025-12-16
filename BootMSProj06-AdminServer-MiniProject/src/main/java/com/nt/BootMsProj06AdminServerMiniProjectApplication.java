package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAdminServer
@Slf4j
public class BootMsProj06AdminServerMiniProjectApplication {

	public static void main(String[] args) {
		log.debug("start of main method in admin server");
		SpringApplication.run(BootMsProj06AdminServerMiniProjectApplication.class, args);
		log.debug("start of main method in admin server");
	}

}
