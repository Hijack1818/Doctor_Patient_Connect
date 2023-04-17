package com.tarun.services;

import java.util.List;


import com.tarun.entities.Doctor;

public interface DoctorServices {

	public Doctor addDoctor(Doctor doc);

	public List<Doctor> getListOfDoctors();

	public List<Doctor> getListByCity(String city);

	public List<Doctor> getListByCityAndSpeciality(String city, String speciality);

	public Doctor getDoctorById(int id);

	public void updatePhoneNo(int id, Doctor doctor);

	public Doctor deleteDoctorById(int id);

}
