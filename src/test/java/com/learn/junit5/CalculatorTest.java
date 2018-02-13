/**
 * 
 */
package com.learn.junit5;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learn.junit5.Calculator;

/**
 * @author vkalyana
 *
 */
@DisplayName("Calculator class")
class CalculatorTest {

	 Calculator calculator;
	
	@BeforeEach
	void setUpEach() {
		calculator = new Calculator();
	}
	
	@DisplayName("Should return 5 for whole numbers 2+3")
	@Test
	 void testPositiveNum() {
		int result = calculator.add(2, 3);
		Assertions.assertEquals(5, result);
	}
	
	@DisplayName("Should return -5 for whole numbers -2-3")
	@Test
	 void testNegetiveNum() {
		int result = calculator.add(-2, -3);
		Assertions.assertEquals(-5, result);
	}
	
	@DisplayName("Should return -5 for -ve and +ve numbers -10+5")
	@Test
	 void testNumbers() {
		int result = calculator.add(-10, 5);
		Assertions.assertEquals(-5, result);
	}
	
	@DisplayName("Should return -1 for 2+3")
	@Test
	 void testSubstractPositive() {
		int result = calculator.substract(2, 3);
		Assertions.assertEquals(-1, result);
	}
	
	@DisplayName("Should return 1 for -2-3")
	@Test
	 void testSubstractNegetiveNum() {
		int result = calculator.substract(-2, -3);
		Assertions.assertEquals(1, result);
	}
	
	@AfterEach
	void tearDownEach() {
		calculator = null;
	}
}
