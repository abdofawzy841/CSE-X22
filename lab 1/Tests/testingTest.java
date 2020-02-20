import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testingTest {
	cal_test test = new cal_test();
	@Test
	void testadd() {
		
	int test1=test.add(50, 50);
	assertEquals(100,test1);
	}

	
	@Test
	void testDivide() {
		
		assertThrows(ArithmeticException.class, () ->test.divide(1, 0),("divide by zero is invalid"));
				
	}


	@Test
	void testdivide2() {
		
	float test3=test.divide(50, 50);
	assertEquals(1,test3);
	}
}
