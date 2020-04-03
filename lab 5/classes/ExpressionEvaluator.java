package eg.edu.alexu.csd.datastructure.stack;

import java.util.InputMismatchException;
import java.util.regex.Pattern;
/**
 *  Application to convert from Infix Notation to Postfix Notation
 *  and to evaluate the postfix expression  
 * @author Abdelrahman Ibrahem
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
	
	
	
     
	/**
	 * this function converts the negative operands to (0-x).
	 * this function takes string and return the new string with this format 
	 * (0-x) to negative numbers    
	 * @param expression
	 * 
	 * @return true or false
	 */
	private static String DummyZero (String expression) {
		//Making Sure there are spaces around all parenthesis
		expression = expression.replaceAll("\\(", "\\( ");
		expression = expression.replaceAll("\\)", " \\)");

		//Splitting the string around whitespaces into a string array
		String[] a = expression.trim().split("\\s+");
		expression = "";

		//Replacing -x with (0-x) and joining the array into one string again 
		
		for(int i=0;i<a.length;i++) {
			if(a[i].charAt(0) == '-' && a[i].length() > 1) 
				a[i] = "(0-" + a[i].substring(1) + ")";
			expression+= a[i];
		}
		
		return expression;
	}
	
	/**
	 * this function check if the the postfix is valid or not .
	 * takes array of string contain all operands and operators
	 * and return true if it valid or false if it not valid
	 * @param a
	 * string contain all operands and operators
	 * @return true or false 
	 */
	private static boolean ValidPostfix (String [] a) {
		int numsCount = 0,operatorsCount = 0;
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		char l=a[a.length-1].charAt(0);
		//makes sure the expression starts by 2 operands and ends with an operator
		if(!pattern.matcher(a[0]).matches() || !pattern.matcher(a[1]).matches() 
				|| !((l == '+' || l == '-' || l == '*' || l == '/')))
			return false;
		
		//loop to count the number of operators and numbers
		for(int i=0;i<a.length;i++) {
			if(pattern.matcher(a[i]).matches())
				numsCount++;
			else {
				if(a[i].length() > 1)
					return false;
				char c = a[i].charAt(0);
				if(!(c == '+' || c == '-' || c == '*' || c == '/'))
					return false;
				operatorsCount++;
			}
		}
		
		
		if(numsCount - 1 == operatorsCount)
			return true;
		return false;
	}
	
	
	
	
	
	/**
	 * helping function to check if the infix is valid 
	 * takes string (expression) and return true if  valid or false if not valid
	 * @param expression
	 * @return true or false
	 */
	 private static boolean ValidInfix(String expression){
	        //remove unnecessary whitespace
	        expression = expression.replaceAll("\\s+", "");
	        //returns false if expression starts or ends with an operator
	        if (expression.charAt(0)=='+' || expression.charAt(0)=='-' || expression.charAt(0)=='*' || expression.charAt(0)=='/')
	            return false;
	        char c=(expression.charAt(expression.length()-1));
	        if (c=='+' || c=='-' || c=='*' || c=='/')
	            return false;
	        //returns false if test has mismatching number of opening and closing parentheses

	        int unclosedParenthesis = 0;

	        for (int i = 0; i < expression.length(); i++){
	            if (expression.charAt(i) == '('){
	                unclosedParenthesis++; 

	                //returns false if expression ends with '('
	                if (i == expression.length()-1) return false;
	            }
	            
	            if (expression.charAt(i) == ')'){
	                unclosedParenthesis--;

	                //returns false if expression starts with ')'
	                if (i == 0) return false;

	            }
	            char word =expression.charAt(i);
	            if (word=='+' || word=='-' || word=='*' || word=='/'){

	                //returns false if operator is preceded by an operator or opening parenthesis 
	                //or followed by closing parenthesis
	                if (expression.charAt(i-1) == '(' || expression.charAt(i+1) == ')' ){
	                    return false; 
	                }
	                char s=expression.charAt(i+1);
	                if (s=='+' || s=='-' || s=='*' || s=='/')
                          return false;
	            }

	        }
	        //Expression is valid if no parenthesis are left open
	        return (unclosedParenthesis == 0);
	 }
	
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	* @param expression
	* infix expression
	* @return postfix expression
	*/
	public String infixToPostfix(String expression) {
		 
		expression = DummyZero(expression);
		if (!ValidInfix(expression)  || expression.length()<3)
			throw new InputMismatchException("Expression is invalid!!");
		Stack stack = new Stack();
		String postFix = "";
	    boolean flag = false;
	      
	    for(int i=0;i<expression.length();i++){
	            char word = expression.charAt(i);
	            if(word==' '){
	                continue;
	            }
	            if(word=='('){
	                stack.push(word);
	                flag = false;
	            }else if(word==')'){
	                flag = false;
	                while(!stack.isEmpty()){
	                    if((char)stack.peek()=='('){
	                        stack.pop();
	                        break;
	                    }else{
	                    	postFix+= (char)stack.pop() + " ";
	                    }
	                }
	            }else if(word=='+' || word=='-' || word=='*' || word=='/'){
	                flag = false;
	                if(stack.isEmpty()){
	                    stack.push(word);
	                }
	                else{
	                    while(!stack.isEmpty() && getPreference((char)stack.peek())>=getPreference(word)){
	                    	postFix+= (char)stack.pop() + " "; 
	                    }
	                    stack.push(word);
	                }
	            }else{
	                if(flag){
	                	postFix=postFix.trim();
	                	postFix+= word + " " ;  
	                }else
	                     postFix+= word + " ";
	                     flag = true;
	            }
	        }
	        while(!stack.isEmpty()){
	        	postFix+= (char)stack.pop() + " ";  
	        }
	        
	        return postFix.trim();
	}
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	* @param expression
	* postfix expression
	* @return the expression evaluated value
	*/
	public int evaluate(String expression) {
		String[] postFix = expression.trim().split("\\s+");
		if (!ValidPostfix(postFix))
			throw new InputMismatchException("Expression is invalid!!");
		Stack stack =new Stack();
		  for(int i=0;i<postFix.length;i++){
	            String word = postFix[i];
	            if(word.length()==1 && (word.charAt(0)=='+'||word.charAt(0)=='-'||word.charAt(0)=='*'||word.charAt(0)=='/')){
	            	float number2 = (float) stack.pop();
					float number1 = (float) stack.pop();
	                if(word.charAt(0)=='+'){
	                   stack.push(number1+number2);
	                   }
	                else if(word.charAt(0)=='-'){
	                    stack.push(number1-number2);
	                }
	                else if(word.charAt(0)=='*'){
	                   stack.push(number1*number2);
	                }
	                else{
	                	// dividing by zero error
	                	if(number2==0)
							throw new ArithmeticException("Cannot Devide By Zero!!");
	                    stack.push(number1/number2);
	                }
	            }else {
	                stack.push(Float.parseFloat(word));
	            }
	        }
	        return  Math.round((float) stack.pop());
	    }
	
	
	/**
	 * Helping function to determine the precedence between the current and top of the stack operations 
	 * @param c
	 * @return 1 or 2 or -1 
	 */
	   private int getPreference(char c){
                if(c=='+'|| c=='-') return 1;
                else if(c=='*' || c=='/') return 2;
                else return -1;
           }
	}

