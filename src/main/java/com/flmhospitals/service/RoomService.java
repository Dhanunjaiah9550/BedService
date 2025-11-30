package com.flmhospitals.service;

import com.flmhospitals.dto.RoomRequestDto;
import com.flmhospitals.dto.RoomResponseDto;


public interface RoomService {

	public boolean removeRoom(long roomNumber);
	RoomResponseDto addRoom(RoomRequestDto roomrequestDto);

}
