# jUnit5_Mockito

#Life cycle annotations
**@BeforeEach** - before each test case.
**@AfterEach**  - after each test case.

**@Test**  - for each test case.

**@TestFactory**  - to create test cases using various inputs for a single methods.
**DynamicTest**  is returned as Stream due to inputs runs one by one dynamically.


# Assertions used
**assertEquals**  -  if failed immediately fail the test.
**assertAll**  - Even though any one of the test assert failed still validate multiple checks in parallel and returns result. 
**assertThrows** - to handle exception/errors test case

 
#Mockito
**@Mock** - Mocking the ability of the class functionality.
**@Spy** - Spy the class/method/field for the test case.
