package com.todolist.controller;

import java.security.Principal;
<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
=======
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
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
<<<<<<< HEAD
	private final TodoService todoService;
=======
	private final TodoService todoService; // 의존성 주입
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41

	// 캘린더 페이지를 보여줌
	@GetMapping(value = "/user/calendar")
	public String calendar() {
		return "todo/calendar";
	}

<<<<<<< HEAD
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
=======
	// today 페이지를 보여줌
	@GetMapping(value = "/user/today")
	public String todoToday() {
		return "/todo/today";
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
	}
	
	// today 메뉴 누르면 오늘 날짜의 일정 페이지를 보여줌 
	public String showTodayTodoList(@RequestParam String year, @RequestParam String month, @RequestParam String day, Model model) {
		String todoDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		try {
			LocalDate todayList;
			
			
			List<TodoDto> todoDtoList = todoService.getTodoList(todoDate);
			model.addAttribute("todos", todoDtoList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "일정을 가져오지 못했습니다.");
		}

		return "todo/todo";
	}

	// 캘린더 날짜를 누르면 해당 날짜의 일정 페이지를 보여줌
	@GetMapping(value = "/user/todo")
	public String todo(@RequestParam String year, @RequestParam String month, @RequestParam String day, Model model) {
		String todoDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))
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
<<<<<<< HEAD
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
		 
=======
		// 처음 입력 폼을 조회할 때 입력 폼은 모두 비어있어야 한다. 때문에 빈 객체를 전달해주어야 페이지를 업로드 할 수 있다.
		// https://velog.io/@minnseong/Neither-BindingResult-nor-plain-target-object-for-bean-name-questionForm-available-as-request-attribute-%EC%98%88%EC%99%B8
		model.addAttribute("todoFormDto", new TodoFormDto());
		return "todo/todoForm";
	}

	// 일정 등록
	@PostMapping(value = "/user/todo")
	public String addTodo(@Valid TodoFormDto todoFormDto, BindingResult bindingResult, Model model,
			Principal principal) {

		if (bindingResult.hasErrors()) {
			return "todo/todoForm"; // 에러 발생 시 등록 페이지 다시 띄움
		}

		String email = principal.getName();

>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
		try {
			todoService.saveTodo(todoFormDto, email);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "일정 등록 중 에러가 발생했습니다.");
<<<<<<< HEAD
			return "item/itemForm";
		}
		
		
		
=======
			return "todo/todoForm";
		}

>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
		return "todo/todo";
	}
}
