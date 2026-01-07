package com.flmhospitals.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flmhospitals.builder.BedBuilder;
import com.flmhospitals.builder.BedResponseDtoBuilder;
import com.flmhospitals.dao.BedRepository;
import com.flmhospitals.dao.RoomRepository;
import com.flmhospitals.dto.BedRequestDTO;
import com.flmhospitals.exception.BedNotFoundException;
import com.flmhospitals.exception.RoomNotFoundException;
import com.flmhospitals.model.Bed;
import com.flmhospitals.model.Room;
import com.flmhospitals.service.BedService;

@Service
public class BedServiceImpl implements BedService {

	private final BedRepository bedRepository;
	private final RoomRepository roomRepository;

	public BedServiceImpl(BedRepository bedRepository, RoomRepository roomRepository) {

		this.bedRepository = bedRepository;
		this.roomRepository = roomRepository;
	}

	@Override
	public ResponseEntity<String> addBedInRoom(BedRequestDTO bedRequestDTO) {

		Room existingRoom = roomRepository.findByRoomNumber(bedRequestDTO.getRoomNumber());
		if (existingRoom == null) {
			return ResponseEntity.ok("Room Number " + bedRequestDTO.getRoomNumber() + " doesn't exists");
		}
		List<Bed> bedInExistingRoom = existingRoom.getBeds();
		for (Bed bed : bedInExistingRoom) {
			if (bedRequestDTO.getBedNum() == bed.getBedNumber()) {
				return ResponseEntity.ok("Bed Number " + bedRequestDTO.getBedNum() + " already added in Room Number "
						+ bedRequestDTO.getRoomNumber());
			}

		}
		if (bedInExistingRoom.isEmpty() || (bedInExistingRoom.size() < existingRoom.getRoomCapacity())) {
			Bed bed = BedBuilder.buildBedFromBedRequestDto(bedRequestDTO);
			bed.setRoom(existingRoom);
			BedResponseDtoBuilder.buildBedDetailsResponseDtoFromBed(bedRepository.save(bed));
			return ResponseEntity.ok("Sucessfully added Bed Number " + bedRequestDTO.getBedNum() + " into Room Number "
					+ bedRequestDTO.getRoomNumber());

		}

		return ResponseEntity.ok("Cannot add Bed into Room Number " + bedRequestDTO.getRoomNumber()
				+ " as the room is fulled with beds");
	}

	@Override
	public ResponseEntity<String> removeBed(long bedNumber, long roomNumber) {
		Bed bed = bedRepository.findByBedNumberAndRoom_RoomNumber(bedNumber, roomNumber);

		if (bed == null) {
			return ResponseEntity.status(404).body("Bed Number not found");
		}

		bedRepository.delete(bed);
		return ResponseEntity.ok("Bed removed from the room");
	}


	@Override
	public ResponseEntity<BedDetailsResponseDTO> updateBedDetails(long roomNumber, long bedNumber,
			BedRequestDTO bedRequestDTO) {
		Room existingRoom = roomRepository.findById(roomNumber).orElseThrow(()->new RoomNotFoundException("Room not Found with Id:"+roomNumber));
		System.out.println(existingRoom);
		Bed existingBed = bedRepository.findBedWithRoomNumber(bedNumber, existingRoom.getRoomNumber())
				 										.orElseThrow(()-> new BedNotFoundException("Bed Not Found with BedNumber :"+bedNumber+" in RoomNumber: "+roomNumber));
		existingBed.setOccupied(bedRequestDTO.isOccupied());
		existingBed.setRoom(existingRoom);
		System.out.println("existing :"+existingBed);
		Bed savedBed = bedRepository.save(existingBed);
		 System.out.println(savedBed);
		BedDetailsResponseDTO response = BedResponseDtoBuilder.buildBedDetailsResponseDtoFromBed(savedBed);
		return ResponseEntity.ok(response);
	}

}
