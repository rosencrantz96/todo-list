package com.todolist.dto;

import javax.validation.constraints.NotBlank;

import com.todolist.constant.TodoStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {
	@NotBlank(message = "일정을 입력해주세요.")
	private String todoContent;
	
	private TodoStatus todoStatus;
}
