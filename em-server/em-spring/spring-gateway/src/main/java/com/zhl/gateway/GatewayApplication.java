package com.zhl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.lang.String;

@SpringBootApplication(scanBasePackages = {"com.zhl.gateway", "com.zhl.redis"})
public class GatewayApplication {

	public static void main(String[] args){
		SpringApplication.run(GatewayApplication.class, args);
	}

}