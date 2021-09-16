package io.mc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils mathutils = new MathUtils();
		int expected = 2;
		int actual = mathutils.add(1,1);
		assertEquals(expected,actual,"add method failed");
		
	}
	
	@Test
	void testDivide() {
		MathUtils mathutils = new MathUtils();
		assertThrows(NullPointerException.class,()->mathutils.divide(1, 0),"Divide by zero " );
	}
	@Test
	void testcomputeCircleArea() {
		MathUtils mathutils = new MathUtils();
		assertEquals(314.1592653589793, mathutils.computeCircleArea(10),"computeCirleArea method failed!");
	}

}
