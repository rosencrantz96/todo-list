package com.todolist.dto;

import org.modelmapper.ModelMapper;

import com.todolist.constant.TodoStatus;
import com.todolist.entity.Todo;

import lombok.*;

@Getter
@Setter
public class TodoDto {
	private Long id;
	
	private String todoContent;
	
	private TodoStatus todoStatus;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static TodoDto of(Todo todo) {
		return modelMapper.map(todo, TodoDto.class);
	}
	
}
