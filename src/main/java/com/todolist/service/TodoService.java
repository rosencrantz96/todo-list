package com.todolist.service;


import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dto.TodoDto;
import com.todolist.dto.TodoFormDto;
import com.todolist.entity.Todo;
import com.todolist.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
	private final TodoRepository todoRepository;
	
	// 일정 등록 
	public Long saveTodo(TodoFormDto todoFormDto) throws Exception {
		// 일정 등록
		Todo todo = todoFormDto.createTodo();
		todoRepository.save(todo);
		
		return todo.getTodoId();
	}
	
	// 일정 가져오기 
	@Transactional(readOnly = true)
	public TodoFormDto getTodoDtl(Long todoId) {
		Todo todo = todoRepository.findById(todoId).orElseThrow(EntityNotFoundException::new);
		
		TodoFormDto todoFormDto = TodoFormDto.of(todo);
		
		return todoFormDto;
	}
	
	// 일정 수정 
	public Long updateTodo(TodoFormDto todoFormDto) throws Exception {
		Todo todo = todoRepository.findById(todoFormDto.getTodoId()).orElseThrow(EntityNotFoundException::new);
		
		todo.updateItem(todoFormDto);
		
		return todo.getTodoId();
	}

}
