package com.courzelo.classroom.busnesses;

import java.util.List;

import org.springframework.stereotype.Service;

import com.courzelo.classroom.businesses.iservices.IServiceFormation;
import com.courzelo.classroom.entities.Formation;
import com.courzelo.classroom.entities.dtos.FormationDTO;


@Service
public class FormationBusinesses implements IServiceFormation {



	@Override
	public List<Formation> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addformation(FormationDTO f, String createur) {
		//f.set
		
	}

}
