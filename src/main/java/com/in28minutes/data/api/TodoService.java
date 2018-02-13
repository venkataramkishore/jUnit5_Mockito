package com.in28minutes.data.api;

import java.util.List;

// External Service - Lets say this comes from WunderList
/**
 * 
 * @author vkalyana
 *
 */
public interface TodoService {

	public List<String> retrieveTodos(String user);

	List<String> deleteTodo(String todo, String user);

}