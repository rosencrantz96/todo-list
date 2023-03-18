package com.todolist.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todolist.dto.TodoDto;
import com.todolist.dto.TodoFormDto;
import com.todolist.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;

	// 캘린더 페이지를 보여줌
	@GetMapping(value = "/user/calendar")
	public String calendar() {
		return "todo/calendar";
	}

	// 일정 페이지를 보여줌
	@GetMapping(value = "/user/todo")
	public String todo(@RequestParam String year, @RequestParam String month, @RequestParam String day, Model model) {
		String todoDate = LocalDate
				.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		try {
			List<TodoDto> todoDtoList = todoService.getTodoList(todoDate);
			model.addAttribute("todos", todoDtoList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "일정을 가져오지 못했습니다.");
		}	
		
		return "todo/todo";
	}
	
	// 일정 등록 페이지를 보여줌 
	@GetMapping(value = "/user/todoForm")
	public String todoForm(Model model) {
		model.addAttribute("todoFormDto", new TodoFormDto());
		return "todo/todoForm";
	}
	
	// 일정 등록
	@PostMapping(value = "/user/todo")
	public String addTodo(@Valid TodoFormDto todoFormDto, BindingResult bindingResult, Model model, Principal principal) {
		
		if(bindingResult.hasErrors()) {
			return "todo/todoForm";
		}
		
		String email = principal.getName();
		 
		try {
			todoService.saveTodo(todoFormDto, email);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "일정 등록 중 에러가 발생했습니다.");
			return "item/itemForm";
		}
		
		
		
		return "todo/todo";
	}
}
