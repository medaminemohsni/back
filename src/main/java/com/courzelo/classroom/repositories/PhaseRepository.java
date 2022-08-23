package com.courzelo.classroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.courzelo.classroom.entities.Phase;




@Repository
public interface PhaseRepository extends MongoRepository<Phase, Integer> {
	
	public List<Phase> findByIdsection(long idSection);
	public Phase findByIdPhase(long idPhase);
	
}
