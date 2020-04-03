package eg.edu.alexu.csd.datastructure.stack;

/**
 * the implementation of the stack and it's node 
 * @author Abdelrahman ibrahem 
 *
 */


public class Stack implements IStack {  
	  
	private class Node {
		   
		   
		   private Object element;
		   private Node next;
		   
		   /**
		    * constructor to define anew node
		    * @param e the element 
		    * @param n the next nod
		    */
		   public Node (Object e, Node n ) {
			element = e;
			next =n;
		   }
		   
		   public Object getElement() {
			   return element ;
		   }
		   
		   public Node getNext() {
			   return next ;
		 
	       }
		   /**
		    * to set the next node 
		    * @param n
		    */
		   public void setNext(Node n) {
			    next =n ;
		 
	       }
		   /**
		    * to set the element 
		    * @param e
		    */
		   public void setElemrnt(Object e) {
			   element=e ;
		 
	         }
           }
          
	       private Node top;
	       private int size;
	  
	  
	       public Stack() {
	       top = new Node (null,null);
		   size =0;
	       }
	   
	   
	        /**
		    * Removes the element at the top of stack and returns that element.
		    *
		    * @return top of stack element, or through exception if empty
		    */
		    public Object pop() {
		    	if (size == 0) {
		    	
		           throw new NullPointerException();
		    	
		    	}
			
		    	else {   Node n = top.getNext();
				   top.setNext(n.getNext());
				   n.setNext(null);
				   size--;
				   return n.getElement();
				  
		    	}
			   
		    }
			/**
			* Get the element at the top of stack without removing it from stack.
			*
			* @return top of stack element, or through exception if empty
			*/
			public Object peek() {
				   if (size == 0) {
					   throw new IllegalArgumentException("The stack is empty");
				   }
				   else {
					  return  top.getNext().getElement();
				   }
			}
			/**
			* Pushes an item onto the top of this stack.
			*
			* @param  element
			* to insert
			*/
			public void push(Object element) {
				Node n = new Node (element , top.getNext());
				top.setNext(n);
				size++;
			}
			/**
			* Tests if this stack is empty
			*
			* @return true if stack empty
			*/
			public boolean isEmpty() {
				return (size == 0);
			}
			/**
			* Returns the number of elements in the stack.
			*
			* @return number of elements in the stack
			*/
			public int size() {
				return size;
			}
			
			
			public String toString (){
				String s = "[";
				Node v = top.getNext();
				while (v !=null) {
					s += v.getElement();
					v = v.getNext();
					if (v != null) s += ",";
					    }
					s += "]";
					return s ;
					
			} 
		}



 



