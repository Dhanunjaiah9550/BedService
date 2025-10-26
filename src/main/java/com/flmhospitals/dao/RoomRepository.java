package com.flmhospitals.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flmhospitals.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
