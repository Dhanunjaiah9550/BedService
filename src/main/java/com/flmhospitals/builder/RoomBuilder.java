package com.flmhospitals.builder;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.flmhospitals.dto.BedRequestDTO;
import com.flmhospitals.dto.RoomRequestDto;
import com.flmhospitals.model.Bed;
import com.flmhospitals.model.Room;

public class RoomBuilder {
	
	public  static Room buildUpdateRoomFromRoomDto(Room existingRoom,RoomRequestDto roomRequestDto) {
		return Room.builder()
							.roomCapacity(roomRequestDto.getRoomCapacity())
							.roomNumber(roomRequestDto.getRoomNumber())
							.roomType(roomRequestDto.getRoomType())
							.beds(existingRoom.getBeds())
							.build();
							
	}
	
	public static Room buildRoomFromRoomDTO(RoomRequestDto roomRequestDto) {
		return Room.builder()
			        .roomNumber(roomRequestDto.getRoomNumber())
			        .roomType(roomRequestDto.getRoomType())
			        .roomCapacity(roomRequestDto.getRoomCapacity())
			        .beds(buildBedFromBedDTO(roomRequestDto.getBeds()))
			        .build();
	}
	
	private static List<Bed> buildBedFromBedDTO(List<BedRequestDTO> bedRequestDTOs){
		List<Bed> bedList = new ArrayList<>();
		
		for(BedRequestDTO beds : bedRequestDTOs) {
			Bed bed = new Bed();
			BeanUtils.copyProperties(beds, bed);
			bedList.add(bed);
		}
		return bedList;
	}
	
	
}

