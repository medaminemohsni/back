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
public class PostDTO {
	
	
	public int idPost ;
	public String title;
	public Boolean stateprivate;
	public Boolean comment;
	public Boolean important;
	public String postContent;
	public Date date;
	public long idformation;
	public long iduser;
	 
	public String typefile;
	public Boolean test;
	
}   




 
 

 


