package com.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>, QuerydslPredicateExecutor<Todo>{
	List<Todo> findByTodoDate(String todoDate);
<<<<<<< HEAD
}
=======
	
	/* Todo findByTodoDateOne(String todoDate); */
} 
>>>>>>> c4a1f15f6843a7945b4bf7888d69d5516edbca41
