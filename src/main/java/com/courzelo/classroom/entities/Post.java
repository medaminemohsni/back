package com.courzelo.classroom.entities;



import java.util.Date;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="Post")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
	

	   @Transient
    public static final String SEQUENCE_NAME = "database_sequences";
	    
	    @Id
	    @Field(value = "IdPost")
	    private long idPost;

	    @Field(value = "PostContent")
	    private String postContent;

	    @Field(value = "Title")
	    private String title;

	    @Field(value = "StatePrivate")
	    private Boolean stateprivate;
	    
	    @Field(value = "Comment")
	    private Boolean comment;
	    
	    @Field(value = "important")
	    private Boolean important;
	
	    @Field(value = "Date")
	    private Date date;
	
	    @Field(value = "IdFormation")
	    private long idformation;
	    
	    @Field(value = "IdUser")
	    private long iduser;
	    
	   
	    @Field(value = "typefile")
	    private String typefile;
	    
	    @Field(value = "test")
		public Boolean test;
	    
	    

	    
}
