package com.in28minutes.data.api;

import java.util.List;

/**
 * 
 * @author vkalyana
 *
 */
public interface TodoService {

	/**
	 * Retrieve the list of todo for the specific user
	 * @param user
	 * @return List<String>
	 */
	public List<String> retrieveTodos(String user);

	/**
	 * Delete given todo item from the user list and return the new list
	 * @param todo
	 * @param user
	 * @return List<String>
	 */
	List<String> deleteTodo(String todo, String user);

}