package com.flmhospitals.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpStatusCodeException;

import com.flmhospitals.dao.BedRepository;
import com.flmhospitals.dto.BedDetailsResponseDTO;
import com.flmhospitals.model.Bed;
import com.flmhospitals.service.BedService;

@Service
public class BedServiceImpl implements BedService{
	
	@Autowired
	BedRepository bedRepository;

	@Override
	public boolean removeBed(long bedNumber, long roomNumber) {
		Bed bed = bedRepository.findByBedNumberAndRoom_RoomNumber(bedNumber, roomNumber);
		 
		if(bed==null) {
			return false;
		}
		
		bedRepository.delete(bed);
		return true;
	}
	
	
}
