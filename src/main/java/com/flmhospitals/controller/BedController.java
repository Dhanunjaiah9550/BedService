package com.flmhospitals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmhospitals.dto.BedDetailsResponseDTO;
import com.flmhospitals.dto.BedRequestDTO;
import com.flmhospitals.service.BedService;

@RestController
@RequestMapping("/bed")
public class BedController {

    private final RoomController roomController;
	
	private final BedService bedService;

	public BedController(BedService bedService, RoomController roomController) {
		super();
		this.bedService = bedService;
		this.roomController = roomController;
	}

	@DeleteMapping("/delete-bed/{bedNumber}/{roomNumber}")
	public ResponseEntity<String> removeBed(@PathVariable(name = "bedNumber") long bedNumber,
			@PathVariable(name = "roomNumber") long roomNumber) {

		return bedService.removeBed(bedNumber, roomNumber);

	}

	@PostMapping("/addBed")
	public ResponseEntity<String> addBedInRoom(@RequestBody BedRequestDTO bedRequestDTO) {

		return bedService.addBedInRoom(bedRequestDTO);

	}
	
	@PutMapping("/update-bed/{roomNumber}/{bedNumber}")
	public ResponseEntity<BedDetailsResponseDTO> updateBedDetails(@PathVariable(name="roomNumber") long roomNumber,@PathVariable(name="bedNumber") long bedNumber,@RequestBody BedRequestDTO bedRequestDTO){
		ResponseEntity<BedDetailsResponseDTO> updateBedDetails = bedService.updateBedDetails(roomNumber,bedNumber,bedRequestDTO);
		System.out.println(updateBedDetails);
		return updateBedDetails;
	}

}
