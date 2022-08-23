package com.courzelo.classroom.serviceREST;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Post;
import com.courzelo.classroom.entities.Post;
import com.courzelo.classroom.entities.Inscription;
import com.courzelo.classroom.entities.Post;
import com.courzelo.classroom.entities.dtos.PostDTO;
import com.courzelo.classroom.entities.dtos.PostDTO;
import com.courzelo.classroom.entities.dtos.PostDTO;
import com.courzelo.classroom.repositories.PostRepository;
import com.courzelo.classroom.repositories.InscriptionRepository;
import com.courzelo.classroom.repositories.PostRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IServicePost;
import com.courzelo.classroom.serviceREST.iservicesREST.IServicePost;


@Service
public class PostBusinesses implements IServicePost {

          @Autowired
          PostRepository postRepository;
          @Autowired
          private ModelMapper mapper;
          @Autowired
          private  SequenceGeneratorService sequenceGeneratorService;
		
		@Override
		public List<PostDTO> getList() {
			List<Post> posts = postRepository.findAll();
			return posts.stream().map(post -> mapper.map(post, PostDTO.class))
					.collect(Collectors.toList());
			
		}
		
		@Override
		public PostDTO getPostById(long idPost) {
			Post post=postRepository.findByIdPost(idPost);
			PostDTO post1 = mapper.map(post, PostDTO.class);
			return post1;
			
		}
		@Override
		public PostDTO updatePost(long idPost, PostDTO RequestPost) {
			  Post post = mapper.map(RequestPost, Post.class);
				Post post2=postRepository.findByIdPost(idPost);
				
		         post.setIdPost(idPost);
		         post.setIdformation(post2.getIdformation());
		         post.setIduser(post2.getIduser());
		         post.setDate(post2.getDate());
				Post newPost = postRepository.save(post);
				PostDTO ResponsePost = mapper.map(newPost, PostDTO.class);
						
				return ResponsePost; 
		}
		@Override
		public void deletePost(long idPost) {
			Post post=postRepository.findByIdPost(idPost);
			System.out.println(post);
			postRepository.delete(post);
			
			
		}
		@Override
		public PostDTO addpost(PostDTO f, long idcreateur, long idPost) {
			Post post = mapper.map(f, Post.class);
			 post.setIdPost(sequenceGeneratorService.generateSequence(Post.SEQUENCE_NAME));
				
			post.setIduser(idcreateur);
			post.setIdformation(idPost);
			post.setDate(new Date());
			
			Post newPost=postRepository.save(post);
			PostDTO responsePost = mapper.map(newPost, PostDTO.class);
			return responsePost;
		}

		@Override
		public List<PostDTO> getPostByIdFormation(long id) {
			List<Post> posts =postRepository.findByIdformation(id);
			return posts.stream().map(post -> mapper.map(post, PostDTO.class))
					.collect(Collectors.toList());
		}

		@Override
		public List<PostDTO> getAllPostPrivate(Boolean statprivate, long idFormation) {
			List<Post> posts =postRepository.findByStateprivateAndIdformation(statprivate, idFormation);
			return posts.stream().map(post -> mapper.map(post, PostDTO.class))
					.collect(Collectors.toList());
		}

		@Override
		public PostDTO updatePostpublic(long idPost, Boolean statprivate) {
			 
				Post post=postRepository.findByIdPost(idPost);
		         post.setStateprivate(statprivate);
				Post newPost = postRepository.save(post);
				PostDTO ResponsePost = mapper.map(newPost, PostDTO.class);
						
				return ResponsePost; 
		}

		

}
