package com.tarun.services.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tarun.entities.Doctor;
import com.tarun.entities.Patient;
import com.tarun.handler.DoctorNotFoundException;
import com.tarun.handler.PatientNotFoundException;
import com.tarun.repositories.DoctorRepository;
import com.tarun.repositories.PatientRepository;
import com.tarun.services.PatientServices;

@Service
public class PatientServiceImpl implements PatientServices {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	private static HashMap<String, String> map = new HashMap<>();

	static {
		map.put("Arthritis", "Orthopedic");
		map.put("Backpain", "Orthopedic");
		map.put("Tissue Injuries", "Orthopedic");
		map.put("Dysmenorrhea", "Gynecology");
		map.put("Skin Infection", "Dermatology");
		map.put("Skin Burn", "Dermatology");
		map.put("Ear Pain", "ENT Specialist");
	}

	public Patient addPatient(Patient p) {
		return patientRepository.save(p);
	}

	public List<Doctor> recommendDoc(int id) {
		Patient p= patientRepository.findById(id).orElse(null);
		if(p==null) {
			throw new PatientNotFoundException("Patient id is not valid");
		}
		
		if(!p.getCity().matches("Noida|Delhi|Faridabad")) {
			throw new DoctorNotFoundException("There isn't any doctor on that location");
		}
		String speciality= map.get(p.getSymptom());
		System.out.println(speciality);
		List<Doctor> list= doctorRepository.findAllByCityAndSpeciality(p.getCity(), speciality);
		if(list.isEmpty()) {
			throw new DoctorNotFoundException("There isn't any doctor present at your location for your symptom");
		}
		return list;
	}

	public Patient getPatient(int id) {
		return patientRepository.findById(id).orElse(null);
	}

	public List<Patient> getList() {
		List<Patient> list = patientRepository.findAll();
		if(list.isEmpty()) {
			throw new PatientNotFoundException("Not Patient added");
		}
		return list;
	}
	
	
}
