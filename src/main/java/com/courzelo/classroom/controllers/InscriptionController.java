package com.courzelo.classroom.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.courzelo.classroom.businesses.iservices.IServiceInscription;
import com.courzelo.classroom.entities.Formation;
import com.courzelo.classroom.entities.Userr;
import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.entities.dtos.InscriptionDTO;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceFormation;

@CrossOrigin
@RequestMapping(value = "/api/Inscriptions")
@RestController
public class InscriptionController {
	@Autowired
	private IServiceInscription iInscription;
	@PostMapping("/{id}/Formation/{idFormation}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<InscriptionDTO> createInscription(@RequestBody InscriptionDTO inscription ,@PathVariable("id") Long id,@PathVariable("idFormation") Long idFormation){
		inscription=iInscription.addInscription(inscription, id, idFormation);
		return new ResponseEntity<>(inscription, HttpStatus.OK);

	}
	
	@GetMapping("/{idFormation}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Userr>  getInscriptionUserr(@PathVariable("idFormation") Long idFormation){
		return iInscription.getListInscription(idFormation);

	}

	@GetMapping("/getAllFormationsByUser/{idUser}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<FormationDTO> getAllFormationsByUser(@PathVariable("idUser") Long idUser)
	
	{
		return iInscription.getAllFormationsByUser(idUser);
		
	}
	
	@GetMapping("/checkFormationByUser/{idFormation}/{idUser}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean checkFormationByUser(@PathVariable("idFormation") Long idFormation , @PathVariable("idUser") Long idUser)
	
	{
		return iInscription.checkFormationByUser(idFormation , idUser);
		
	}
  //get incription by user / return List<Formation>
  //GetMeetByidFormation / return list<meet>

}
