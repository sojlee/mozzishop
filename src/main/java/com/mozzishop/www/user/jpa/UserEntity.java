package com.mozzishop.www.user.jpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="user")
public class UserEntity{
	
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
	private LocalDateTime signdate;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Grade grade;
	
	@Column
	@Enumerated(EnumType.STRING)
	private SocialType socialType;
	
	@Builder
	public UserEntity(String id, String pw, String username, String nickname, 
			LocalDateTime signdate, Grade grade, SocialType socialType) {
		this.id = id;
		this.pw = pw;
		this.username = username;
		this.nickname = nickname;
		this.signdate = signdate;
		this.grade = grade;
		this.socialType = socialType;
	}
	
}
