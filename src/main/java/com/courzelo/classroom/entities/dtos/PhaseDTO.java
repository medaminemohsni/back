package com.courzelo.classroom.entities.dtos;




import java.util.Date;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class PhaseDTO {
	
	
	public int idPhase ;
	public String title;
	public String postContent;
	public Date date;
	public long idsection;
	
	private String typefile;
	
	
}   




 
 

 


