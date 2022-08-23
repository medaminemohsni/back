package com.courzelo.classroom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courzelo.classroom.entities.Chat;
import com.courzelo.classroom.repositories.ChatRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/chat")
public class ChatController {
	
	@Autowired
	ChatRepository chatrepository;
	
	@RequestMapping(method = RequestMethod.POST)
    public Chat ajouterCategorie (@RequestBody Chat chat){
        return chatrepository.save(chat);
        }
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Chat> afficherChat(){
        return (List<Chat>) chatrepository.findAll();}

}
