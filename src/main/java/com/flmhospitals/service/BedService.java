package com.flmhospitals.service;

import org.springframework.http.ResponseEntity;

public interface BedService {
	
	public boolean removeBed(long bedNumber,long roomNumber);

}
