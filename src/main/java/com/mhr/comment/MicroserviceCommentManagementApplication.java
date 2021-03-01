package com.mhr.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceCommentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCommentManagementApplication.class, args);
	}

}
