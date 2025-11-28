package com.flmhospitals.service;

import com.flmhospitals.dto.RoomRequestDto;
import com.flmhospitals.dto.RoomResponseDto;


public interface RoomService {

	RoomResponseDto UpdateRoomDetails(long roomNumber, RoomRequestDto roomRequestDto);

}
