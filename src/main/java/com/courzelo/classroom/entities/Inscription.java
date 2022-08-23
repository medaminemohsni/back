package com.courzelo.classroom.entities;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection="Inscription")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Inscription {
	
	
	private Long id ;
	private Long idEtudiant ;
	private Long idFormation ;
	private String   name;
	

	
}
