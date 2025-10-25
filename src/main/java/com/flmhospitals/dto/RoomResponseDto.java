package com.flmhospitals.dto;

import java.util.List;

import com.flmhospitals.model.Bed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDto {

	private long roomId;
	
	private long roomNumber;

	private String roomType;

	private long roomCapacity;

	private List<Bed> beds;
}
