package com.courzelo.classroom.apirest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.courzelo.classroom.entities.Post;
import com.courzelo.classroom.entities.dtos.PostDTO;
import com.courzelo.classroom.entities.dtos.PostDTO;
import com.courzelo.classroom.serviceREST.iservicesREST.IServicePost;
import com.courzelo.classroom.serviceREST.iservicesREST.UploadImageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@CrossOrigin
@RequestMapping(value = "/api/Posts")
@RestController

public class PostController {
	@Autowired
	private IServicePost iPost;
	@Autowired
	private UploadImageService uploadImageService;
	 @Autowired
     private ModelMapper mapper;

	
	@PostMapping("/{id}/formation/{idFormation}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PostDTO> createPost(/*@RequestParam("imageFile") MultipartFile file,*/@RequestParam("user") String postDto ,@PathVariable("id") long id,@PathVariable("idFormation") long idFormation) throws IOException{
		//System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Post post= new ObjectMapper().readValue(postDto, Post.class);
		//post.setFile(UploadImageService.compressBytes(file.getBytes()));
	    PostDTO responsePost = mapper.map(post, PostDTO.class);
		responsePost=iPost.addpost(responsePost, id,idFormation);
		return new ResponseEntity<>(responsePost, HttpStatus.OK);

	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PostDTO> UpdatePost(/*@RequestParam("imageFile") MultipartFile file,*/@RequestParam("user") String postDto ,@PathVariable("id") long id) throws IOException{
		//System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Post post= new ObjectMapper().readValue(postDto, Post.class);
		//post.setFile(UploadImageService.compressBytes(file.getBytes()));
	    PostDTO responsePost = mapper.map(post, PostDTO.class);
		responsePost=iPost.updatePost(id, responsePost);
		return new ResponseEntity<>(responsePost, HttpStatus.OK);

	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PostDTO> getAllPosts(){
		
		List<PostDTO>p= iPost.getList();
		
		Collections.sort(p, new Comparator<PostDTO>() {


			@Override
			public int compare(PostDTO o1,PostDTO o2) {
 
			return	0;//o2.getIdPost().compareTo(o1.getIdPost());
			}
		});
		
		return p;
	}
	
	@GetMapping("formation/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<PostDTO> getPostByFormation(@PathVariable("id") long id){
		List<PostDTO> postDto=new ArrayList<PostDTO>();
		List<PostDTO> postDto1= iPost.getPostByIdFormation(id);
		/*for(PostDTO p:postDto1) {
			p.setFile(uploadImageService.decompressBytes(p.getFile()));
			postDto.add(p);
		}*/
		return postDto1;
	}	
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PostDTO getPostById(@PathVariable(name = "id") Long id){
		return iPost.getPostById(id);
	}
	
	
	
	
	
	@DeleteMapping(path = "/{idPost}")
	public void deleteCourse(@PathVariable(name = "idPost") Long idPost) {
		iPost.deletePost(idPost);
		
	}
	
	
	@GetMapping("postprivate/{idformation}")
	@ResponseStatus(HttpStatus.OK)
	public List<PostDTO> getAllPostPrivate(@PathVariable(name = "idformation") Long idformation){
		List<PostDTO> postDto=new ArrayList<PostDTO>();
		List<PostDTO> postDto1= iPost.getAllPostPrivate(true, idformation);
		/*for(PostDTO p:postDto1) {
			p.setFile(uploadImageService.decompressBytes(p.getFile()));
			postDto.add(p);
		}*/
		return postDto;
			
	}
	
	@PutMapping("/post/{id}/private/{statprivate}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PostDTO> updatePostPrivate(@PathVariable("id") long id  , @PathVariable ("statprivate")boolean statprivate) {
		
		PostDTO post=iPost.updatePostpublic(id,statprivate);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
}
