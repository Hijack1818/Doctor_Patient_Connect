package com.tarun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
