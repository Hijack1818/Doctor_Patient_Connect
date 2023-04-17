package com.tarun.handler;

public class DoctorNotFoundException extends RuntimeException {
	public DoctorNotFoundException(String msg) {
		super(msg);
	}
}
