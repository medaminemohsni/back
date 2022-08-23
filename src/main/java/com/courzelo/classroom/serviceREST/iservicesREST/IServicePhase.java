package com.courzelo.classroom.serviceREST.iservicesREST;

import java.util.List;

import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.entities.dtos.PhaseDTO;








public interface IServicePhase {
	public PhaseDTO addPhase(PhaseDTO f,long idSection);
	
	public List<PhaseDTO>getList();
	public List<PhaseDTO>getPhaseByIdSection(long id);
	public PhaseDTO getPhaseById(long idPhase); 
	public PhaseDTO updatePhase(long idPhase ,PhaseDTO RequestPhase); 
	
	public void deletePhase(long idPhase); 

}
