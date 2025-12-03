package com.flmhospitals.service.impl;

import org.springframework.stereotype.Service;


import com.flmhospitals.builder.RoomBuilder;
import com.flmhospitals.builder.RoomDTOBuilder;
import com.flmhospitals.dao.RoomRepository;
import com.flmhospitals.dto.RoomRequestDto;
import com.flmhospitals.dto.RoomResponseDto;

import com.flmhospitals.exception.RoomNotFoundException;
import com.flmhospitals.model.Room;
import com.flmhospitals.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	
	private final RoomRepository roomRepository;
	

	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}


	@Override
	public RoomResponseDto UpdateRoomDetails(long roomNumber,  RoomRequestDto roomRequestDto ) {
		Room existingRoom = roomRepository.findById(roomNumber)
											.orElseThrow(()-> new RoomNotFoundException("Room Not Found with Room Number :"+roomNumber));
	
		Room updatedRoom = RoomBuilder.buildRoomFromRoomDTO(roomRequestDto);
		updatedRoom.setRoomNumber(existingRoom.getRoomNumber());
		
		Room room = roomRepository.save(updatedRoom);
		
		return RoomDTOBuilder.buildRoomResponseDtofromRoom(room);
		
	}
	
	@Override
	public boolean removeRoom(long roomNumber) {
		Room room = roomRepository.findById(roomNumber)
				.orElseThrow(() -> new RoomNotFoundException("Room not found with " + roomNumber));
		roomRepository.delete(room);
		return true;
	}

}
