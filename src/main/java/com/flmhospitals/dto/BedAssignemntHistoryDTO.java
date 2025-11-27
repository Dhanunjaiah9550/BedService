package com.flmhospitals.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BedAssignemntHistoryDTO {
	
	private long BedAssignemntHistoryId;
	
	private int bedNum;
	
//	private RoomDetailsResponseDTO roomDetailsResponseDTO;
	
	private String patientId;
	
	private LocalDateTime assignedAt;
	
	private LocalDateTime vacatedAt;

	public BedAssignemntHistoryDTO(int bedNum, String patientId, LocalDateTime assignedAt) {

		this.bedNum = bedNum;
		
		this.patientId = patientId;
		
		this.assignedAt = assignedAt;
	}

	public BedAssignemntHistoryDTO(LocalDateTime vacatedAt, int bedNum, String patientId) {

		this.bedNum = bedNum;
		
		this.patientId = patientId;
		
		this.vacatedAt = vacatedAt;
	}
	
	
	
}
