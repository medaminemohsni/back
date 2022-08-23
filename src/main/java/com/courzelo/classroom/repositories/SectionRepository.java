package com.courzelo.classroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.courzelo.classroom.entities.Section;




@Repository
public interface SectionRepository extends MongoRepository<Section, Integer> {
	
	public List<Section> findByIdformation(long idFormation);
	public Section findByIdSection(long idSection);
	
}
