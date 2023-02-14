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
import javax.persistence.Lob;
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
public class Diary extends BaseEntity {
	
	@Id
	@Column(name = "diary_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Lob
	private String diaryContent;
	
	@Enumerated(EnumType.STRING)
	private DiaryStatus diaryStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	private String diaryDate;
}
