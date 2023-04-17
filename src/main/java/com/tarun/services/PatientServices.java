package com.tarun.services;

import java.util.List;

import com.tarun.entities.Doctor;
import com.tarun.entities.Patient;

public interface PatientServices {

	Patient addPatient(Patient p);

	List<Doctor> recommendDoc(int id);

	Patient getPatient(int id);

	List<Patient> getList();

}
