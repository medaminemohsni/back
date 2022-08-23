package com.courzelo.classroom.serviceREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Formation;
import com.courzelo.classroom.entities.Inscription;
import com.courzelo.classroom.entities.Userr;
import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.entities.dtos.FormationStudentsStatsDto;
import com.courzelo.classroom.entities.dtos.FormationTeacherDTO;
import com.courzelo.classroom.entities.dtos.InscriptionappDTO;
import com.courzelo.classroom.repositories.FormationRepository;
import com.courzelo.classroom.repositories.InscriptionRepository;
import com.courzelo.classroom.repositories.PostRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceComment;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceFormation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FormationBusinesses implements IServiceFormation {

          @Autowired
          FormationRepository formationRepository;
          @Autowired
          InscriptionRepository inscriptionRepository ;
        
          @Autowired
          private ModelMapper mapper;
          @Autowired
          private  SequenceGeneratorService sequenceGeneratorService;
          
          @Autowired
          
          IServiceComment iServiceComment;

          @Autowired
          RestTemplateBuilder restTemplateBuilder;
          
          @Autowired
          PostRepository postRepository;
          private static final String GET_USER_BY_ID_API = "http://localhost:8087/api/auth/getUser/{id}";
          
          
	@Override
	public List<FormationDTO> getList() {
		List<Formation> formations= formationRepository.findAll();
		return formations.stream().map(formation -> mapper.map(formation, FormationDTO.class))
				.collect(Collectors.toList());
	}

	
	
	public Userr getUserByRestTemplate(long id){
		Map<String, Long> param = new HashMap<>();
		param.put("id", id);
		Userr userr = restTemplateBuilder.build().getForObject(GET_USER_BY_ID_API, Userr.class, param);
		return userr;
}
	

	@Override
	public FormationDTO addformation(FormationDTO f, Long idUserr) {
		  Formation formation = mapper.map(f, Formation.class);
		   formation.setIdFormation(sequenceGeneratorService.generateSequence(Formation.SEQUENCE_NAME));
		   formation.setTest(true);
		   formation.setIdUserr(idUserr);
	       Formation newFormation = formationRepository.save(formation);
	       
	       FormationDTO responseFormation = mapper.map(newFormation, FormationDTO.class);
	       return responseFormation;
	}



	@Override
	public FormationDTO getFormationById(long idFormation) {
		Formation formation=formationRepository.findByIdFormation(idFormation);
		return mapper.map(formation, FormationDTO.class);
	}



	@Override
	public FormationDTO UpdateFormation(long idFormation, FormationDTO RequestFormation) {
         Formation formation = mapper.map(RequestFormation, Formation.class);
		
	
         formation.setIdFormation(idFormation);
		Formation newFormation = formationRepository.save(formation);
		FormationDTO ResponseFormation = mapper.map(newFormation, FormationDTO.class);
				
		return ResponseFormation; 
		
	
	}



	@Override
	public void DeleteFormation(long idFormation) {
		Formation formation = formationRepository.findByIdFormation(idFormation); 
		formation.setTest(false);
		 formation.setIdFormation(idFormation);
		Formation newFormation = formationRepository.save(formation);
		
		
	}



	@Override
	public List<Formation> getFormationByIdStudent(Long id) {
		List<Formation> formations=new ArrayList<Formation>();
		List<Inscription> inscriptions= inscriptionRepository.findByIdEtudiant(id);
		log.info("resultat ", formations, inscriptions);
		for(Inscription i:inscriptions) {
			Formation f=formationRepository.findByIdFormation(i.getIdFormation());
			formations.add(f);
			log.info("resultat ", formations, inscriptions);
			
		}
		System.out.println("fghjk"+formations);
		return formations;
		
	}



	@Override
	public List<FormationDTO> getFormtionByIdCreator(Long id) {
		List<Formation> formations=formationRepository.findByIdUserr(id);
		 return formations.stream().map(formation -> mapper.map(formation, FormationDTO.class))
					.collect(Collectors.toList());
	}



	@Override
	public List<FormationDTO> getFormtionByTest(Boolean test,Long id) {
	
		List<Formation> formations= formationRepository.findByTestAndIdUserr(test, id);
		return formations.stream().map(formation -> mapper.map(formation, FormationDTO.class))
				.collect(Collectors.toList());
	}

	public FormationDTO addQuiz(long id,String idQuiz) {
        
		Formation formation = formationRepository.findByIdFormation(id);
    	if(formation.getIdQuiz()==null) {
    		formation.setIdQuiz(new ArrayList<String>());
    	}
    	
    	List<String> ids =formation.getIdQuiz();
    	ids.add(idQuiz);
    	formation.setIdQuiz(ids);
    	Formation F = formationRepository.save(formation);
    	return mapper.map(F, FormationDTO.class);
   
    }
	
	public List<InscriptionappDTO> getStats(Long id)
	{
		 List<FormationDTO> formations=  this.getFormtionByIdCreator( id);
		 List<InscriptionappDTO> result = new ArrayList<InscriptionappDTO>();
		 
		 for(FormationDTO item:formations )
		 {
			 InscriptionappDTO inscriptionappDTO =  new InscriptionappDTO();
			 inscriptionappDTO.setIdFormation(item.getIdFormation());
			 inscriptionappDTO.setNameFormation(item.getCoursename());
			 inscriptionappDTO.setNbrEtudiants(inscriptionRepository.countByIdFormation(item.getIdFormation()));
			 result.add(inscriptionappDTO);
		 }
		 return result;
	 }



	@Override
	public List<FormationTeacherDTO> getFormtionByIdInstructor(Long id) {
		// TODO Auto-generated method stub
		List<Formation> formations=formationRepository.findByIdUserr(id);
		 return formations.stream().map(formation -> mapper.map(formation, FormationTeacherDTO.class))
					.collect(Collectors.toList());
	}



	@Override
	public List<FormationStudentsStatsDto> getStatsFormationStudents(Long idFormation) {
		// TODO Auto-generated method stub
		List<FormationStudentsStatsDto> result = new ArrayList<FormationStudentsStatsDto>();
		List<Userr> users=new  ArrayList<Userr>();
		List<Inscription> inscriptions=inscriptionRepository.findByIdFormation(idFormation);
               /* for(Inscription i:inscriptions) {
                	Userr user=this.getUserByRestTemplate(i.getIdEtudiant());
                	users.add(user);
                }*/
		
		inscriptions.forEach(
				elem -> {
					FormationStudentsStatsDto formationStudentsStatsDto = new FormationStudentsStatsDto();
					formationStudentsStatsDto.setStudentName("firas");
					formationStudentsStatsDto.setNbrPosts(postRepository.countByIduserAndIdformation(elem.getIdEtudiant(), idFormation));
					formationStudentsStatsDto.setNbrComments(iServiceComment.countCommentsByUserIdAndFormationId(elem.getIdEtudiant(), idFormation));
					result.add(formationStudentsStatsDto);
				}
				);
		return result;
	}
}
