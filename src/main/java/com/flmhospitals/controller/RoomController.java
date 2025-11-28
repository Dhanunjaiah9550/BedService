package com.flmhospitals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmhospitals.dto.RoomRequestDto;
import com.flmhospitals.dto.RoomResponseDto;
import com.flmhospitals.service.RoomService;

@RestController
@RequestMapping("/bed")
public class RoomController {
	
	private final RoomService roomService;
	
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}



	@PutMapping("/update/{roomNumber}")
	public ResponseEntity<RoomResponseDto> updateRoomDetails(@PathVariable long roomNumber,
															@RequestBody RoomRequestDto roomRequestDto){
		RoomResponseDto updatedRoomDetails = roomService.UpdateRoomDetails(roomNumber,roomRequestDto);
		return ResponseEntity.ok(updatedRoomDetails);
		
	}
}
