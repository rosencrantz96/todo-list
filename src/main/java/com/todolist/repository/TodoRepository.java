package com.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>, QuerydslPredicateExecutor<Todo>{
	List<Todo> findByTodoDate(String todoDate);
}
