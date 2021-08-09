package com.gumi.grpc.example.client.hello.infrastructure.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensaje")
public class MessageEntity implements Serializable{

	private static final long serialVersionUID = 7468753698698168019L;
	
	@Id
	private Integer id;
	
	@Column(name = "nombre")
	private String name;

	@Column(name = "ciudad")
	private String city;
	
	@Column(name = "mensaje")
	private String message;
}

