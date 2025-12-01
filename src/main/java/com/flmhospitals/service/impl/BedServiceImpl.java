package com.flmhospitals.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flmhospitals.builder.BedBuilder;
import com.flmhospitals.builder.BedResponseDtoBuilder;
import com.flmhospitals.dao.BedRepository;
import com.flmhospitals.dao.RoomRepository;
import com.flmhospitals.dto.BedDetailsResponseDTO;
import com.flmhospitals.dto.BedRequestDTO;
import com.flmhospitals.model.Bed;
import com.flmhospitals.model.Room;
import com.flmhospitals.service.BedService;

@Service
public class BedServiceImpl implements BedService {
	
	private final BedRepository bedRepository;
	private final RoomRepository roomRepository;

	public BedServiceImpl(BedRepository bedRepository, RoomRepository roomRepository) {
		super();
		this.bedRepository = bedRepository;
		this.roomRepository = roomRepository;
	}


	@Override
	public BedDetailsResponseDTO addBedInRoom(BedRequestDTO bedRequestDTO) {
		// TODO Auto-generated method stub
		Room existingRoom = roomRepository.findByRoomNumber(bedRequestDTO.getRoomNumber()) ;
		List<Bed> bedInExistingRoom = existingRoom.getBeds();
		if(bedInExistingRoom.isEmpty() || (bedInExistingRoom.size() < existingRoom.getRoomCapacity()) ) {		
			Bed bed = BedBuilder.buildRequestDtoFromBed(bedRequestDTO);
			bed.setRoom(existingRoom);
			
			return BedResponseDtoBuilder.buildBedDetailsResponseDtoFromBed(bedRepository.save(bed));
			 
		}
		
		return null;
	}

}
