package com.microservice.user.service.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Hotel_Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private String id;
	//@Column(name = "Name")
	private String name;
	//@Column(name = "Email")
	private String email;
	//@Column(name = "Address")
	private String address;
	@Column(name = "Age")
	private int age;
	@Transient
	private List<Rating> ratings=new ArrayList<Rating>();
}
