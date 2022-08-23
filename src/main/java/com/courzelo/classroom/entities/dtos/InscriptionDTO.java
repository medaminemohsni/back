package com.courzelo.classroom.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class InscriptionDTO {
	
	private Long id ;
	private Long idEtudiant ;
	private Long idFormation ;
	private String   name;
	
}
