package com.learn.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Standard Tests structure")
class StandardTests {

    @BeforeAll
    static void initAll() {
    	System.out.println("init All");
    }

    @BeforeEach
    void init() {
    	System.out.println("Before Each");
    }

    @DisplayName("Successful test")
    @Test
    void succeedingTest() {
    	System.out.println("success test 1");
    	Assertions.assertTrue(true);
    }

    @DisplayName("Failing test")
    @Test
    void failingTest() {
    	System.out.println("failure test 1");
        Assertions.fail("a failing test");
    }

    @DisplayName("Disabled test")
    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
    	System.out.println("I am invisible..!!");
        // not executed
    }

    @AfterEach
    void tearDown() {
    	System.out.println("After each...");
    }

    @AfterAll
    static void tearDownAll() {
    	System.out.println("Teardown All tests..");
    }

}