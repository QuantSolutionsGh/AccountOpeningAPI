package com.databankgroup.gh.accopeningapi.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Age {
	
	
	
	public Age(){
		
		
	}
	
	public long getAge(Date myDate){
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Instant instant = myDate.toInstant();
	
		LocalDate start=instant.atZone(defaultZoneId).toLocalDate();
		
		LocalDate end = LocalDate.now();

		long myAge=  ChronoUnit.YEARS.between(start, end);
		return myAge;
	}

}
