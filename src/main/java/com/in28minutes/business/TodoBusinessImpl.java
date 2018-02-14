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
	 * constructor for To-do Business uses <code>ToDoService<code> 
	 * @param todoService
	 */
	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	/**
	 * Retrieve the list of todo for the specific user
	 * @param user
	 * @return List<String>
	 */
	public List<String> retrieveTodosOf(String user) {
		return todoService.retrieveTodos(user);
	}

	/**
	 * Delete given todo item from the user list and return the new list
	 * @param todo
	 * @param user
	 * @return List<String>
	 */
	public List<String> deleteTodosOf(String todo, String user) {
		return todoService.deleteTodo(todo, user);
	}
}
