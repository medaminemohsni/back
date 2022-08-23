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

import com.courzelo.classroom.entities.Devoir;
import com.courzelo.classroom.entities.dtos.DevoirDTO;
import com.courzelo.classroom.entities.dtos.DevoirDTO;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceDevoir;
import com.courzelo.classroom.serviceREST.iservicesREST.UploadImageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@CrossOrigin(origins ="http://localhost:4200/")
@RequestMapping(value = "/api/Devoirs")
@RestController

public class DevoirController {
	@Autowired
	private IServiceDevoir iDevoir;
	@Autowired
	private UploadImageService uploadImageService;
	 @Autowired
     private ModelMapper mapper;

	
	@PostMapping("/{id}/devoir/{idFormation}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<DevoirDTO> createDevoir(@RequestParam("imageFile") MultipartFile file,@RequestParam("user") String postDto ,@PathVariable("id") long id,@PathVariable("idFormation") long idFormation) throws IOException{
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Devoir post= new ObjectMapper().readValue(postDto, Devoir.class);
		post.setFile(UploadImageService.compressBytes(file.getBytes()));
	    DevoirDTO responseDevoir = mapper.map(post, DevoirDTO.class);
		responseDevoir=iDevoir.adddevoir(responseDevoir,idFormation);
		return new ResponseEntity<>(responseDevoir, HttpStatus.OK);

	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<DevoirDTO> UpdateDevoir(@RequestParam("imageFile") MultipartFile file,@RequestParam("user") String postDto ,@PathVariable("id") long id) throws IOException{
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Devoir post= new ObjectMapper().readValue(postDto, Devoir.class);
		post.setFile(UploadImageService.compressBytes(file.getBytes()));
	    DevoirDTO responseDevoir = mapper.map(post, DevoirDTO.class);
		responseDevoir=iDevoir.updateDevoir(id, responseDevoir);
		return new ResponseEntity<>(responseDevoir, HttpStatus.OK);

	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<DevoirDTO> getAllDevoirs(){
		
		List<DevoirDTO>p= iDevoir.getList();
		
		Collections.sort(p, new Comparator<DevoirDTO>() {


			@Override
			public int compare(DevoirDTO o1,DevoirDTO o2) {
 
			return	0;//o2.getIdDevoir().compareTo(o1.getIdDevoir());
			}
		});
		
		return p;
	}
	
	@GetMapping("devoir/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<DevoirDTO> getDevoirByFormation(@PathVariable("id") long id){
		List<DevoirDTO> postDto=new ArrayList<DevoirDTO>();
		List<DevoirDTO> postDto1= iDevoir.getDevoirByIdFormation(id);
		for(DevoirDTO p:postDto1) {
			p.setFile(uploadImageService.decompressBytes(p.getFile()));
			postDto.add(p);
		}
		return postDto;
	}	
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DevoirDTO getDevoirById(@PathVariable(name = "id") Long id){
		return iDevoir.getDevoirById(id);
	}
	
	
	
	
	
	@DeleteMapping(path = "/{idDevoir}")
	public void deleteCourse(@PathVariable(name = "idDevoir") Long idDevoir) {
		iDevoir.deleteDevoir(idDevoir);
		
	}
}
