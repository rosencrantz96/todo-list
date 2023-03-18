package com.todolist.service;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

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
		//로그인한 사용자의 정보를 가져온다
		Member member = memberRepository.findByEmail(email);
		
		// 일정 등록
		Todo todo = Todo.createTodo(member, todoFormDto);
		todoRepository.save(todo);
		
		return todo.getId();
	}
	
	// 날짜에 맞는 일정리스트 전부 가져오기 
	@Transactional(readOnly = true)
	public List<TodoDto> getTodoList(String todoDate) {
		List<Todo> todoList = todoRepository.findByTodoDate(todoDate);
		List<TodoDto> todoDtoList = new ArrayList<>();
		
		for (Todo todo : todoList) {
			TodoDto todoDto = TodoDto.of(todo); //엔티티 객체 -> dto 객체로 변환
			todoDtoList.add(todoDto);
		}
		
		return todoDtoList;
	}

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
