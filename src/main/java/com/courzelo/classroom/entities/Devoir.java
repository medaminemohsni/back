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

@Document(collection="Devoir")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Devoir {
	

	   @Transient
    public static final String SEQUENCE_NAME = "database_sequences";
	    
	    @Id
	    @Field(value = "IdDevoir")
	    private long idDevoir;

	    @Field(value = "DevoirContent")
	    private String devoirContent;

	    @Field(value = "Title")
	    private String title;

	
	    @Field(value = "Datedebut")
	    private Date datedebut;
	    
	    @Field(value = "Datefin")
	    private Date datefin;
	
	    @Field(value = "IdFormation")
	    private long idformation;
	    
	    @Field(value = "File")
	    private byte[] file;
	    
	  
	    

	    
}
