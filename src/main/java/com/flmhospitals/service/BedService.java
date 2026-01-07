package com.flmhospitals.service;

import org.springframework.http.ResponseEntity;

import com.flmhospitals.dto.BedRequestDTO;

public interface BedService {

	ResponseEntity<String> removeBed(long bedNumber, long roomNumber);

	ResponseEntity<String> addBedInRoom(BedRequestDTO bedRequestDTO);

	ResponseEntity<BedDetailsResponseDTO> updateBedDetails(long roomNumber, long bedNumber, BedRequestDTO bedRequestDTO);

}
