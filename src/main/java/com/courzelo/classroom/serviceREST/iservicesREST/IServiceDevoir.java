package com.courzelo.classroom.serviceREST.iservicesREST;

import java.util.List;

import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.entities.dtos.DevoirDTO;








public interface IServiceDevoir {
	public DevoirDTO adddevoir(DevoirDTO f,long idFormation);
	public List<DevoirDTO>getList();
	public List<DevoirDTO>getDevoirByIdFormation(long id);
	public DevoirDTO getDevoirById(long idDevoir); 
	public DevoirDTO updateDevoir(long idDevoir ,DevoirDTO RequestDevoir); 
	public void deleteDevoir(long idDevoir); 

}
