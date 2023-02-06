package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CalendarController {
	
	// 캘린더 페이지를 보여줌 
	@GetMapping(value = "/user/calendar")
	public String calendar() {
		return "calendar/calendar";
	}
}
