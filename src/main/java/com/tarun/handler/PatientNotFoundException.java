package com.tarun.handler;

public class PatientNotFoundException extends RuntimeException{
	public PatientNotFoundException(String msg)
	{
		super(msg);
	}
}
