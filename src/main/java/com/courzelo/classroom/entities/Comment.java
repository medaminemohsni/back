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

@Document(collection="Comment")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
	

	   @Transient
    public static final String SEQUENCE_NAME = "database_sequences";
	    
	    @Id
	    @Field(value = "IdComment")
	    private long idComment;

	    @Field(value = "CommentContent")
	    private String commentContent;

	    
	    @Field(value = "Date")
	    private Date date;
	
	    @Field(value = "IdPost")
	    private long idPost;
	    
	    @Field(value = "IdUser")
	    private long idUser;
	    
	   
	   
	    
	    
	    
	    

	    
}
