package com.flmhospitals.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmhospitals.dto.BedDetailsResponseDTO;
import com.flmhospitals.dto.BedRequestDTO;
import com.flmhospitals.service.BedService;

@RestController
@RequestMapping("/bed")
public class BedController {
	
	private final BedService bedService;

	public BedController(BedService bedService) {
		super();
		this.bedService = bedService;
	}
	
	@PostMapping("/addBed")
	public ResponseEntity<String> addBedInRoom(@RequestBody BedRequestDTO bedRequestDTO){

		BedDetailsResponseDTO bedResponseDTO = bedService.addBedInRoom(bedRequestDTO);
		if(bedResponseDTO != null) {
			//return ResponseEntity.ok(bedResponseDTO);
			return ResponseEntity.ok("Sucessfully added Bed Number "+bedRequestDTO.getBedNum()+" into Room Number "+bedRequestDTO.getRoomNumber());
		}else {
			return ResponseEntity.ok("Cannot add Bed into Room Number "+bedRequestDTO.getRoomNumber()+" as the room is fulled with beds");
		}

	}	

}
