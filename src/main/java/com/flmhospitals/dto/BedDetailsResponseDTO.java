package com.flmhospitals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BedDetailsResponseDTO {
	
	private long bedId;
	
	private int bedNum;
	
	private long roomNumber;
	
	private boolean isOccupied;
	

}
