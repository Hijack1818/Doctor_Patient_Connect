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
public class Doctor {

	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name="doc_seq",initialValue = 101,allocationSize = 1)
	private int docId;
	private String name;
	@NotNull(message = "City is required")
	@Pattern(regexp = "Noida|Delhi|Faridabad",message = "Wrong city")
	private String city;
	@NotNull(message = "Speciality is required")
	@Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT Specialist",message = "Speciality not valid")
	private String speciality;
	@Email(message = "Your email format is incorrect")
	private String email;
	@Length(min=10,max=10,message = "Phone No. should contain 10 digits")
	private String phoneNo;
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
