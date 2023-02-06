package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PageController {
	
	// 마이 페이지를 불러옴
	@GetMapping(value = "/user/pages")
	public String mypage() {
		return "page/myPage";
	}
}
