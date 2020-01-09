package com.hospital.bean;

public class Patient {

	private String patientName;
	private String ptaientStatus;
	
	public Patient(String name, String status) {
		this.patientName = name;
		this.ptaientStatus = status;
	}
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPtaientStatus() {
		return ptaientStatus;
	}
	public void setPtaientStatus(String ptaientStatus) {
		this.ptaientStatus = ptaientStatus;
	}
	
}
