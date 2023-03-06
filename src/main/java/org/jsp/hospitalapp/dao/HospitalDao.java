package org.jsp.hospitalapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.hospitalapp.dto.Hospital;
import org.jsp.hospitalapp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao 
{
	@Autowired
	HospitalRepository repository;
	
	public Hospital saveHospital(Hospital hospital) 
	{
		return repository.save(hospital);
	}
	
	public Hospital updateHospital(Hospital hospital)
	{
		return repository.save(hospital);
	}
	
	public Optional<Hospital> findById(int id)
	{
		return repository.findById(id);
	}
	
	public List<Hospital> findAll()
	{
		return repository.findAll();
	}
	
	public void deleteById(int id)
	{
		repository.deleteById(id);
	}
}
