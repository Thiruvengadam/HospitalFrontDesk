package com.hospital.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hospital.bean.FrontDeskRequest;
import com.hospital.bean.Specialist;

@RestController
public class FrontDeskConsumer {

   @Autowired
   RestTemplate restTemplate;
   
   @RequestMapping(value = "${enquire}", method = RequestMethod.POST, produces = { "application/json", "application/xml"})
   public ResponseEntity<List<Specialist>> createProducts(@RequestBody FrontDeskRequest frontDeskRequest) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));
      
      return restTemplate.exchange(frameSpecialistUrl(frontDeskRequest),
    		  HttpMethod.GET,
    		  null,
    		  new ParameterizedTypeReference<List<Specialist>>(){});
    
   }

	private String frameSpecialistUrl(FrontDeskRequest frontDeskRequest) {
		String url = frontDeskRequest.getEnv() + frontDeskRequest.getPort() + frontDeskRequest.getUrl();
		url = url.replace("{hospitalId}", frontDeskRequest.getHospitalId());
		url = url.replace("{specialistType}", frontDeskRequest.getSpecialistType());
		System.out.println(url);
		return url;
	}
	   
}
