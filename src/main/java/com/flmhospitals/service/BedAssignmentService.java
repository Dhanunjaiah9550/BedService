package com.flmhospitals.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.flmhospitals.dto.BedAssignmentHistoryDTO;
import com.flmhospitals.dto.BedDetailsResponseDTO;
import com.flmhospitals.model.Bed;

public interface BedAssignmentService {

	Bed bedAssigntment(long bedNumber, long patientId);

	void vacateBed(long roomNumber, long bedNumber);

	List<BedAssignmentHistoryDTO> getHistoryByBedNumber(long bedNumber);
}
