/**
 * 
 */
package com.in28minutes.junit.business.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author vkalyana
 *
 */
public class DifferentCurrenciesExceptionTest {

	DifferentCurrenciesException exception;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		exception = null;
	}

	@Test
	public void testDefaultExceptionConstructor() {
		exception = new DifferentCurrenciesException();
		Assertions.assertEquals("Different Currencies are not allowed", exception.getMessage());
	}

	@Test
	public void testDefinedException() {
		exception = new DifferentCurrenciesException("Explicit error");
		Assertions.assertEquals("Explicit error", exception.getMessage());
	}
}
