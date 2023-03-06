package org.jsp.hospitalapp.dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Hospital 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String Founder;
	private int yearofestablish;
	private String GSTNO;
	@OneToMany(mappedBy = "hospital")
	private Set<Branch> branches=new HashSet<>();
	
}
