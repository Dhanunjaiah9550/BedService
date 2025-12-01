package com.flmhospitals.service;

import com.flmhospitals.dto.BedDetailsResponseDTO;
import com.flmhospitals.dto.BedRequestDTO;

public interface BedService {

	BedDetailsResponseDTO addBedInRoom(BedRequestDTO bedRequestDTO);

}
