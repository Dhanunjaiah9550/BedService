package com.flmhospitals.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flmhospitals.model.BedAssignmentHistory;

public interface BedAssignmentHistoryRepository extends JpaRepository<BedAssignmentHistory, Long>{

}
