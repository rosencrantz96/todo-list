package com.todolist.dto;

import java.time.LocalDate;


import com.todolist.constant.TodoStatus;

import lombok.*;

@Getter
@Setter
public class TodoDto {
	private LocalDate todoDate;
	
	private String todoContent;
	
	private TodoStatus todoStatus;
	
	
}
