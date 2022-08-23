package com.courzelo.classroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.classroom.entities.Formation;
import com.courzelo.classroom.entities.Inscription;


@Repository
public interface InscriptionRepository extends MongoRepository<Inscription, Integer> {
	//this repository contain all operations of mongodb
	public  List<Inscription> findByIdEtudiant(long idStudent ) ;
	public  List<Inscription> findByIdFormation(long idStudent ) ;
	//public boolean existByIdUserAndIdFormation(long iduser, long idFormation );
	public List<Inscription> findAllByIdEtudiant(long idStudent);
	
	public boolean existsByIdFormationAndIdEtudiant( long idFormation , long idStudent);
	public int countByIdFormation(long idFormation);

	
	 

}
