package com.flmhospitals.service.impl;

import org.springframework.stereotype.Service;

import com.flmhospitals.dao.RoomRepository;
import com.flmhospitals.exception.RoomNotFoundException;
import com.flmhospitals.model.Room;
import com.flmhospitals.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepository;

	public RoomServiceImpl(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@Override
	public boolean removeRoom(long roomNumber) {
		Room room = roomRepository.findById(roomNumber)
				.orElseThrow(() -> new RoomNotFoundException("Room not found with " + roomNumber));
		roomRepository.delete(room);
		return true;
	}

}
