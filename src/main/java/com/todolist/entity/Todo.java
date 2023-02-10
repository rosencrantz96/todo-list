package com.todolist.entity;

import java.time.LocalDate;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.todolist.constant.TodoStatus;
import com.todolist.dto.TodoDto;
import com.todolist.dto.TodoFormDto;

import lombok.*;

@Entity
@Table(name = "todo")
@Getter
@Setter
@ToString
public class Todo {
	// TODO : '하루'에 담기는 '일정'은 여러개... 그러니까 날짜 객체에 일정들을 배열로 받아야 하는 것 아닌가? 
	
	@Id
	@Column(name = "todo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long todoId;
	
	/* @Temporal(value = TemporalType.DATE) */
	@Column(name = "todo_date")
	private LocalDate todoDate;
	
	@Column(name = "todo_content")
	private String todoContent;
	
	@Column(name = "todo_status")
	@Enumerated(EnumType.STRING)
	private TodoStatus todoStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member memberId;
	
	// TODO 객체를 생성
	public static Todo createTodo(Member member, TodoDto todoDto) {
		Todo todo = new Todo();
		todo.setMemberId(member);
		
		todo.setTodoDate(todoDto.getTodoDate());
		todo.setTodoContent(todoDto.getTodoContent());
		todo.setTodoStatus(todoDto.getTodoStatus().START);
		
		return todo;
	}

	public void updateItem(TodoFormDto todoFormDto) {
		this.todoId = todoFormDto.getTodoId();
		this.todoDate = todoFormDto.getTodoDate();
		this.todoContent = todoFormDto.getTodoContent();
		this.todoStatus = todoFormDto.getTodoStatus();
	}
}
