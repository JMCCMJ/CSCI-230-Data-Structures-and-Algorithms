package edu.cofc.cs.csci230;


/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable<? super AnyType>> implements List2<Node<AnyType>> {
	
	// instance variables
	private Node<AnyType> headNode = null;
	private int size = 0;

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param t
	 */
	public void add(Node<AnyType> t) {
		
		if ( isEmpty() ) headNode = t;
		else get( size-1 ).setNextNode( t );
		
		size++;
		
	} // end add() method

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
	
		if ( index < 0 || index > size ) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		if ( index == 0 ) {
			
			t.setNextNode( headNode );
			headNode = t;
			size++;
			
		} else if ( index == size ) {
			
			add( t );
			
		} else {
			
			t.setNextNode( get( index ) );
			get( index - 1 ).setNextNode( t );
			size++;
			
		}
		
	} // end add() method

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
		
		if ( index < 0 || index >= size ) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		get( index ).setData( t.getData() );
		
	} // end set() method

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node<AnyType> remove( int index ) throws IndexOutOfBoundsException {
		
		if ( index < 0 || index >= size ) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		Node<AnyType> node = get( index );
		
		if ( index == 0 ) {
			
			headNode = node.getNextNode();
			
		} else if ( index == ( size-1 ) ) {
			
			get( index - 1).setNextNode( null );
			
		} else {
			
			get( index - 1 ).setNextNode( node.getNextNode() );
			
		}
		
		size--;
		
		return node;
		
	} // end remove() method

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node<AnyType> get(int index) throws IndexOutOfBoundsException {
		
		if ( index < 0 || index >= size ) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
		Node<AnyType> node = headNode;
		
		if ( index == 0 ) return node;
		
		for ( int i=1; i<index+1; i++ ) {
			
			node = node.getNextNode();
			
		}
		
		return node;
		
	} // end get() method

	/**
	 * Returns the number of elements in this list. 
	 * 
	 * @return
	 */
	public int size() {
		
		return size;
		
	} // end size() method

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return
	 */
	public Boolean isEmpty() {
		
		return ( size == 0 ) ? true : false;
		
	} // end isEmpty() method
	
	
	/**
	 * Removes all of the elements from this list.
	 * 
	 */
	public void clear() {
		
		headNode = null;
		size=0;
		
	} // end clear method
	
	/**
	 * swaps to elements in a list at index 
	 * position i and j.
	 * 
	 * For example, 
	 * 	if A = 1->2->3->4->5 and swap( 1, 3 ) is executed
	 * 	then A = 1->4->3->2->5
	 *
	 * @param i
	 * @param j
	 * @throws IndexOutOfBoundsException
	 */
	public void swap( int i, int j )  throws IndexOutOfBoundsException {
		
		/**
		 * -------------------------------------------
		 * TODO: You fully implement this method
		 * 
		 */
		
		
		
	} // end swap() method
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
		 * -------------------------------------------
		 * TODO: Put your test cases here
		 * 
		 */		
		
	} // end main() method
 
} // end SinglyLinkedList class definition
