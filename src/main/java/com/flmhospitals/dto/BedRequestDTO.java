package com.flmhospitals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedRequestDTO {
	
	private int bedNum;
	
	private long roomNumber;
	
	private boolean isOccupied;
	
}
