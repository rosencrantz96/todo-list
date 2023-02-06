package com.todolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.todolist.service.MemberService;

@Configuration
@EnableWebSecurity
public class SercurityConfig {
	@Autowired
	MemberService memberService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 로그인에 대한 설정
		http.formLogin().loginPage("/members/login") // 로그인 페이지 url설정
				.defaultSuccessUrl("/") // 로그인 성공 시 이동할 페이지
				.usernameParameter("email") // 로그인 시 사용할 파라메터 이름
				.failureUrl("/members/login/error") // 로그인 실패 시 이동할 url
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/members/logout")) // 로그아웃 url
				.logoutSuccessUrl("/"); // 로그아웃 성공 시 이동할 url

		// 페이지의 접근에 관한 설정
		http.authorizeRequests()
		.mvcMatchers("/css/**", "/js/**", "/imges/**").permitAll() 
		.mvcMatchers("/", "/members/**").permitAll() // 모든 사용자가 로그인(인증) 없이 접근할 수 있도록 설정 (경로를 지정해줘야 함)
		.mvcMatchers("/user/**").hasRole("USER") // '/admin'으로 시작하는 경로는 계정이 ADMIN role일 경우에만 접근 가능하도록 설정 
		.anyRequest().authenticated(); // 그 외 페이지는 모두 로그인(인증)을 받아야 한다.

		// 인증되지 않은 사용자가 리소스(페이지, 이미지 등..)에 접근했을 때 설정
		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());

		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
