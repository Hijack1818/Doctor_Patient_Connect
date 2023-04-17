package com.tarun.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.entities.Doctor;
import com.tarun.entities.Patient;
import com.tarun.services.PatientServices;

@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired
	private PatientServices patientServices;
	
	@PostMapping("add")
	public ResponseEntity<Patient> addPatient(@RequestBody @Valid Patient p){
		return ResponseEntity.status(HttpStatus.OK).body(patientServices.addPatient(p));
	}
	
	@GetMapping("recommend-doc/{id}")
	public ResponseEntity<List<Doctor>> recommendDoc(@PathVariable int id){
		List<Doctor> list= patientServices.recommendDoc(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("list")
	public ResponseEntity<List<Patient>> getList(){
		List<Patient> list= patientServices.getList();
		return ResponseEntity.ok(list);
	}
}
