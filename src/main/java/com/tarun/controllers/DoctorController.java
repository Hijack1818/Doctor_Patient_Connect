package com.tarun.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.entities.Doctor;
import com.tarun.services.DoctorServices;

@RestController
@Validated
@RequestMapping("doctor")
public class DoctorController {
	@Autowired
	private DoctorServices doctorServices;
	
	@PostMapping("add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody @Valid Doctor doc){
		return ResponseEntity.status(HttpStatus.CREATED).body(doctorServices.addDoctor(doc));
	}
	
	@GetMapping("list")
	public ResponseEntity<List<Doctor>> getListOfDoctors(){
		List<Doctor> list= doctorServices.getListOfDoctors();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("list-by-city")
	public ResponseEntity<List<Doctor>> getListByCity( @RequestParam @Pattern(regexp = "Noida|Delhi|Faridabad",message = "Wrong city") String city){
		List<Doctor> list= doctorServices.getListByCity(city); 
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("list-by-city-speciality")
	public ResponseEntity<List<Doctor>> getListByCityAndSpeciality(@RequestParam @Pattern(regexp = "Noida|Delhi|Faridabad",message = "Wrong city") String city,@RequestParam @Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT Specialist",message = "Speciality not valid") String speciality){
		List<Doctor> list= doctorServices.getListByCityAndSpeciality(city, speciality);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PatchMapping("update-ph/{id}")
	public ResponseEntity<Doctor> updatePhoneNo(@PathVariable int id,@RequestBody Doctor doctor){
		doctorServices.updatePhoneNo(id,doctor);
		return ResponseEntity.status(HttpStatus.OK).body(doctor);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Doctor> deleteDoctorById(@PathVariable int id){
		
		Doctor d=doctorServices.deleteDoctorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(d);
	}
}
