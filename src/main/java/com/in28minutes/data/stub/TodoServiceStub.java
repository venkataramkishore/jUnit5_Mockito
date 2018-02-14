package com.in28minutes.data.stub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.in28minutes.data.api.TodoService;


/**
 * 
 * @author vkalyana
 *
 */
public class TodoServiceStub implements TodoService {
	
	private Map<String, List<String>> todoList = new HashMap<String, List<String>>();
	
	/**
	 * Constructor create default todo items for the allowed users
	 */
	public TodoServiceStub() {
		this.todoList.put("user1", Arrays.asList("one", "two", "three"));
		this.todoList.put("user2", Arrays.asList("four", "five", "six"));
	}
	
	public List<String> retrieveTodos(String user) {
		return this.todoList.get(user);
	}

	public List<String> deleteTodo(String todo, String user) {
		List<String> todos = this.todoList.get(user);
		
		todos = todos.stream().filter(item -> !item.equals(todo)).collect(Collectors.toList());
		this.todoList.put(user,  todos);
		return this.todoList.get(user);
	}
}
