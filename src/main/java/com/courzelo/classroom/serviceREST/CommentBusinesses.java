package com.courzelo.classroom.serviceREST;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Comment;
import com.courzelo.classroom.entities.Comment;
import com.courzelo.classroom.entities.Inscription;
import com.courzelo.classroom.entities.Post;
import com.courzelo.classroom.entities.Comment;
import com.courzelo.classroom.entities.dtos.CommentDTO;
import com.courzelo.classroom.entities.dtos.CommentDTO;
import com.courzelo.classroom.entities.dtos.CommentDTO;
import com.courzelo.classroom.repositories.CommentRepository;
import com.courzelo.classroom.repositories.InscriptionRepository;
import com.courzelo.classroom.repositories.PostRepository;
import com.courzelo.classroom.repositories.CommentRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceComment;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceComment;




@Service
public class CommentBusinesses implements IServiceComment {

          @Autowired
          CommentRepository commentRepository;
          @Autowired
          private ModelMapper mapper;
          @Autowired
          private  SequenceGeneratorService sequenceGeneratorService;
          
          @Autowired
          PostRepository postRepository ;
		
		@Override
		public List <CommentDTO> getList() {
			List<Comment> comments = commentRepository.findAll();
			return comments.stream().map(comment -> mapper.map(comment, CommentDTO.class))
					.collect(Collectors.toList());
			
		}
		
		@Override
		public CommentDTO getCommentById(long idComment) {
			Comment comment=commentRepository.findByIdComment(idComment);
			CommentDTO comment1 = mapper.map(comment, CommentDTO.class);
			return comment1;
			
		}
		
		
		
		
		
		
		
		
		
		
		@Override
		public CommentDTO updateComment(long idComment, CommentDTO RequestComment) {
			Comment comment = mapper.map(RequestComment, Comment.class);
			Comment comment2=commentRepository.findByIdComment(idComment);
				
			comment.setIdComment(idComment);
		         comment.setIdPost(comment2.getIdPost());
		         comment.setIdUser(comment2.getIdUser());
		         comment.setDate(comment2.getDate());
		         Comment newComment = commentRepository.save(comment);
		         CommentDTO ResponseComment = mapper.map(newComment, CommentDTO.class);
						
				return ResponseComment; 
		}
		@Override
		public void deleteComment(long idComment) {
			Comment comment=commentRepository.findByIdComment(idComment);
			System.out.println(comment);
			commentRepository.delete(comment);
			
			
		}
		@Override
		public CommentDTO addcomment(CommentDTO f, long idcreateur, long idComment) {
			Comment comment = mapper.map(f, Comment.class);
			comment.setIdComment(sequenceGeneratorService.generateSequence(Comment.SEQUENCE_NAME));
				
			comment.setIdUser(idcreateur);
			comment.setIdPost(idComment);
			comment.setDate(new Date());
			
			Comment newComment=commentRepository.save(comment);
				CommentDTO responseComment = mapper.map(newComment, CommentDTO.class);
			return responseComment;
		}

		@Override
		public List<CommentDTO> getCommentByIdPost(long id) {
			List<Comment> comments =commentRepository.findByIdPost(id);
			return comments.stream().map(comment -> mapper.map(comment, CommentDTO.class))
					.collect(Collectors.toList());
		}

		@Override
		public int countCommentsByUserIdAndFormationId(long idUser, long idFormation) {
			// TODO Auto-generated method stub
			List<Post> postList = postRepository.findByIdformation(idFormation);
			int nbr = 0 ;
			for(Post post :postList)
			{
				nbr= nbr +  commentRepository.countByIdPostAndIdUser(post.getIdPost(),idUser );
			}
			
			return nbr;
		}
		
	
		


}
