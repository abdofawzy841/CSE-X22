package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;



class ExpressionEvaluatorTest {

	
	@Test
	public void test1() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("2 + 3 * 4");
		String result = "2 3 4 * +";
		int value = test.evaluate(result);
        assertEquals(result, expression);
        assertEquals(value, 14);
	}	
	
	@Test
	public void test2() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("a * b + 5");
		String result = "a b * 5 +";
		int value = test.evaluate("2 4 * 5 +");
        assertEquals(result, expression);
        assertEquals(value, 13);

	}	
	
	@Test
	public void test3() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("(1 + 2) * 7");
		String result = "1 2 + 7 *";
		int value = test.evaluate(result);
        assertEquals(result, expression);
        assertEquals(value, 21);
	}	
	
	@Test
	public void test4() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("a * b / c");
		String result = "a b * c /";
		int value = test.evaluate("3 4 * 2 /");
        assertEquals(result, expression);
        assertEquals(value, 6);
	}	
	
	@Test
	public void test5() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("(a / (b - c + d)) * (e - a) * c");
		String result = "a b c - d + / e a - * c *";
        assertEquals(result, expression);
	}	
	
	@Test
	public void test6() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("a / b - c + d * e - a * c");
		String result = "a b / c - d e * + a c * -";
        assertEquals(result, expression);
	}	
	
	@Test
	public void test7() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("(a / (b - c + d)) * (-e - a) * c");
		String result = "a b c - d + / 0 e - a - * c *";
		int value = test.evaluate("27 5 4 - 2 + / 0 3 - 27 - * 2 *");
        assertEquals(result, expression);
        assertEquals(value, -540);
        }	
	
	@Test
	public void test8() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("(a / (b - c + d)) * (e - -a) * c");
		String result = "a b c - d + / e 0 a - - * c *";
        assertEquals(result, expression);
	}
	
	@Test
	public void test9() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("(-a / (b - c + d)) * (e - a) * c");
		String result = "0 a - b c - d + / e a - * c *";
        assertEquals(result, expression);
	}	
	
	@Test
	public void test10() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("(a / (-b - c + d)) * (-e - a) * c");
		String result = "a 0 b - c - d + / 0 e - a - * c *";
		int value = test.evaluate("27 0 1 - 2 - 6 + / 0 3 - 27 - * 2 *");
        assertEquals(result, expression);
        assertEquals(value, -540);
        }	
	
	//in test(11),test(12) and test(13) i used operands has more than one digit  
	
	@Test
	public void test11() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("20 + 30 * 40");
		String result = "20 30 40 * +";
		int value = test.evaluate(result);
        assertEquals(result, expression);
        assertEquals(value, 1220);
	}	
	
	@Test
	public void test12() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("a * b + 5");
		String result = "a b * 5 +";
		int value = test.evaluate("10 4 * 5 +");
        assertEquals(result, expression);
        assertEquals(value, 45);

	}	
	
	@Test
	public void test13() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("(12 + 2) * 7");
		String result = "12 2 + 7 *";
		int value = test.evaluate(result);
        assertEquals(result, expression);
        assertEquals(value, 98);
	}
	
	// her I used negative operands
	@Test
	public void test14() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("20 + -30 * 40");
		String result = "20 0 30 - 40 * +";
		int value = test.evaluate(result);
        assertEquals(result, expression);
        assertEquals(value, -1180);
	}	
	
	// testing the errors and exceptions 
	@Test
	public void test15() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		assertThrows(InputMismatchException.class,()-> test.infixToPostfix("(a / (b - c + d)) *+ (e - a) * c"));
		assertThrows(InputMismatchException.class,()-> test.evaluate("5  6 - 9 - 5 + / 0 3 - 2 - * 1 *"));		
		assertThrows(InputMismatchException.class,()-> test.infixToPostfix("a * (b) + 5)"));
		assertThrows(InputMismatchException.class,()-> test.evaluate("1 3 * 8 6 /"));
		assertThrows(InputMismatchException.class,()-> test.infixToPostfix("a * b + 5 -"));
		assertThrows(InputMismatchException.class,()-> test.evaluate("1 2 + 8 7 *"));		
		assertThrows(InputMismatchException.class,()-> test.infixToPostfix("* b + 5"));
		assertThrows(InputMismatchException.class,()-> test.evaluate("1 2 + 8 7 *"));		
		assertThrows(InputMismatchException.class,()-> test.infixToPostfix("a * (b + 5"));
		assertThrows(InputMismatchException.class,()-> test.evaluate("a b * c /"));		
		//dividing by zero Exception
		assertThrows( ArithmeticException.class,()-> test.evaluate("5 0 / 5 *"));	
	}

	
}