package com.courzelo.classroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.courzelo.classroom.entities.Devoir;




@Repository
public interface DevoirRepository extends MongoRepository<Devoir, Integer> {
	
	public List<Devoir> findByIdformation(long idFormation);
	public Devoir findByIdDevoir(long idDevoir);
	
}
