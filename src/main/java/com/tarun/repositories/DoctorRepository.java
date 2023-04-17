package com.tarun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	List<Doctor> findAllByCity(String city);

	List<Doctor> findAllByCityAndSpeciality(String city, String speciality);

}
