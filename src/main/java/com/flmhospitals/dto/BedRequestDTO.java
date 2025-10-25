package com.flmhospitals.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedRequestDTO {
	
	private int bedNum;
	
//	private RoomRequestDto roomRequestDto;
	
	private boolean isOccupied;
	
	private String patientId;
	
	private List<BedAssignemntHistoryDTO> bedAssignemntHistorydto;

}
