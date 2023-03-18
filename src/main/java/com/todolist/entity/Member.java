package com.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.todolist.constant.Role;
import com.todolist.dto.MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member extends BaseEntity {
	
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String email;

	private String name;
	
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	public static Member createMember (MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		// 멤버 객체 생성
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		
		// 패스워드는 암호화 처리
		String password = passwordEncoder.encode(memberFormDto.getPassword()); // 비밀번호 암호화
		member.setPassword(password); // 암호화 한 것 저장
		
		member.setRole(Role.USER);
		
		return member;
	}
}
