package edu.cofc.cs.csci230;

import java.util.EmptyStackException;

/**
 * A LIFO stack that has constant time complexity O(1) for
 * all three stack interface methods (i.e., push, pop, and 
 * peek).
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class ConstantTimeStack<AnyType extends Comparable<? super AnyType>> implements Stack<Node<AnyType>>{
	
	/**
	 * private instance variables
	 */
	private SinglyLinkedList<AnyType> list = new SinglyLinkedList<AnyType>();
	/**
	 * Pushes an item onto the top of this stack in constant 
	 * time O(1)
	 * 
	 * @param t the item to be pushed onto this stack.
	 */
	public void push(Node<AnyType> t) {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation
         * 
         */
		list.add(0, t);
		
		
	} // end push() method

	/**
	 * Removes the object at the top of this stack and return the 
	 * item in constant time O(1)
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public Node<AnyType> pop() throws EmptyStackException {
		if (list.isEmpty()){
			throw new EmptyStackException();
		}
		Node removed_node = list.remove(0);
		
		
		
		
		return removed_node;
		//JMC FIX THIS I PUT RETURN
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your pop solution must be a constant 
         * time O(1) operation
         * 
         */
		
		
		
	} // end pop() method

	/**
	 * Looks at the item at the top of this stack without removing it 
	 * from the stack in constant time O(1)
	 * 
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public Node<AnyType> peek() throws EmptyStackException {
		if (list.isEmpty()){
			throw new EmptyStackException();
		}
		Node get_node = list.get(0);

		return get_node;
		//JMC FIX THIS I PUT RETURN
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your peek solution must be a constant 
         * time O(1) operation
         * 
         */
		
		
		
	} // end peek() method
	
	public String toString(){
		
		String temp = new String();
		temp="------------------\n";
    	
    	for (int i=0; i<list.size();i++){
    		temp = temp +list.get(i).toString();
    	}
    	temp = temp + "------------------\n";
		return temp; 
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
		ConstantTimeStack myStack = new ConstantTimeStack();
		Node<String> one_node = new Node<String>("one");
		Node<String> two_node = new Node<String>("two");
		Node<String> three_node = new Node<String>("three");
		System.out.println("Begin Test Cases");
		System.out.println("Popping from an empty stack:");
		try{
			myStack.pop();
			System.out.println("No Error");
		}
		catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("Peeking from an empty stack:");
		try{
			myStack.peek();
			System.out.println("No Error");
		}
		catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("Filling stack:");
		myStack.push(one_node);
		myStack.push(two_node);
		myStack.push(three_node);
		System.out.println(myStack);
		System.out.println("Peeking stack:");
		System.out.println(myStack.peek());
		System.out.println("Popping stack:");
		myStack.pop();
		System.out.println(myStack);
		System.out.println("Test Cases Finished");
	
		
		
		
		
		
		
	} // end main method

} // end ConstantTimeStack class definition
