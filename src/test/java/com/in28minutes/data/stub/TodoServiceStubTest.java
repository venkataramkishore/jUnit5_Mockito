/**
 * 
 */
package com.in28minutes.data.stub;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author vkalyana
 *
 */
@DisplayName("TodoService Stub class")
 class TodoServiceStubTest {

	 TodoServiceStub stub;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	 void setUp() throws Exception {
		stub = new TodoServiceStub();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	 void tearDown() throws Exception {
		stub = null;
	}

	@DisplayName("should user1 has 3 todo items")
	@Test
	 void testUser1Todos() {
		List<String> list = stub.retrieveTodos("user1");
		Assertions.assertEquals(3, list.size());
		Assertions.assertEquals(Arrays.asList("one", "two", "three"), list);
	}
	
	@DisplayName("should user2 has 3 todo items")
	@Test
	 void testUser2Todos() {
		List<String> list = stub.retrieveTodos("user2");
		Assertions.assertEquals(3, list.size());
		Assertions.assertEquals(Arrays.asList("four", "five", "six"), list);
	}
	
	@DisplayName("should user1 has 2 items after deleted 1 item")
	@Test
	 void testDeleteUser1Todos() {
		List<String> list = stub.deleteTodo("two", "user1");
		Assertions.assertEquals(2, list.size());
		Assertions.assertEquals(Arrays.asList("one", "three"), list);
	}
	
	@DisplayName("should user2 has 2 items after deleted 1 item")
	@Test
	 void testDeleteUser2Todos() {
		List<String> list = stub.deleteTodo("four", "user2");
		Assertions.assertEquals(2, list.size());
		Assertions.assertEquals(Arrays.asList("five", "six"), list);
	}
}
