package com.flmhospitals.builder;

import com.flmhospitals.dto.BedRequestDTO;
import com.flmhospitals.model.Bed;

public class BedBuilder {

	public static Bed buildRequestDtoFromBed(BedRequestDTO bedRequestDTO) {
		return Bed.builder()
				  .bedNumber(bedRequestDTO.getBedNum())
				  .isOccupied(bedRequestDTO.isOccupied())
				  .build();
	}
}
