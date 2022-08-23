package com.courzelo.classroom.serviceREST.iservicesREST;

import java.util.List;

import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.entities.dtos.SectionDTO;








public interface IServiceSection {
	public SectionDTO addSection(SectionDTO f,long idFormation);
	
	public List<SectionDTO>getList();
	public List<SectionDTO>getSectionByIdFormation(long id);
	public SectionDTO getSectionById(long idSection); 
	public SectionDTO updateSection(long idSection ,SectionDTO RequestSection); 
	
	public void deleteSection(long idSection); 

}
