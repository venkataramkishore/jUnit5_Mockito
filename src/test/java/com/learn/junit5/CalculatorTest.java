/**
 * 
 */
package com.learn.junit5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

/**
 * @author vkalyana
 *
 */
@DisplayName("Calculator class")
class CalculatorTest {

	class CalcInputs {
		int param1;
		int param2;
		int expected;

		public CalcInputs(int param1, int param2, int expected) {
			this.param1 = param1;
			this.param2 = param2;
			this.expected = expected;
		}
	}

	Calculator calculator;

	@TestFactory
	Stream<DynamicTest> seriesOfAdditionInputs() {
		List<CalcInputs> testCases = new ArrayList<>();
		testCases.add(new CalcInputs(5, 5, 10));
		testCases.add(new CalcInputs(-5, 5, 0));
		testCases.add(new CalcInputs(-5, -5, -10));
		testCases.add(new CalcInputs(-5, 2, -3));
		testCases.add(new CalcInputs(0, 3, 3));
		testCases.add(new CalcInputs(5, 5, 10));

		return testCases.stream().map(this::testAddition);
	}

	@TestFactory
	Stream<DynamicTest> seriesOfSubractionsInputs() {
		List<CalcInputs> testCases = new ArrayList<>();
		testCases.add(new CalcInputs(5, 5, 0));
		testCases.add(new CalcInputs(-5, 5, -10));
		testCases.add(new CalcInputs(5, -5, 10));
		testCases.add(new CalcInputs(-5, -2, -3));

		return testCases.stream().map(this::testSubraction);
	}

	@BeforeEach
	void setUpEach() {
		calculator = new Calculator();
	}

	private DynamicTest testSubraction(CalcInputs testCase) {
		String testName = "Subraction Test params:" + testCase.param1 + "" + testCase.param2 + " and expected value:"
				+ testCase.expected;
		return DynamicTest.dynamicTest(testName,
				() -> Assertions.assertEquals(testCase.expected, calculator.substract(testCase.param1, testCase.param2)));
	}
	
	private DynamicTest testAddition(CalcInputs testCase) {
		String testName = "Addition Test params:" + testCase.param1 + "" + testCase.param2 + " and expected value:"
				+ testCase.expected;
		return DynamicTest.dynamicTest(testName,
				() -> Assertions.assertEquals(testCase.expected, calculator.add(testCase.param1, testCase.param2)));
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
