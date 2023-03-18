package com.todolist.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.todolist.constant.TodoStatus;
import com.todolist.entity.Member;
import com.todolist.entity.Todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoFormDto {
	private Long id;
	
	@NotNull(message = "날짜를 선택해주세요.")
	private String todoDate;
	
	@NotBlank(message = "일정을 입력해주세요.")
	private String todoContent;
	
	private TodoStatus todoStatus;
	
	private Member member;
	
	private static ModelMapper modelMapper = new ModelMapper();

	public Todo createTodo() {
		return modelMapper.map(this, Todo.class);
	}
	
	public static TodoFormDto of(Todo todo) {
		return modelMapper.map(todo, TodoFormDto.class);
	}
}
