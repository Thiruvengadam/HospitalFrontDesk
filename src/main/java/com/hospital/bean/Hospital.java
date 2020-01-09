package com.hospital.bean;

import java.util.List;

public class Hospital {
	
	private String name;
	private List<Patient> patients;
	
	public Hospital(String name, List<Patient> patients) {
		this.name = name;
		this.patients = patients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
}
