package com.flmhospitals.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.flmhospitals.dao.BedAssignmentHistoryRepository;
import com.flmhospitals.dao.BedRepository;
import com.flmhospitals.exception.BedNotFoundException;
import com.flmhospitals.exception.BedUnavailableException;
import com.flmhospitals.model.Bed;
import com.flmhospitals.model.BedAssignmentHistory;
import com.flmhospitals.service.BedAssignmentService;

@Service
public class BedAssignmentServiceImpl implements BedAssignmentService {

	private final BedRepository bedRepository;
	private final BedAssignmentHistoryRepository bedHistoryRepository;

	public BedAssignmentServiceImpl(BedRepository bedRepository, BedAssignmentHistoryRepository bedHistoryRepository) {
		this.bedRepository = bedRepository;
		this.bedHistoryRepository = bedHistoryRepository;
	}

	@Override
	public Bed bedAssigntment(long bedNumber, long patientId) {

		Bed bed = bedRepository.findById(bedNumber).orElseThrow(() -> new BedNotFoundException("Bed not found"));

		if (bed.isOccupied()) {
			throw new BedUnavailableException("Bed " + bedNumber + " is already occupied");
		}

		bed.setOccupied(true);
		bed.setPatientId(patientId);
		bedRepository.save(bed);

		BedAssignmentHistory bedHistory = new BedAssignmentHistory();
		bedHistory.setBed(bed);
		bedHistory.setPatientId(patientId);
		bedHistory.setAssignedAt(LocalDateTime.now());

		bedHistoryRepository.save(bedHistory);

		return bed;
	}

}
