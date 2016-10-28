package edu.cofc.cs.csci230;


/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable<? super AnyType>> implements List<Node<AnyType>> {

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

		/**
		 * -------------------------------------------
		 * TODO: You fully implement this method
		 * 
		 */
		Node<AnyType> current_node = null;
		Node<AnyType> previous_node = null;
		Node<AnyType> new_node = t;
		//		System.out.println(t);
		if ( index < 0 ){
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0){

			current_node = get(0);
			headNode = t;
			headNode.setNextNode(new_node);
			new_node.setNextNode(current_node);
		}
		else if (index > size()){
			throw new IndexOutOfBoundsException();
		}

		else {
			current_node = get(index);
			previous_node = get(index-1);
			previous_node.setNextNode(new_node);
			new_node.setNextNode(current_node);
		}



		size++;
		
	} // end add() method

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, Node<AnyType> t) throws IndexOutOfBoundsException {

		/**
		 * -------------------------------------------
		 * TODO: You fully implement this method
		 * 
		 */

		Node<AnyType> after_node = null;
		Node<AnyType> previous_node = null;
		Node<AnyType> new_node = t;
		//		System.out.println(t);
		if ( index < 0 ){
			throw new IndexOutOfBoundsException();
		}

		else if (index > size()){
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0){
			throw new IndexOutOfBoundsException();
		}

		else {
			after_node = get(index+1);
			previous_node = get(index-1);
			previous_node.setNextNode(new_node);
			new_node.setNextNode(after_node);
		}


	} // end set() method

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node<AnyType> remove( int index ) throws IndexOutOfBoundsException {
		Node<AnyType> removeNode = get(index);

		Node<AnyType> after_node = null;
		Node<AnyType> previous_node = null;


		if ( isEmpty() == true ){
			throw new IndexOutOfBoundsException();
		}
		else if ( index < 0 ){
			throw new IndexOutOfBoundsException();
		}
		else if (index > size()){
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0){
			headNode=headNode.getNextNode();
			size--;			
			return removeNode;
		}
		else{
			after_node = get(index+1);
			previous_node = get(index-1);
			previous_node.setNextNode(after_node);
			
		}

		size--;
		return removeNode;




		/**
		 * -------------------------------------------
		 * TODO: You fully implement this method
		 * 
		 */



	} // end remove() method

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Node<AnyType> get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
//		if (isEmpty()){
//			throw new IndexOutOfBoundsException();
//		}

		Node<AnyType> get_node = headNode;
		for( int i=0; i<index; i++ )
		{
			get_node=get_node.getNextNode();
		}
		
		

		return get_node;
		/**
		 * -------------------------------------------
		 * TODO: You fully implement this method
		 * 
		 */



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

		/**
		 * -------------------------------------------
		 * TODO: You fully implement this method
		 * 
		 */

		headNode = null;
		size = 0;


	} // end clear method


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

		//NODE CREATION
		Integer twelve = new Integer(12);
		Integer thirteen = new Integer(13);
		Integer fourteen = new Integer(14);
		Integer fifteen = new Integer(15);
		Node<Integer> twelve_node = new Node<Integer>(twelve);
		Node<Integer> thirteen_node = new Node<Integer>(thirteen);
		Node<Integer> fourteen_node = new Node<Integer>(fourteen);
		Node<Integer> fifteen_node = new Node<Integer>(fifteen);
		
		//NODE LINKED LIST
		SinglyLinkedList<Integer> myNodeList = new SinglyLinkedList<Integer>();

		//Test Cases for add with int index
		myNodeList.add(0,twelve_node);
		myNodeList.add(thirteen_node);
		myNodeList.add(fourteen_node);
		myNodeList.add(1,fifteen_node);


		System.out.println("Inputting nodes using add with an index test case:");
		for(int i=0;i<myNodeList.size();i++){

			System.out.println(myNodeList.get(i).toString());
		}

		//Inputting a negative number
		System.out.println("\n"+"Inputting a negative number for add: -1");
		try{
			myNodeList.add(-1,fifteen_node);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");

		}

		//Inputting an index greater than the list
		System.out.println("\n"+"Inputting an index number greater than the list for add: 100");
		try{
			myNodeList.add(100,fifteen_node);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");
		}


		//SET with int index test cases

		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		Integer five = new Integer(5);
		Node<Integer> one_node = new Node<Integer>(one);
		Node<Integer> two_node = new Node<Integer>(two);
		Node<Integer> three_node = new Node<Integer>(three);
		Node<Integer> four_node = new Node<Integer>(four);
		Node<Integer> five_node = new Node<Integer>(five);

		//NODE LINKED LIST
		SinglyLinkedList<Integer> myNodeList2 = new SinglyLinkedList<Integer>();


		System.out.println("\n"+"Inputting index as 0  for set:");
		try{
			myNodeList2.set(0,five_node);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");
		}

		myNodeList2.add(one_node);
		myNodeList2.add(two_node);
		myNodeList2.add(three_node);
		myNodeList2.add(four_node);
		myNodeList2.set(1, five_node);

		System.out.println("\n"+"Inputting nodes then using set method:");
		for(int i=0;i<myNodeList2.size();i++){

			System.out.println(myNodeList2.get(i).toString());
		}

		System.out.println("\n"+"Inputting a negative number for set: -1");
		try{
			myNodeList2.set(-1,five_node);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");
		}

		System.out.println("\n"+"Inputting a number greater than size() for set: 100");
		try{
			myNodeList2.set(100,five_node);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");
		}

		
		//Remove test cases
		//NODE LINKED LIST
		
		Integer twenty = new Integer(20);
		Integer twenty1 = new Integer(21);
		Integer twenty2 = new Integer(22);
		Integer twenty3 = new Integer(23);
		Integer twenty4 = new Integer(24);
		Node<Integer> twenty_node = new Node<Integer>(twenty);
		Node<Integer> twenty1_node = new Node<Integer>(twenty1);
		Node<Integer> twenty2_node = new Node<Integer>(twenty2);
		Node<Integer> twenty3_node = new Node<Integer>(twenty3);
		Node<Integer> twenty4_node = new Node<Integer>(twenty4);
		SinglyLinkedList<Integer> myNodeList3 = new SinglyLinkedList<Integer>();
		
		//GET Test Case so I won't have to retype code
		System.out.println("\n"+"Inputting a number for get (myNodeList3) when it is empty: 1");
		try{
			myNodeList3.get(1);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");
		}
		//End Get Test Case
		
		
		System.out.println("\n"+"Inputting index on an empty list for remove: 5");
		try{
			myNodeList3.remove(5);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");
		}
		
		myNodeList3.add(twenty_node);
		myNodeList3.add(twenty1_node);
		myNodeList3.add(twenty2_node);
		myNodeList3.add(twenty3_node);
		myNodeList3.add(twenty4_node);
		myNodeList3.remove(0);
		myNodeList3.remove(1);
		
		System.out.println("\n"+"Inputting nodes then using remove:");
		for(int i=0;i<myNodeList3.size();i++){

			System.out.println(myNodeList3.get(i).toString());
		}
		
		System.out.println("\n"+"Inputting a negative number for remove: -1");
		try{
			myNodeList3.remove(-1);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");
		}
		
		//GET test cases
		System.out.println("\n"+"Inputting a number greater than size() (myNodeList3): 100");
		try{
			myNodeList3.get(100);
			System.out.println("No Error");
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("Error, Index out of Bounds");
		}
		
		//CLEAR test cases
		
		System.out.println("\n"+"Testing clear method results in nothing printing for myNodeLists:");
		myNodeList.clear();
		for(int i=0;i<myNodeList.size();i++){

			System.out.println(myNodeList.get(i).toString());
		}
		myNodeList2.clear();
		for(int i=0;i<myNodeList.size();i++){

			System.out.println(myNodeList2.get(i).toString());
		}
		myNodeList3.clear();
		for(int i=0;i<myNodeList.size();i++){

			System.out.println(myNodeList3.get(i).toString());
		}
		System.out.println("\n"+"Tests concluded and program is finished.");
	} // end main() method
} // end SinglyLinkedList class definition
