package com.databankgroup.gh.accopeningapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccGenDetails {

	private String applicationRef;
	private String accountNumber;
	private String pin;
	private String id;

	public String getApplicationRef() {
		return applicationRef;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getPin() {
		return pin;
	}

	public String getId() {
		return id;
	}
	
	
	
	public void setApplicationRef(String applicationRef) {
		this.applicationRef = applicationRef;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AccGenDetails(){
		
	}

}
