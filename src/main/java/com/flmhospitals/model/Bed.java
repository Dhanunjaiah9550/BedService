package com.flmhospitals.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
    @JoinColumn(name = "roomId")
	private Room roomId;
	
	@OneToMany(mappedBy = "bed",cascade = CascadeType.ALL)
	private List<BedAssignmentHistory> bedAssignmentHistoryList;

	public Bed(long bedNumber, boolean isOccupied, long patientId, Room roomId,
			List<BedAssignmentHistory> bedAssignmentHistoryList) {
		super();
		this.bedNumber = bedNumber;
		this.isOccupied = isOccupied;
		this.patientId = patientId;
		this.roomId = roomId;
		this.bedAssignmentHistoryList = bedAssignmentHistoryList;
	}


}
