package com.mozzishop.www.user.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class UserEntity {
	
	@Id
	@Column(nullable=false)
	private String id;
	
	@Column(nullable=false)
	private String pw;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String nickname;
	
	@Column(nullable=false)
	private String signdate;
	
}
