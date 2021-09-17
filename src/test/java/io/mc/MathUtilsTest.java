package io.mc;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class MathUtilsTest {
	MathUtils mathutils;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Before all implementation ");
	}
	
	@BeforeEach
	void init() {
		mathutils = new MathUtils();
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("cleaning up...");
	}
	

	@Test
	@DisplayName("Testing add method")
	void testAdd() {
		int expected = 2;
		//int actual = mathutils.add(1,1);
		//assertEquals(expected,actual,"add method failed");
		assertEquals(expected,mathutils.add(1,1),"add method failed");
		assertEquals(-1,mathutils.add(-2,1),"should return negative result");
	}
	
	@Test
	@DisplayName("Testing multiply method")
	void testMultiply() {
		assertAll(
				() -> assertEquals(16,mathutils.multiply(4, 4)),
				() -> assertEquals(-2,mathutils.multiply(2, -1)),
				() -> assertEquals(0,mathutils.multiply(0, 4))
				);
	}
	
	@Test
	@EnabledOnOs(OS.MAC)
	void testDivide() {
	 /*   boolean isServerUp = false;
		  assumeTrue(isServerUp);    */
		assertThrows(ArithmeticException.class,()->mathutils.divide(1, 0),"Divide by zero " );
	}
	@Test
	void testcomputeCircleArea() {
		assertEquals(314.1592653589793, mathutils.computeCircleArea(10),"computeCirleArea method failed!");
	}
	
	@Test
	@Disabled
	@DisplayName("TDD method should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
	
	
	
	

}
