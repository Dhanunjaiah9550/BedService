package com.flmhospitals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flmhospitals.service.BedService;

@RestController
@RequestMapping("/bed")
public class BedController {

	private final BedService bedService;
	
	public BedController(BedService bedService) {
		this.bedService = bedService;
	}
	
	@DeleteMapping("/delete-bed/{bedNumber}/{roomNumber}")
	public ResponseEntity<String> removeBed(@PathVariable(name = "bedNumber")long bedNumber,
			@PathVariable(name = "roomNumber")long roomNumber) {
		
		boolean removeBed = bedService.removeBed(bedNumber, roomNumber);
		if (!removeBed) {
            return ResponseEntity.status(404).body("Bed not found");
        }

        return ResponseEntity.ok("Bed deleted successfully");
		
	
		
	}
	
}
