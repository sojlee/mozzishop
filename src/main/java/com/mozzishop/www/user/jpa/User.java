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
	private String password;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@Column
	private String birth;
	
	@Column
	private String username;
	
	@Column
	private String nickname;
	
	@Column
	private LocalDateTime signDate;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Grade grade;
	
	@Column
	@Enumerated(EnumType.STRING)
	private SocialType socialType;
	
	@Builder
	public UserEntity(String id, String password, String phone, String email, String birth,
			String username, String nickname, LocalDateTime signDate, Grade grade, SocialType socialType) {
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.username = username;
		this.nickname = nickname;
		this.signDate = signDate;
		this.grade = grade;
		this.socialType = socialType;
	}
	
}
