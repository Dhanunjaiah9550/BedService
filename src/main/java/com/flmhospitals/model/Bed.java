package com.flmhospitals.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Beds")
public class Bed {
	
	private long bedId;
	
	private long bedNumber;
	
	private boolean isOccupied;
	
	private long patientId;
	
	private List<BedAssignmentHistory> bedAssignmentHistoryList;

}
