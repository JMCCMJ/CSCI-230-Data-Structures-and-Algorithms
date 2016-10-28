package edu.cofc.cs.csci230;

import java.util.Scanner;





/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable<? super AnyType>> implements List<Node<AnyType>>  {
	
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
		if (i < 0 || i > size()){
			throw new IndexOutOfBoundsException();
		}
		if ( j < 0 || j > size()){
			throw new IndexOutOfBoundsException();
		}
		
		Node iNode = get(i);
		Node jNode = get(j);
		AnyType tempData = (AnyType) jNode.getData();
		jNode.setData(iNode.getData());
		iNode.setData(tempData);
		
//		boolean iHead = false;
//		
//		boolean jHead = false;
//		
//		Node iNode = get(i);
//		Node iAfterNode = null;
//		Node iBeforeNode = null;
//		if(i == size()-1){
//			iAfterNode = null;	
//			iBeforeNode = get(i-1);
////			System.out.println("BEFORENODE: "+iBeforeNode.toString());
//		}
//		else if(i == 0){
//			iHead = true;
//			iAfterNode = get(i).getNextNode();
//		}
//		else{
//			iAfterNode = get(i).getNextNode();
//			iBeforeNode = get(i-1);	
//		}
//		
//		
//		Node jNode = get(j);
//		Node jAfterNode = null;
//		Node jBeforeNode = null;
//		if (j == size()-1){
//			jAfterNode = null;
//			jBeforeNode = get(j-1);
//		}
//		else if(j == 0){
//			jHead = true;
//			jAfterNode = get(j).getNextNode();
//		}
//		else{
//			jAfterNode = get(j).getNextNode();
//			jBeforeNode = get(j-1);
//		}
//		
//		
//		
//		if(iHead == true){
//			jNode.setNextNode(iNode.getNextNode());
//			iNode.setNextNode(jAfterNode);
//			jBeforeNode.setNextNode(iNode);
//		}
//		else if(jHead == true){
//			iNode.setNextNode(jNode.getNextNode());
//			jNode.setNextNode(iAfterNode);
//			iBeforeNode.setNextNode(jNode);
//		}
//		else{
//			Node temp = iAfterNode;
//			Node temp2 = iNode;
//			jNode.setNextNode(iAfterNode);
//			
//			iBeforeNode.setNextNode(jNode);
//			
//			iNode.setNextNode(temp);
//			jBeforeNode.setNextNode(temp2);
//		}
		
		
		
		
		
		
		//DEAL WITH GETTING A NODE THAT IS NULL
		
		
		
		
		
		
		
		
	} // end swap() method
	
	public String toString(){
		String temp = new String();
		for(int i=0;i<size();i++){
			temp = temp + get(i).toString();
			
			
		}
		return temp;
		
	}
	
	
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
		
		int temp = 0;
		temp = temp = 10;
		assert temp == 9;
//		Integer x = 0;
//		Integer y = 1;
//		Integer z = 2;
//		Integer a = 3;
//		Node zero = new Node(x);
//		Node one = new Node(y);
//		Node two = new Node(z);
//		Node three = new Node(a);
//		
//		
//		
//		SinglyLinkedList mySLL = new SinglyLinkedList();
//		mySLL.add(zero);
//		mySLL.add(one);
//		mySLL.add(two);
//		mySLL.add(three);
//		System.out.println(mySLL.toString());
//		System.out.println();
//		
//		mySLL.swap(1, 3);
//		System.out.println(mySLL.get(0).toString());
//		System.out.println(mySLL.get(1).toString());
//		System.out.println(mySLL.get(2).toString());
		
//		System.out.println(mySLL.toString());
//		System.out.println(mySLL.size());
		
//		Integer x = 0;
//		Integer y = 1;
//		Integer z = 2;
//		Integer a = 3;
//		Integer b = 4;
//		Node zero = new Node(x);
//		Node one = new Node(y);
//		Node two = new Node(z);
//		Node three = new Node(a);
//		Node four = new Node(b);
//		
//		
//		
//		SinglyLinkedList mySLL = new SinglyLinkedList();
//		mySLL.add(zero);
//		mySLL.add(one);
//		mySLL.add(two);
//		mySLL.add(four);
//		mySLL.add(three);
//		System.out.println(mySLL.toString());
//		System.out.println();
////		Utils.bubbleSort(mySLL);
////		Utils.selectionSort(mySLL);
//		Utils.insertionSort(mySLL);
//		
//		
//		System.out.println(mySLL.toString());
		
//		int[] temp = {1,2,3,4};
//		System.out.println(temp.length);
//		ArrayList temp1 = new ArrayList();
//		temp1.add(0);
//		temp1.add(1);
//		temp1.add(2);
//		temp1.add(3);
//		System.out.println(temp1.size());
//		
		
		
		
	} // end main() method
 
} // end SinglyLinkedList class definition
