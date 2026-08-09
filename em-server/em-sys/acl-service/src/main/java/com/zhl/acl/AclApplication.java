package com.zhl.acl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.lang.String;

@SpringBootApplication(scanBasePackages = {"com.zhl.acl", "com.zhl.services", "com.zhl.redis"})
public class AclApplication {

	public static void main(String[] args){
		SpringApplication.run(AclApplication.class, args);
	}

}