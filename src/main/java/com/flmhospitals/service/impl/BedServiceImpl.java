package com.flmhospitals.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flmhospitals.builder.BedBuilder;
import com.flmhospitals.builder.BedResponseDtoBuilder;
import com.flmhospitals.dao.BedRepository;
import com.flmhospitals.dao.RoomRepository;
import com.flmhospitals.dto.BedRequestDTO;
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

}
