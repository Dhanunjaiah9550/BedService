package com.flmhospitals.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BedDetailsResponseDTO {
	
	private long bedId;
	
	private int bedNum;
	
//	private RoomDetailsResponseDTO roomDetailsResponseDTO;
	
	private boolean isOccupied;
	
	private String patientId;
	
	private List<BedAssignemntHistoryDTO> bedAssignemntHistorydto;

}
