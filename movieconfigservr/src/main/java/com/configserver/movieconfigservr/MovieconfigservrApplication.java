package com.configserver.movieconfigservr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MovieconfigservrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieconfigservrApplication.class, args);
	}
}
