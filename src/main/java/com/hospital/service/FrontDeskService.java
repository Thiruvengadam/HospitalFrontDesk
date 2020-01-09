package com.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.hospital.bean.AppointmentDetails;
import com.hospital.bean.Hospital;
import com.hospital.bean.Patient;
import com.hospital.bean.Specialist;
import com.hospital.bean.SpecialistDetails;
import com.hospital.exception.HospitalNotFoundException;
import com.hospital.exception.SpecialistNotFoundException;

@Service
public class FrontDeskService {
	
	@Autowired
	private SpecialistDetails specialistDetails;
	
	public List<Specialist> getSpecialistDetails(String specialistType, String hospitalId) {
		List<Specialist> specialistList = new ArrayList<Specialist>();
		boolean hospitalNotFound = true;
		for (Specialist specialist : specialistDetails.getSpecialists()) {
			if (specialist.getHospitalId().equals(hospitalId)) {
				hospitalNotFound = false;
				if (specialist.getType().equals(specialistType)) {
					specialistList.add(specialist);
				}
			}
		}
		if (hospitalNotFound) {
			throw new HospitalNotFoundException();
		}
		if (CollectionUtils.isEmpty(specialistList)) {
			throw new SpecialistNotFoundException();
		}
		System.out.println("Specialist details available");
		return specialistList;
	}

	public AppointmentDetails scheduleAppointment(String specialistName, String day, String patientName) {
		AppointmentDetails appointmentDetails = new AppointmentDetails();
		for (Specialist specialist : specialistDetails.getSpecialists()) {
			if (specialist.getName().equals(specialistName) && specialist.getAvailableDays().contains(day)) {
				appointmentDetails.setSpecialistName(specialistName);
				appointmentDetails.setPatientName(patientName);
				appointmentDetails.setAppointmentDay(day);
				appointmentDetails.setAppointmentTime(specialist.getAvailableTime());
				System.out.println("Appointement Scheduled");
				return appointmentDetails;
			}
		}
		if (StringUtils.isEmpty(appointmentDetails.getSpecialistName())) {
			throw new SpecialistNotFoundException();
		}
		
		return null;
	}

	public String checkAvailableBeds(String hospitalName) {
		List<Hospital> hospitals = getHospitalDetails();
		long noOfBeds = hospitals.stream()
				.filter(hospital -> hospital.getName().equals(hospitalName))
				.flatMap(hospital -> hospital.getPatients().stream())
				.filter(patient -> patient.getPtaientStatus().equalsIgnoreCase("DISCHARGE"))
				.count();
		if(noOfBeds == 0) throw new HospitalNotFoundException();
		System.out.println("Available beds in "+hospitalName+" = "+noOfBeds);
		return "Number of Beds Available is = "+noOfBeds; 
	}

	private List<Hospital> getHospitalDetails() {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		List<Patient> patients = getPatients("abi", "bala", "dina");
		hospitals.add(new Hospital("apollo", patients));
		patients = getPatients("solomon", "gana", "mala","ffg");
		hospitals.add(new Hospital("global", patients));
		patients = getPatients("sara", "mana");
		hospitals.add(new Hospital("cauvery", patients));
		return hospitals;
	}

	private List<Patient> getPatients(String... pname) {
		List<Patient> patients = new ArrayList<Patient>();
		patients.add(new Patient(pname[0], "DISCHARGE"));
		patients.add(new Patient(pname[1], "OCCUPIED"));
		if(pname.length == 3) patients.add(new Patient(pname[2], "DISCHARGE"));
		if(pname.length == 4) patients.add(new Patient(pname[2], "DISCHARGE"));
		return patients;
	}

}
