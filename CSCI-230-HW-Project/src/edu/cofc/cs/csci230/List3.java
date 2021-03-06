package edu.cofc.cs.csci230;

/**
 * List interface that "closely" resembles the List interface
 * in the java.util package 
 * 
 * http://docs.oracle.com/javase/7/docs/api/java/util/List.html
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public interface List3 <AnyType> {
	
	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param t
	 */
	public void add( Node t );
	
	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void add( int index, Node t ) throws IndexOutOfBoundsException;
	
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void set( int index, Node t ) throws IndexOutOfBoundsException;
	
	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node remove( int index ) throws IndexOutOfBoundsException;
	
	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node get( int index )  throws IndexOutOfBoundsException;
	
	/**
	 * Returns the number of elements in this list. 
	 * 
	 * @return
	 */
	public int size();
	
	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return
	 */
	public Boolean isEmpty();
	
	/**
	 * Removes all of the elements from this list.
	 * 
	 */
	public void clear();
	
	/**
	 * Swaps the element values at two different index 
	 * positions (i.e. i and j) in the list.
	 * 
	 */
	public void swap( int i, int j ) throws IndexOutOfBoundsException;

} // end List interface definition
