package io.mc;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("Running MahUtils")
class MathUtilsTest {
	MathUtils mathutils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Before all implementation ");
	}
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathutils = new MathUtils();
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags"+testInfo);

    }
	@AfterEach
	void cleanup() {
		System.out.println("cleaning up...");
	}
	@Nested
	@DisplayName("Add method")
	@Tag("Math")
	class  AddTest{
		
		@Test
		@DisplayName("add method for positive")
		
		void testAddPositive() {
			int expected = 2;
			/* int actual = mathutils.add(1,1);
			   assertEquals(expected,actual,"add method failed"); */
			//assertEquals(expected,mathutils.add(1,1),"add method failed");
			assertEquals(2,mathutils.add(1,1),"should return positive result");
			
		}
		@Test
		@DisplayName("add method for Negative")
		void testAddNegative() {
			assertEquals(-2,mathutils.add(-1,-1),"should return negative result");
			
		}
	}
	
	
	@Test
	@Tag("Math")
	@DisplayName("Multiply method")
	void testMultiply() {
		assertAll(
				() -> assertEquals(16,mathutils.multiply(4, 4)),
				() -> assertEquals(-2,mathutils.multiply(2, -1)),
				() -> assertEquals(0,mathutils.multiply(0, 4))
				);
	}
	
	@Test
	@EnabledOnOs(OS.MAC)
	@Tag("Math")
	@DisplayName("Divide method")
	void testDivide() {
	 /*   boolean isServerUp = false;
		  assumeTrue(isServerUp);    */
		assertThrows(ArithmeticException.class,()->mathutils.divide(1, 0),"Divide by zero " );
	}
	
	
	@Test
	@Tag("Circle")
	void testcomputeCircleArea() {
		assertEquals(314.1592653589793, mathutils.computeCircleArea(10),"computeCirleArea method failed!");
	}
	
	@RepeatedTest(3)
	@DisplayName("subtract method")
	void testSubtract() {
		assertEquals(5, mathutils.subtract(15,10),"Subtracted result to be returned");

	}
	
	@Test
	@Disabled
	@DisplayName("TDD method should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
	
	
	
	

}
