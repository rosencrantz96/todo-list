package com.todolist.entity;

<<<<<<< HEAD
import java.time.LocalDate;

=======
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
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
<<<<<<< HEAD
import com.todolist.constant.TodoStatus;
=======
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "diary")
@Getter
@Setter
@ToString
public class Diary extends BaseEntity {
<<<<<<< HEAD
=======
	
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
	@Id
	@Column(name = "diary_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Lob
	private String diaryContent;
	
	@Enumerated(EnumType.STRING)
	private DiaryStatus diaryStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
<<<<<<< HEAD
	@JoinColumn(name = "member_id") 
	private Member member;
	
	private String diaryDate;

=======
	@JoinColumn(name = "member_id")
	private Member member;
	
	private String diaryDate;
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
}
