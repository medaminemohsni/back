package com.courzelo.classroom.serviceREST;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Devoir;
import com.courzelo.classroom.entities.Devoir;
import com.courzelo.classroom.entities.Inscription;
import com.courzelo.classroom.entities.Devoir;
import com.courzelo.classroom.entities.dtos.DevoirDTO;
import com.courzelo.classroom.entities.dtos.DevoirDTO;
import com.courzelo.classroom.entities.dtos.DevoirDTO;
import com.courzelo.classroom.repositories.DevoirRepository;
import com.courzelo.classroom.repositories.InscriptionRepository;
import com.courzelo.classroom.repositories.DevoirRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceDevoir;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceDevoir;


@Service
public class DevoirBusinesses implements IServiceDevoir {

          @Autowired
          DevoirRepository devoirRepository;
          @Autowired
          private ModelMapper mapper;
          @Autowired
          private  SequenceGeneratorService sequenceGeneratorService;
		
		@Override
		public List<DevoirDTO> getList() {
			List<Devoir> devoirs = devoirRepository.findAll();
			return devoirs.stream().map(devoir -> mapper.map(devoir, DevoirDTO.class))
					.collect(Collectors.toList());
			
		}
		
		@Override
		public DevoirDTO getDevoirById(long idDevoir) {
			Devoir devoir=devoirRepository.findByIdDevoir(idDevoir);
			DevoirDTO devoir1 = mapper.map(devoir, DevoirDTO.class);
			return devoir1;
			
		}
		@Override
		public DevoirDTO updateDevoir(long idDevoir, DevoirDTO RequestDevoir) {
			  Devoir devoir = mapper.map(RequestDevoir, Devoir.class);
				Devoir devoir2=devoirRepository.findByIdDevoir(idDevoir);
				
		         devoir.setIdDevoir(idDevoir);
		         devoir.setIdformation(devoir2.getIdformation());
		      
		         devoir.setDatedebut(devoir2.getDatedebut());
				Devoir newDevoir = devoirRepository.save(devoir);
				DevoirDTO ResponseDevoir = mapper.map(newDevoir, DevoirDTO.class);
						
				return ResponseDevoir; 
		}
		@Override
		public void deleteDevoir(long idDevoir) {
			Devoir devoir=devoirRepository.findByIdDevoir(idDevoir);
			System.out.println(devoir);
			devoirRepository.delete(devoir);
			
			
		}
		@Override
		public DevoirDTO adddevoir(DevoirDTO f, long idDevoir) {
			Devoir devoir = mapper.map(f, Devoir.class);
			 devoir.setIdDevoir(sequenceGeneratorService.generateSequence(Devoir.SEQUENCE_NAME));
				
		
			devoir.setIdformation(idDevoir);
			devoir.setDatedebut(new Date());
			
			Devoir newDevoir=devoirRepository.save(devoir);
			DevoirDTO responseDevoir = mapper.map(newDevoir, DevoirDTO.class);
			return responseDevoir;
		}

		@Override
		public List<DevoirDTO> getDevoirByIdFormation(long id) {
			List<Devoir> devoirs =devoirRepository.findByIdformation(id);
			return devoirs.stream().map(devoir -> mapper.map(devoir, DevoirDTO.class))
					.collect(Collectors.toList());
		}
		
	
		


}
