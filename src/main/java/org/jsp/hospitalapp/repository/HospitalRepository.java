package org.jsp.hospitalapp.repository;

import org.jsp.hospitalapp.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>
{

}
