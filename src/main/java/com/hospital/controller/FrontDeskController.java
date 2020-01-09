package com.hospital.controller;

import java.util.List;

import com.hospital.service.FrontDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.bean.AppointmentDetails;
import com.hospital.bean.Specialist;

@RestController
public class FrontDeskController {
	
	@Autowired
	private FrontDeskService frontDeskService;

	@GetMapping(value = "${specialistDetails}", produces = { "application/json", "application/xml" })
	@Cacheable("specialistDetails")
	public List<Specialist> getSpecialistDetails(@PathVariable String specialistType, @PathVariable String hospitalId) {
		List<Specialist> specialistDetails = frontDeskService.getSpecialistDetails(specialistType, hospitalId);
		return specialistDetails;
	}
	
	@GetMapping(value = "${scheduleAppointment}", produces = { "application/json", "application/xml" })
	@Cacheable("appointmentDetails")
	public AppointmentDetails scheduleAppointment(@PathVariable String specialistName, 
			@PathVariable String day, @PathVariable String patientName) {
		return frontDeskService.scheduleAppointment(specialistName, day, patientName);
	}
	
	@GetMapping(value = "${checkAvailableBeds}", produces = { "application/json", "application/xml" })
	@Cacheable("availableBeds")
	public String checkAvailableBedsInHospital(@PathVariable String hospitalName) {
		return frontDeskService.checkAvailableBeds(hospitalName);
	}
	
}
