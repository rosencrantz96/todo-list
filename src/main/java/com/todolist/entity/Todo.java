package com.todolist.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.todolist.constant.TodoStatus;
import com.todolist.dto.TodoDto;

import lombok.*;

@Entity
@Table(name = "todo")
@Getter
@Setter
@ToString
public class Todo {
	
	@Id
	@Column(name = "todo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long todoId;
	
	/* private LocalDateTime listDate; */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	@Column(name = "todo_content")
	private String todoContent;
	
	@Enumerated(EnumType.STRING)
	private TodoStatus todoStatus;
	
	// todo 객체를 생성
	public static Todo createTodo(Member member, TodoDto todoDto) {
		Todo todo = new Todo();
		todo.setMember(member);
		
		todo.setTodoContent(todoDto.getTodoContent());
		todo.setTodoStatus(todoDto.getTodoStatus());
		
		return todo;
	}
}
