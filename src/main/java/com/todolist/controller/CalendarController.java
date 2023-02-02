package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class CalendarController {
	// 캘린더 화면을 띄워주는 곳
	@GetMapping(value="/calendar")
	public String calendar() {
		return "calendar/calendarView";
	}
}
