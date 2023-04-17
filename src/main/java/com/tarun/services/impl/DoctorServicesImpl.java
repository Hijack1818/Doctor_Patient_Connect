package com.tarun.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tarun.entities.Doctor;
import com.tarun.handler.DoctorNotFoundException;
import com.tarun.repositories.DoctorRepository;
import com.tarun.services.DoctorServices;

@Service
public class DoctorServicesImpl implements DoctorServices{

	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor addDoctor(Doctor doc) {
		return doctorRepository.save(doc);
	}

	public List<Doctor> getListOfDoctors() {
		List<Doctor> list= doctorRepository.findAll();
		if(list==null || list.isEmpty()) {
			throw new DoctorNotFoundException("List is Empty, No Doctor added currently");
		}
		
		return list;
	}

	public List<Doctor> getListByCity(String city) {
		List<Doctor> list=  doctorRepository.findAllByCity(city);
		if(list==null || list.isEmpty()) {
			throw new DoctorNotFoundException("List is Empty, No Doctor added currently");
		}
		return list;
	}

	public List<Doctor> getListByCityAndSpeciality(String city, String speciality) {
		
		List<Doctor> list= doctorRepository.findAllByCityAndSpeciality(city,speciality);
		if(list.isEmpty()) {
			throw new DoctorNotFoundException("There isn't any doctor present at your location for your symptom");
		}
		return list;
	}

	public Doctor getDoctorById(int id) {
		Doctor d= doctorRepository.findById(id).orElse(null);
		if(d==null) {
			throw new DoctorNotFoundException("Doctor with id "+id+" is not valid");
		}
		return d;
	}

	public void updatePhoneNo(int id, Doctor doctor) {
		Doctor d= doctorRepository.findById(id).orElse(null);
		if(d==null) {
			throw new DoctorNotFoundException("Doctor with id "+id+" is not valid");
		}
		d.setPhoneNo(doctor.getPhoneNo());
		doctorRepository.save(d);
	}

	public Doctor deleteDoctorById(int id) {
		Doctor d= doctorRepository.findById(id).orElse(null);
		if(d==null) {
			throw new DoctorNotFoundException("Doctor with id "+id+" is not valid");
		}
		doctorRepository.deleteById(id);
		return d;
	}
	
	
}
