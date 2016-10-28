package edu.cofc.cs.csci230;

import java.util.NoSuchElementException;

/**
 * A semi-constant time FIFO queue. The time complexity for 
 * the interface methods are:
 * ----------------------------------
 * 1) add: O(1) - not considering capacity resize operations
 * 2) remove: O(n) - not considering capacity resize operations
 * 3) peek: O(1)
 * 
 * Please note: the above time complexities do not factor in
 * capacity resize (grow and shrink) operations. Even though
 * capacity resize operations will occur, for this assignment 
 * you may assume the are negligible.
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class SemiConstantTimeQueue<AnyType extends Comparable<? super AnyType>> implements Queue<AnyType> {
	
	/**
	 * private instance variables
	 */
	private ArrayList<AnyType> list = new ArrayList<AnyType>();


	/**
	 * Inserts the specified element at the end of the queue in 
	 * constant time O(1)
	 * 
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null 
	 *                               (queue does not permit null elements)
	 */
	public void add(AnyType t) throws NullPointerException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation (not considering capacity 
         * resize operations)
         * 
         */
		
		if (t == null){
			throw new NullPointerException();
		}
		list.add(t);
		
		
	} // end add() method

	/**
	 * Retrieves and removes the head of the queue in
	 * linear time O(n).
	 * 
	 * Hint: shift operations will make this a linear time
	 * operation.
	 * 
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException {
		if(list.isEmpty()){
			throw new NoSuchElementException();
		}
		
		AnyType removed = list.remove(0);
		return removed;
		//JMC FIX THIS
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a linear 
         * time O(n) operation. See hint above.
         * 
         *
         */
		
		
		
	} // end remove() method

	/**
	 * Retrieves, but does not remove, the head of the queue, 
	 * or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public AnyType peek() {
		if(list.isEmpty()){
			return null;
		}
		AnyType get = list.get(0);
		
		return get;
		//JMC FIX THIS
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation 
         * 
         */
		
		
		
	} // end peek() method
	
	public String toString(){

		String temp = new String();

		for (int i=0; i<list.size();i++){
			temp = temp +" "+ "["+list.get(i).toString()+"]";
		}

		return temp; 
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
		SemiConstantTimeQueue myQueue = new SemiConstantTimeQueue();
//		String string_one = "one";
//		String string_two = "two";
//		myQueue.add(string_one);
//		myQueue.add(string_two);
//		Comparable x = myQueue.peek();
//		System.out.println(x);
//		System.out.println(myQueue);
//		myQueue.remove();
//		System.out.println(myQueue);
//		System.out.println(myQueue.remove());
//		System.out.println(myQueue+"h");
////		System.out.println(myQueue.peek());
//		System.out.println(myQueue.peek());
		System.out.println("Begin Test Cases");
		String string_one = "one";
		String string_two = "two";
		String string_three = "three";
		String string_four = "four";
		String my_null = null;
		System.out.println("Adding a null:");
		try{
			myQueue.add(my_null);
			System.out.println("No Error");
		}
		catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("Removing in an empty queue:");
		try{
			myQueue.remove();
			System.out.println("No Error");
		}
		catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("Peekin an empty queue:");
		System.out.println(myQueue.peek());
		System.out.println("Adding strings:");
		myQueue.add(string_one);
		myQueue.add(string_two);
		myQueue.add(string_three);
		System.out.println(myQueue);
		System.out.println("Using removes gives:");
		myQueue.remove();
		System.out.println(myQueue);
		System.out.println("Adding another string:");
		myQueue.add(string_four);
		System.out.println(myQueue);
		System.out.println("Peeking the queue:");
		System.out.println(myQueue.peek());
		System.out.println("Test Cases Finished");
	
		
		
		

	} // end main() method

} // end ConstantTimeQueue class definition
