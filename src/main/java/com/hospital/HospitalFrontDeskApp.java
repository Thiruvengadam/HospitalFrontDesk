package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@ComponentScan({"com.cts.hospital.controller", "com.cts.hospital.service", "com.cts.hospital.exception","com.cts.hospital.bean"})
@SpringBootApplication
public class HospitalFrontDeskApp {
    
	public static void main(String args[]) {
    	SpringApplication.run(HospitalFrontDeskApp.class, args);
    }
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
}
