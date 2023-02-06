package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
	
	// 일정 등록 페이지를 보여줌
	@GetMapping(value = "/user/todo")
	public String todo() {
		return "todo/todo";
	}
}
