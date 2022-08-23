package com.courzelo.classroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.courzelo.classroom.entities.Post;




@Repository
public interface PostRepository extends MongoRepository<Post, Integer> {
	
	public List<Post> findByIdformation(long idFormation);
	public Post findByIdPost(long idPost);
	public List<Post>  findByStateprivateAndIdformation(Boolean statprivate,long idFormation);
	public int countByIduserAndIdformation(long idUser,long idFormation);
	
}
