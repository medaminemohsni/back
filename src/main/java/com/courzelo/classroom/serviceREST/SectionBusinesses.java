package com.courzelo.classroom.serviceREST;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Section;
import com.courzelo.classroom.entities.Section;
import com.courzelo.classroom.entities.Inscription;
import com.courzelo.classroom.entities.Section;
import com.courzelo.classroom.entities.dtos.SectionDTO;
import com.courzelo.classroom.entities.dtos.SectionDTO;
import com.courzelo.classroom.entities.dtos.SectionDTO;
import com.courzelo.classroom.repositories.SectionRepository;
import com.courzelo.classroom.repositories.InscriptionRepository;
import com.courzelo.classroom.repositories.SectionRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceSection;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceSection;


@Service
public class SectionBusinesses implements IServiceSection {

          @Autowired
          SectionRepository sectionRepository;
          @Autowired
          private ModelMapper mapper;
          @Autowired
          private  SequenceGeneratorService sequenceGeneratorService;
		
		@Override
		public List<SectionDTO> getList() {
			List<Section> sections = sectionRepository.findAll();
			return sections.stream().map(section -> mapper.map(section, SectionDTO.class))
					.collect(Collectors.toList());
			
		}
		
		@Override
		public SectionDTO getSectionById(long idSection) {
			Section section=sectionRepository.findByIdSection(idSection);
			SectionDTO section1 = mapper.map(section, SectionDTO.class);
			return section1;
			
		}
		@Override
		public SectionDTO updateSection(long idSection, SectionDTO RequestSection) {
			  Section section = mapper.map(RequestSection, Section.class);
				Section section2=sectionRepository.findByIdSection(idSection);
				
		         section.setIdSection(idSection);
		         section.setIdformation(section2.getIdformation());
		        
		         section.setDate(section2.getDate());
				Section newSection = sectionRepository.save(section);
				SectionDTO ResponseSection = mapper.map(newSection, SectionDTO.class);
						
				return ResponseSection; 
		}
		@Override
		public void deleteSection(long idSection) {
			Section section=sectionRepository.findByIdSection(idSection);
			System.out.println(section);
			sectionRepository.delete(section);
			
			
		}
		

		@Override
		public List<SectionDTO> getSectionByIdFormation(long id) {
			List<Section> sections =sectionRepository.findByIdformation(id);
			return sections.stream().map(section -> mapper.map(section, SectionDTO.class))
					.collect(Collectors.toList());
		}

		@Override
		public SectionDTO addSection(SectionDTO f, long idFormation) {
			Section section = mapper.map(f, Section.class);
			 section.setIdSection(sequenceGeneratorService.generateSequence(Section.SEQUENCE_NAME));
			 section.setIdformation(idFormation);
				section.setDate(new Date());
				Section newSection=sectionRepository.save(section);
				SectionDTO responseSection = mapper.map(newSection, SectionDTO.class);
				return responseSection;
		}
		
		
		


}
