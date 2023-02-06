package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CalendarController {
	
	@GetMapping(value = "/user/calendar")
	public String calendar() {
		return "calendarView";
	}
}
