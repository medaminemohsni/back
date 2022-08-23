package com.courzelo.classroom.entities;



import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document
@Getter
@Setter
public class Userr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 65981149772133526L;
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private Long id;

	private String providerUserId;

	private String email;

	private String displayName;
	@DBRef
	private List<Chat> chatId;

	public Userr(Long id, String providerUserId, String email, String displayName) {
		super();
		this.id = id;
		this.providerUserId = providerUserId;
		this.email = email;
		this.displayName = displayName;
	}

	public Userr() {
		super();
	}
	
	
}