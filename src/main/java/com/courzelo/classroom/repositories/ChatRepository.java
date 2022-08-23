package com.courzelo.classroom.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.courzelo.classroom.entities.Chat;

@Repository
public interface ChatRepository extends MongoRepository<Chat, Integer> {

}
