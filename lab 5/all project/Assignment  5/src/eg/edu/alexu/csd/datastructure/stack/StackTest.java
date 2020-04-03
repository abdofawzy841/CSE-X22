package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
   //test push function
	@Test
	public void test() {
		Stack list =new Stack();
		int i = 5;
		list.push(1);
		list.push(i);
		list.push(6);
		assertEquals(list.toString(),"[6,5,1]");
		
	}

	//Testing pop function
	@Test
	public void test2() {
        Stack list =new Stack();
		list.push(0);
		list.push(1);
		list.push(2);
		list.push(3);
		assertEquals(3, list.pop());
		assertEquals(2,list.pop());
		assertEquals(1,list.pop());
		assertEquals(list.toString(),"[0]");
		assertEquals(0,list.pop());
		assertThrows(NullPointerException.class, () -> list.pop());

	}
	
	   
	// Testing peek function
	@Test
	public void test3() {
		 Stack list =new Stack();
			list.push(0);
			list.push(1);
			list.push(2);
			list.push(3);
			assertEquals(3, list.peek());
			assertEquals(3,list.peek());
			assertEquals(3,list.peek());
			assertEquals(list.toString(),"[3,2,1,0]");
		

	}
	// Testing isEmpty function
	
	@Test
	public void test4() {
		 Stack list =new Stack();
			list.push(0);
			list.push(1);
			list.push(2);
			list.push(3);
			
			assertEquals(false,list.isEmpty());
			assertEquals(list.toString(),"[3,2,1,0]");
	}
	// Testing size function
	
		@Test
	public void test5() {
			 Stack list =new Stack();
				list.push(0);
				list.push(1);
				list.push(2);
				list.push(3);
				
				assertEquals(4,list.size());
				assertEquals(list.toString(),"[3,2,1,0]");
		}
}