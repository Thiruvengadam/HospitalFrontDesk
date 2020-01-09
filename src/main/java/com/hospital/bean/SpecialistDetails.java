package com.hospital.bean;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "ehosp")
@PropertySource("classpath:specialist.properties")
public class SpecialistDetails {

	private List<Specialist> specialists;

	public List<Specialist> getSpecialists() {
		return specialists;
	}

	public void setSpecialists(List<Specialist> specialists) {
		this.specialists = specialists;
	}

}
