package com.todolist.dto;

<<<<<<< HEAD

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import com.todolist.constant.TodoStatus;
import com.todolist.entity.Member;
=======
import org.modelmapper.ModelMapper;

import com.todolist.constant.TodoStatus;
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
import com.todolist.entity.Todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {
	private Long id;
<<<<<<< HEAD

	private String todoDate;

=======
	
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
	private String todoContent;

	private TodoStatus todoStatus;
	
	private static ModelMapper modelMapper = new ModelMapper();
<<<<<<< HEAD
=======
	
	public static TodoDto of(Todo todo) {
		return modelMapper.map(todo, TodoDto.class);
	}
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
	
	public static TodoDto of(Todo todo) {
		return modelMapper.map(todo, TodoDto.class);
	}

}
