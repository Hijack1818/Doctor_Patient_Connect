package com.tarun.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class Patient {

	@Id
	@GeneratedValue(generator = "pat_seq")
	@SequenceGenerator(name="pat_seq",initialValue = 1,allocationSize = 1)
	private int patId;
	@Length(min = 3)
	private String name;
	@Length(max=20)
	private String city;
	@Email(message = "Your email format is incorrect")
	private String email;
	@Length(min=10,max=10,message = "Phone No. should contain 10 digits")
	private String phoneNo;
	@NotNull(message = "Symptom is required")
	@Pattern(regexp = "Arthritis|Backpain|Tissue Injuries|Dysmenorrhea|Skin Infection|Skin Burn|Ear Pain",message = "Symptom currently not valid")
	private String symptom;
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
	
}
