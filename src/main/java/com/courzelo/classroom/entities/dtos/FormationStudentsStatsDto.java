package com.courzelo.classroom.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FormationStudentsStatsDto {
	private String studentName ;
	private int nbrComments;
	private int nbrPosts;

}
