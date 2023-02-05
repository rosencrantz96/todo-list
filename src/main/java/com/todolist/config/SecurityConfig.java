package com.todolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.todolist.service.MemberService;

@Configuration // 스프링에서 설정 클래스로 사용하겠다는 어노테이션 
@EnableWebSecurity // springSecurityFilterChain이 자동으로 포함됨
public class SecurityConfig {

	@Autowired
	MemberService memberService;
	
	
}
