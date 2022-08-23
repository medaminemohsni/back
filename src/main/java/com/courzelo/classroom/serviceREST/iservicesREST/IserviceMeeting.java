package com.courzelo.classroom.serviceREST.iservicesREST;

import java.util.List;

import com.courzelo.classroom.entities.Meeting;
import com.courzelo.classroom.entities.dtos.MeetingDTO;

public interface IserviceMeeting {
	public Meeting addMeeting(Meeting m);
	
	public List<MeetingDTO> getMeetingsByFormation(long idFormation);
	
	public List<MeetingDTO> getMeetingsByUser(long idUser);

}
