package com.courzelo.classroom.serviceREST;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Meeting;
import com.courzelo.classroom.entities.dtos.MeetingDTO;
import com.courzelo.classroom.repositories.MeetingRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IserviceMeeting;

@Service
public class MeetingBusiness implements IserviceMeeting {
	@Autowired
	private MeetingRepository meetingRepository;
	   @Autowired
       private ModelMapper mapper;
	   
	@Override
	public Meeting addMeeting(Meeting m) {
		return meetingRepository.save(m);
	}

	@Override
	public List<MeetingDTO> getMeetingsByFormation(long idFormation) {
		// TODO Auto-generated method stub
		
		List<Meeting> meetingList = meetingRepository.findAllByIdFormation(idFormation);
		
		return meetingList.stream().map(elem -> mapper.map(elem, MeetingDTO.class)).collect(Collectors.toList());
		
	}
	
	@Override
	public List<MeetingDTO> getMeetingsByUser(long idUser) {
		// TODO Auto-generated method stub
		
		List<Meeting> meetingList = meetingRepository.findAllByIdInstructor(idUser);
		
		return meetingList.stream().map(elem -> mapper.map(elem, MeetingDTO.class)).collect(Collectors.toList());
		
	}
}
