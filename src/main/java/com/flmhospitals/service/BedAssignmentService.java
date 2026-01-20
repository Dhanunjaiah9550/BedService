package com.flmhospitals.service;

import com.flmhospitals.model.Bed;

public interface BedAssignmentService {

	Bed bedAssigntment(long bedNumber, long patientId);
}
