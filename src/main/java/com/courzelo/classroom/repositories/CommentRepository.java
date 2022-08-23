package com.courzelo.classroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.classroom.entities.Comment;





@Repository
public interface CommentRepository extends MongoRepository<Comment, Integer> {
	
	public List<Comment> findByIdPost(long idPost);
	public Comment findByIdComment(long idComment);
	
	public int countByIdPostAndIdUser(long idPost, long idUser);
	

}
