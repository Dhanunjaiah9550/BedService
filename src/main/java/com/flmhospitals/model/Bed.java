package com.flmhospitals.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bedId;
	
	private long bedNumber;
	
	private boolean isOccupied;
	
	private long patientId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bedId")
	private List<BedAssignmentHistory> bedAssignmentHistoryList;

}
