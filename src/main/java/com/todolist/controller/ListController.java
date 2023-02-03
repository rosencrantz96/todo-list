package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class ListController {
	
	@GetMapping(value="/list")
	public String listView() {
		return "list/listHome";
	}
	
	@GetMapping(value = "/added")
	public String addedListView() {
		return "list/addedList";
	}
}
