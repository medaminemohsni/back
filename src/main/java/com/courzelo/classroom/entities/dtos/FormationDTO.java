package com.courzelo.classroom.entities.dtos;




import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class FormationDTO {
	
	
	public long idFormation ;
	public long idUserr;
	public String coursename;
	public Date date;
	public String category;
	public String difficultylevel;
	public String coursesummary;
	public String instructorname;
	public String descriptioncourse;
	public String descriptiontrainer;
	public float price;
	private List<String> idQuiz;
	public Boolean test;
	private String typefile;
	
}  



 
 

 


