package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PageController {
	// 마이페이지 불러오기
	@GetMapping(value = "/user/pages")
	public String myPage() {
		return "page/myPage";
	}
}
