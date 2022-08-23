package com.courzelo.classroom.serviceREST.iservicesREST;

import java.util.List;

import com.courzelo.classroom.entities.dtos.CommentDTO;










public interface IServiceComment {
	public CommentDTO addcomment(CommentDTO f,long idcreateur ,long idFormation);
	public List<CommentDTO>getList();
	public List<CommentDTO>getCommentByIdPost(long id);
	public CommentDTO getCommentById(long idComment); 
	public CommentDTO updateComment(long idComment ,CommentDTO RequestComment); 
	public void deleteComment(long idPost); 
	
	public int countCommentsByUserIdAndFormationId(long idUser ,long idFormation); 

}
