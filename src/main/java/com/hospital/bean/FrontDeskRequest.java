package com.hospital.bean;

public class FrontDeskRequest {
	
	private String specialistType;
	private String hospitalId;
	private String port;
	private String url;
	private String env;
	
	public String getSpecialistType() {
		return specialistType;
	}
	public void setSpecialistType(String specialistType) {
		this.specialistType = specialistType;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	
}
