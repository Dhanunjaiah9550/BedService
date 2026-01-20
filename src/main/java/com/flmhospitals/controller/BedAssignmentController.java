package com.flmhospitals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmhospitals.model.Bed;
import com.flmhospitals.service.BedAssignmentService;

@RestController
@RequestMapping("/bed")
public class BedAssignmentController {

	private final BedAssignmentService bedAssignmentService;

	public BedAssignmentController(BedAssignmentService bedAssignmentService) {
		this.bedAssignmentService = bedAssignmentService;
	}

	@PostMapping("/assign/{bedNumber}/{patientId}")
	public ResponseEntity<Bed> assignBed(@PathVariable(name = "bedNumber") long bedNumber,
			@PathVariable(name = "patientId") long patientId) {

		Bed assignedBed = bedAssignmentService.bedAssigntment(bedNumber, patientId);
		return ResponseEntity.ok(assignedBed);
	}
}
