/**
 * 
 */
package com.in28minutes.business;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.in28minutes.data.stub.TodoServiceStub;
import com.in28minutes.business.TodoBusinessImpl;

/**
 * @author vkalyana
 *
 */
@DisplayName("Todo List tests")
 class TodoBusinessImplTest {

	 TodoBusinessImpl todoBusiness;
	 TodoServiceStub todoService;
	 
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	 void setUp() throws Exception {

		todoService = Mockito.mock(TodoServiceStub.class);
		todoBusiness = new TodoBusinessImpl(todoService);
		when(todoService.retrieveTodos("user1")).thenReturn(Arrays.asList("one", "two", "three"));
		when(todoService.retrieveTodos("user2")).thenReturn(Arrays.asList("four", "five", "six"));
		
		when(todoService.deleteTodo("one", "user1")).thenReturn(Arrays.asList("two","three"));
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	 void tearDown() throws Exception {
		todoBusiness = null;
	}

	@DisplayName("should user1 has 3 todo items")
	@Test
	 void testUser1TodoList() {
		List<String> todoList = todoBusiness.retrieveTodosOf("user1");
		Assertions.assertEquals(Arrays.asList("one", "two", "three"), todoList);
	}
	
	@DisplayName("should user2 has 3 todo items")
	@Test
	 void testUser2TodoList() {
		List<String> todoList = todoBusiness.retrieveTodosOf("user2");
		Assertions.assertEquals(Arrays.asList("four", "five", "six"), todoList);
	}
	
	@DisplayName("should user1 has 2 todo after delete one item")
	@Test
	 void testUser1DeletedTodoList() {
		List<String> todoList = todoBusiness.deleteTodosOf("one", "user1");
		Assertions.assertEquals(Arrays.asList("two", "three"), todoList);
	}
}
