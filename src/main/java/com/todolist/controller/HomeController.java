package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	// 메인 화면을 보여주는 곳
	@GetMapping(value="/")
	public String main() {
		return "home/main";
	}
	
	// 회원가입 화면을 보여주는 곳 
	@GetMapping(value="/signup")
	public String signUp() {
		return "home/signup";
	}
	
	// 로그인 페이지를 보여주는 곳
	@GetMapping(value="/login")
	public String login() {
		return "home/login";
	}
}
