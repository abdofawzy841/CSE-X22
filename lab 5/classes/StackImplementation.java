package eg.edu.alexu.csd.datastructure.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * 
 * @author Abdelrahman Ibrahem
 *
 */
public class StackImplementation {
	static int check = 0;
	static Stack myStack = new Stack();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	
	static void asking_the_user() {
		 System.out.println("Do you want continue?");
	     System.out.println("1: Yes.");
	     System.out.println("2: No.");
	    
		try {
	    String f = br.readLine();
	    int k = Integer.parseInt(f);
	    switch	(k) {
	    case 1:
	    	main_menu();
	    	break;
	    case 2:
	    	System.exit(0);
	    	break;
	    default:
	    	 System.out.println("please choose number 1 or 2");
	    	 asking_the_user();
	    	 
	        }
	   }
		catch (Exception e) {
			System.out.println("Please Enter A Number Between 1-2: ");
			asking_the_user();
		}
	}
	
	
	static void main_menu() {
		
		
		System.out.println("1: Push\r\n"
		+"========================== \n"
	    + "2: Pop\r\n"
	    +"========================== \n"
		+ "3: Peek\r\n"
		+"========================== \n"
		+ "4: Get size\r\n"
		+"========================== \n"
		+ "5: Check if empty\n"
		+"========================== \n");
		try {
		String r = br.readLine();
		int i = Integer.parseInt(r);
	    switch (i) { 
	    case 1 :
	    	 System.out.println(
	    			 "Enter element to pop it in stack :");
	    	 Scanner sc1 = new Scanner(System.in);
		     Object i1 = sc1.nextInt();
	    	 myStack.push(i1);
	    	 System.out.println("stack is :" + myStack.toString());
	    	 asking_the_user();
	    	 break;
	    case 2:
	    
	    	 if(myStack.isEmpty()) {
	    		 System.out.println(" the stack is empty you must push in it first");
	    		 System.out.println(" please choose again \n");
	    		 
	    		 main_menu();
	    		 
	    	 }
	    	 else {System.out.println(""
	    	 		+ "The pop element is : "
	    			 +  myStack.pop());
	    	 System.out.println("The stack become:");
	    	 System.out.println(myStack.toString());
	    	 asking_the_user();
	    	 break;
	    	 }
	    case 3:
	    	 if(myStack.isEmpty()) {
	    		 System.out.println(" the stack is empty you must push in it first\n");
	    		 System.out.println("please choose again \n");
	    		 main_menu();
	    	 }
	    	 else { System.out.println("The peek element is : "
	     +  myStack.peek());
	    	 System.out.println(myStack.toString());
	    	 asking_the_user();
	    	 break;}
	    case 4:
	    	 System.out.println("The size of stack is : "
	     +  myStack.size());
	    	 asking_the_user();
	    	 break;
	    case 5:
	    	 if (myStack.isEmpty()) {
	    		 System.out.println("the stack is empty");
	    		 asking_the_user();
	    		 break;
	    	 } else {
	    		 System.out.println("the stack is not empty");
	    		 asking_the_user();
	    		 break;
	    	 }
	    	 default: 
	    	 System.out.println("please choose number from 1 to 5");
	    	 main_menu();
	        }
		}
		catch (Exception e) {
			System.out.println("Please Enter A Number Between 1-5: ");
			main_menu();
		}
	}
	/**
	 * the main method of this application 
	 * @param args array of string argument
	 */
	public static void main(String[] args) {
		
		main_menu();
	}

}
