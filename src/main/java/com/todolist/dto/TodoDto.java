package com.todolist.dto;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import com.todolist.constant.TodoStatus;
import com.todolist.entity.Member;
import com.todolist.entity.Todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {
	private Long id;

	private String todoDate;

	private String todoContent;

	private TodoStatus todoStatus;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static TodoDto of(Todo todo) {
		return modelMapper.map(todo, TodoDto.class);
	}

}
