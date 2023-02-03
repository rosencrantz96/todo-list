package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class TodoController {
	
	// 할 일 페이지를 보여주는 곳 
	@GetMapping(value = "/todo")
	public String todoList() {
		return "todo/todo";
	}
}
