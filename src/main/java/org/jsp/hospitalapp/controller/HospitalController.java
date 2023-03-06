package org.jsp.hospitalapp.controller;

import java.util.List;

import org.jsp.hospitalapp.dto.Hospital;
import org.jsp.hospitalapp.dto.ResponseStructure;
import org.jsp.hospitalapp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HospitalController 
{
	@Autowired(required = true)
	HospitalService service;
	
	@PostMapping("/hospital")
	public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital hospital)
	{
		return service.saveHospital(hospital);
	}
	
	@PutMapping("/hospital")
	public ResponseStructure<Hospital>updateHospital(@RequestBody Hospital hospital)
	{
		return service.updateHospital(hospital);
	}
	
	@DeleteMapping("/hospital/{id}")
	public ResponseStructure<String> deleteHospital(@PathVariable int id)
	{
		return service.deleteHospital(id);
	}
	
	@GetMapping("/hospital/{id}")
	public ResponseStructure<Hospital> findHospitalById(@PathVariable int id)
	{
		return service.findHospitalById(id);
	}
	
	@GetMapping("/hospital/all")
	public ResponseStructure<List<Hospital>> findAllHospitals()
	{
		return service.findAllHospitals();
	}
	
}