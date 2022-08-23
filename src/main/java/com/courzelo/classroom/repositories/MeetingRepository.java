package com.courzelo.classroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.classroom.entities.Meeting;

@Repository
public interface MeetingRepository extends MongoRepository<Meeting, Integer> {
	public List<Meeting> findAllByIdFormation(long idFormation);
	public List<Meeting> findAllByIdInstructor(long idInstructor);


}
