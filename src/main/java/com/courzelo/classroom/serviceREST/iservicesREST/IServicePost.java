package com.courzelo.classroom.serviceREST.iservicesREST;

import java.util.List;

import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.entities.dtos.PostDTO;








public interface IServicePost {
	public PostDTO addpost(PostDTO f,long idcreateur ,long idFormation);
	public List<PostDTO>getList();
	public List<PostDTO>getPostByIdFormation(long id);
	public PostDTO getPostById(long idPost); 
	public PostDTO updatePost(long idPost ,PostDTO RequestPost); 
	public void deletePost(long idPost); 
    public List<PostDTO> getAllPostPrivate(Boolean statprivate,long idFormation);
    public PostDTO updatePostpublic(long idPost ,Boolean statprivate); 
}
