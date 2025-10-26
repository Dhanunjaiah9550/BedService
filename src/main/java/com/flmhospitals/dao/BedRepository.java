package com.flmhospitals.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flmhospitals.model.Bed;

public interface BedRepository extends JpaRepository<Bed, Long>{

}
