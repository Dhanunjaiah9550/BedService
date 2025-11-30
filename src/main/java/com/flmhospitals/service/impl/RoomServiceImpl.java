package com.flmhospitals.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flmhospitals.builder.BedBuilder;
import com.flmhospitals.builder.RoomBuilder;
import com.flmhospitals.builder.RoomDTOBuilder;
import com.flmhospitals.dao.RoomRepository;
import com.flmhospitals.dto.BedRequestDTO;
import com.flmhospitals.dto.RoomRequestDto;
import com.flmhospitals.dto.RoomResponseDto;
import com.flmhospitals.exception.RoomNotFoundException;
import com.flmhospitals.model.Bed;
import com.flmhospitals.model.Room;
import com.flmhospitals.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {


	private final RoomRepository roomRepository;

	public RoomServiceImpl(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	


	@Override
	public RoomResponseDto addRoom(RoomRequestDto roomRequestDto) {

	    Room room = RoomBuilder.buildRoomFromRoomDTO(roomRequestDto);

	    if (roomRequestDto.getBeds() != null) {
	        List<Bed> bedEntities = new ArrayList<>();
	        for (BedRequestDTO bedDto : roomRequestDto.getBeds()) {
	           
	            Bed bedEntity = BedBuilder.buildBedFromBedRequestDto(bedDto);
	            bedEntities.add(bedEntity);
	            bedEntity.setRoom(room);
	            
	        }
	        room.setBeds(bedEntities);
	    }
	    Room savedRoom = roomRepository.save(room);
	  	    
	    return RoomDTOBuilder.buildRoomResponseDtofromRoom(savedRoom);
	}

	

	@Override
	public boolean removeRoom(long roomNumber) {
		Room room = roomRepository.findById(roomNumber)
				.orElseThrow(() -> new RoomNotFoundException("Room not found with " + roomNumber));
		roomRepository.delete(room);
		return true;
	}


}
