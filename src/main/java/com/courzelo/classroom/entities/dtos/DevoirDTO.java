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
public class DevoirDTO {
	
	
	public int idDevoir ;
	public String title;
	public String devoirContent;
	public Date datedebut;
	public Date datefin;
	public long idformation;
	public byte[] file;

	
}   




 
 

 


