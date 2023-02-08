package com.todolist.entity;

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

import com.todolist.constant.DiaryStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "diary")
@Getter
@Setter
@ToString
public class Diary {
	// TODO : 마찬가지로... 일기도 '하루'에 담겨야 하는거니까... 날짜 객체에 일기를 담아야 하는 것 아닐까? 일정(들)에 일기가 담기는 것이 아니라 날짜 하루에 일기가 담기는 거니까... 엔티티/dto 설계를 다시 해야 할 듯... 
	
	@Id
	@Column(name = "diary_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long diaryId;
	
	@Column(name = "diart_status")
	@Enumerated(EnumType.STRING)
	private DiaryStatus diaryStatus;
	
	@Column(name = "diary_content")
	private String diaryContent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "todo_id")
	@Column(name = "todo_id")
	private Todo todoId;
}
