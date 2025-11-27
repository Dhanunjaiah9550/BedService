package com.flmhospitals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmhospitals.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	private final RoomService roomService;

	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}

	@DeleteMapping("/delete-rooms/{roomNumber}")
	public ResponseEntity<Boolean> removeRoom(@PathVariable("roomNumber") long roomNumber) {
		return ResponseEntity.ok(roomService.removeRoom(roomNumber));
	}

}
