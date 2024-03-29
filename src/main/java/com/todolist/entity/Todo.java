package com.todolist.entity;

import java.time.LocalDate;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.todolist.constant.TodoStatus;
import com.todolist.dto.TodoFormDto;

import lombok.*;

@Entity
@Table(name = "todo")
@Getter
@Setter
@ToString
<<<<<<< HEAD
public class Todo extends BaseEntity {
=======
public class Todo extends BaseEntity { // BaseEntity를 상속받아서 최초 작성 시간, 등록자, 등의 정보를 받게 함
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
	// TODO : '하루'에 담기는 '일정'은 여러개... 그러니까 날짜 객체에 일정들을 배열로 받아야 하는 걸까...?

	@Id
	@Column(name = "todo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String todoDate;

	@Lob
	private String todoContent;

	@Enumerated(EnumType.STRING)
	private TodoStatus todoStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	// todo 객체를 생성
	public static Todo createTodo(Member member, TodoFormDto todoFormDto) {
		Todo todo = new Todo();
		todo.setMember(member);
		todo.setTodoDate(todoFormDto.getTodoDate());
		todo.setTodoContent(todoFormDto.getTodoContent());
		todo.setTodoStatus(TodoStatus.START);
<<<<<<< HEAD

		return todo;
	}

=======
		
		return todo;
	}
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
	/*
	 * public void updateItem(TodoFormDto todoFormDto) { this.todoId =
	 * todoFormDto.getTodoId(); this.todoDate = todoFormDto.getTodoDate();
	 * this.todoContent = todoFormDto.getTodoContent(); this.todoStatus =
	 * todoFormDto.getTodoStatus(); }
	 */
}
