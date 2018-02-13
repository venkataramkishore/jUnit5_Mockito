package com.in28minutes.business;

import java.util.List;

import com.in28minutes.data.api.TodoService;
/**
 * 
 * @author vkalyana
 *
 */
public class TodoBusinessImpl {

	private TodoService todoService;

	/**
	 * 
	 * @param todoService
	 */
	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<String> retrieveTodosOf(String user) {
		return todoService.retrieveTodos(user);
	}

	/**
	 * 
	 * @param todo
	 * @param user
	 * @return
	 */
	public List<String> deleteTodosOf(String todo, String user) {
		return todoService.deleteTodo(todo, user);
	}
}
