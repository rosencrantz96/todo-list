package com.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.todolist.dto.MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {
	
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nickname;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	public static Member createMember (MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		// 멤버 객체 생성
		Member member = new Member();
		member.setNickname(memberFormDto.getNickname());
		member.setEmail(memberFormDto.getEmail());
		
		// 패스워드는 암호화 처리
		String password = passwordEncoder.encode(memberFormDto.getPassword()); // 비밀번호 암호화
		member.setPassword(password); // 암호화 한 것 저장
		
		return member;
	}
}
