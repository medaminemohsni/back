package com.courzelo.classroom.serviceREST;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Phase;
import com.courzelo.classroom.entities.Phase;
import com.courzelo.classroom.entities.Inscription;
import com.courzelo.classroom.entities.Phase;
import com.courzelo.classroom.entities.dtos.PhaseDTO;
import com.courzelo.classroom.entities.dtos.PhaseDTO;
import com.courzelo.classroom.entities.dtos.PhaseDTO;
import com.courzelo.classroom.repositories.PhaseRepository;
import com.courzelo.classroom.repositories.InscriptionRepository;
import com.courzelo.classroom.repositories.PhaseRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IServicePhase;
import com.courzelo.classroom.serviceREST.iservicesREST.IServicePhase;


@Service
public class PhaseBusinesses implements IServicePhase {

          @Autowired
          PhaseRepository phaseRepository;
          @Autowired
          private ModelMapper mapper;
          @Autowired
          private  SequenceGeneratorService sequenceGeneratorService;
		
		@Override
		public List<PhaseDTO> getList() {
			List<Phase> phases = phaseRepository.findAll();
			return phases.stream().map(phase -> mapper.map(phase, PhaseDTO.class))
					.collect(Collectors.toList());
			
		}
		
		@Override
		public PhaseDTO getPhaseById(long idPhase) {
			Phase phase=phaseRepository.findByIdPhase(idPhase);
			PhaseDTO phase1 = mapper.map(phase, PhaseDTO.class);
			return phase1;
			
		}
		@Override
		public PhaseDTO updatePhase(long idPhase, PhaseDTO RequestPhase) {
			  Phase phase = mapper.map(RequestPhase, Phase.class);
				Phase phase2=phaseRepository.findByIdPhase(idPhase);
				
		         phase.setIdPhase(idPhase);
		         phase.setIdsection(phase2.getIdsection());
		        
		         phase.setDate(phase2.getDate());
				Phase newPhase = phaseRepository.save(phase);
				PhaseDTO ResponsePhase = mapper.map(newPhase, PhaseDTO.class);
						
				return ResponsePhase; 
		}
		@Override
		public void deletePhase(long idPhase) {
			Phase phase=phaseRepository.findByIdPhase(idPhase);
			System.out.println(phase);
			phaseRepository.delete(phase);
			
			
		}
		

		@Override
		public List<PhaseDTO> getPhaseByIdSection(long id) {
			List<Phase> phases =phaseRepository.findByIdsection(id);
			return phases.stream().map(phase -> mapper.map(phase, PhaseDTO.class))
					.collect(Collectors.toList());
		}

		@Override
		public PhaseDTO addPhase(PhaseDTO f, long idSection) {
			Phase phase = mapper.map(f, Phase.class);
			 phase.setIdPhase(sequenceGeneratorService.generateSequence(Phase.SEQUENCE_NAME));
			 phase.setIdsection(idSection);
				phase.setDate(new Date());
				Phase newPhase=phaseRepository.save(phase);
				PhaseDTO responsePhase = mapper.map(newPhase, PhaseDTO.class);
				return responsePhase;
		}
		
		
		


}
