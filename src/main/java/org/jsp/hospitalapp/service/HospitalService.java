package org.jsp.hospitalapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.hospitalapp.dao.HospitalDao;
import org.jsp.hospitalapp.dto.Hospital;
import org.jsp.hospitalapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class HospitalService 
{
	@Autowired
	HospitalDao dao;
	
	public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital hospital)
	{
		ResponseStructure<Hospital> structure =new ResponseStructure<Hospital>();
		structure.setBody(dao.saveHospital(hospital));
		structure.setMessage("Hospital Saved Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}
	
	public ResponseStructure<Hospital> updateHospital(@RequestBody Hospital hospital)
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
		structure.setBody(dao.saveHospital(hospital));
		structure.setMessage("hospital updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}
	
	
	public ResponseStructure<String> deleteHospital(@PathVariable int id)
	{
		Optional<Hospital> recHospital=dao.findById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(recHospital.isPresent())
		{
			dao.deleteById(id);
			structure.setBody("Hospital Found");
			structure.setMessage("Hospital Found and Deleted ");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else
		{
			structure.setBody("Hospital Not Found");
			structure.setMessage("Unable to Delete the hospital who is not present");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}
	
	public ResponseStructure<Hospital> findHospitalById(@PathVariable int id)
	{
		ResponseStructure<Hospital> structure =new ResponseStructure<Hospital>();
		Optional<Hospital> recHospital=dao.findById(id);
		if(recHospital.isPresent())
		{
			structure.setBody(recHospital.get());
			structure.setMessage("Hospital Found");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else
		{
			structure.setBody(null);
			structure.setMessage("Hospital Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}
	
	public  ResponseStructure<List<Hospital>> findAllHospitals()
	{
		ResponseStructure<List<Hospital>> structure=new ResponseStructure<List<Hospital>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Hospitals");
		structure.setCode(HttpStatus.OK.value());
		return structure;
	}
}