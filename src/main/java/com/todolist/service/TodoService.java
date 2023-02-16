package com.todolist.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dto.TodoDto;
import com.todolist.dto.TodoFormDto;
import com.todolist.entity.Member;
import com.todolist.entity.Todo;
import com.todolist.repository.MemberRepository;
import com.todolist.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
	private final TodoRepository todoRepository;
	private final MemberRepository memberRepository;
	
	// 일정 등록 
	public Long saveTodo(TodoFormDto todoFormDto, String email) throws Exception {
		// 로그인 한 사용자의 정보를 가져온다
		Member member = memberRepository.findByEmail(email);
		
		// 일정을 등록한다 
		Todo todo = Todo.createTodo(member, todoFormDto);
		todoRepository.save(todo);
		
		return todo.getId();
	}

	// 날짜에 맞는 일정 리스트를 가져오기 (일정은 하루에 여러개일 수 있으니 List에 담아서 사용) 
	@Transactional(readOnly = true)
	public List<TodoDto> getTodoList(String todoDate) {
		List<Todo> todoList = todoRepository.findByTodoDate(todoDate);
		List<TodoDto> todoDtoList = new ArrayList<>();
		
		for (Todo todo : todoList) { // 리스트로 받아온 거니까 for문으로 하나씩 풀어주기 
			TodoDto todoDto = TodoDto.of(todo); // 엔티티 객체를 DTO 객체로 변환시킴 
			todoDtoList.add(todoDto);
		}
		
		return todoDtoList;
	}
	
	/*
	 * // 오늘 날짜의 일정 리스트 가져오기 public TodoDto getTodayList(String todoDate) { Todo
	 * todayList = }
	 */
	
	
	/*
	 * // 날짜 데이터를 가져오기 public String showDate() { Todo todo =
	 * todoRepository.findByTodoDateOne(getDate());
	 * 
	 * }
	 */
	
	
	
	/*	
	 * // 일정 수정 public Long updateTodo(TodoFormDto todoFormDto) throws Exception {
	 * Todo todo = todoRepository.findById(todoFormDto.getTodoId()).orElseThrow(
	 * EntityNotFoundException::new);
	 * 
	 * todo.updateItem(todoFormDto);
	 * 
	 * return todo.getTodoId(); }
	 */

}
