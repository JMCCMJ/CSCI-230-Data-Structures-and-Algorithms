package edu.cofc.cs.csci230;

/**
 * 
 * Binary search that does not allow two (or more) binary nodes 
 * in the search tree to have the same element value.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class BinarySearchTree <AnyType extends Comparable<? super AnyType>> {
	
	// --------------------------------------
	// instance variable
	private BinaryNode<AnyType> root;
	
	/**
	 * Constructor with one parameter that
	 * sets the root node of the BST.
	 * 
	 * @param root
	 */
	public BinarySearchTree( AnyType rootElement ) throws NullBinaryNodeException {
		
		if ( rootElement == null ) {
			throw new NullBinaryNodeException();
		}
		
		this.root = new BinaryNode<AnyType>( rootElement ) ;
		
	} // end constructor
	
	/**
	 * If the BST does not have a root node, then the BST is empty. 
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		
		return ( root == null );
		
	} // end isEmpty() method
	
	/**
	 * Make the BST empty, i.e. a BST that has 
	 * no nodes (including a root node).
	 * 
	 */
	public void makeEmpty() {
		
		root = null;
		
	} // end makeEmpty() method
	
	/**
	 * Method that adds a new node with the specified element 
	 * value in the BST.
	 * 
	 * This method has one parameter:
	 *  1) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param element
	 */
	public void add( AnyType element ) throws DuplicateElementException {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * 
		 */
		
		add( root, element );
		
		
	} // end add() method
	
	/**
	 * Private recursive method that adds a new node (with the 
	 * specified element value) in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param node
	 * @param element
	 */
	private void add( BinaryNode<AnyType> node, AnyType element )  throws DuplicateElementException {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		System.out.println("The Element:"+element);
		if(node == null){
			node = new BinaryNode<AnyType>(element);
			root = node;
			System.out.println("New Node:"+node.getElement());
		}
		else{
			try {
				if ( hasElement(element) )
					throw new DuplicateElementException();
			} catch (EmptyBSTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("No Dups");
			int compareResult = element.compareTo((AnyType)node.getElement());
		
			System.out.println("Compared Result:"+compareResult);
			
			if(compareResult < 0){
				//BinaryNode<AnyType> tempNode = node.getLeft();
				if(node.getLeft()==null){
					BinaryNode newLeftNode = new BinaryNode(element);
					node.setLeft(newLeftNode);
				}
				else{
					add(node.getLeft(),element);
				}
				
			}
			else if (compareResult > 0){
//				System.out.println("temp"+node.getLeft());
				
				if(node.getRight()==null){
					BinaryNode newRightNode = new BinaryNode(element);
					node.setRight(newRightNode);
				}
				else{
					add(node.getRight(),element);
				}
			}
			else{
				;
			}
			
		}
		
		
		
	} // end add() overloaded method
	
	/**
	 * Method that determines if a node with the specified element value 
	 * exists in the BST. 
	 * 
	 * This method has one parameter:
	 *  1) The element value that is being searched.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasElement( AnyType element ) throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		
		return hasElement( root, element );
		
	} // end hasElement() method
	
	/**
	 * Private recursive method that determines if the element is 
	 * currently stored in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being searched.
	 *  
	 *  Hint: use the compareTo() method
	 * 
	 * @param element
	 * @param node
	 * @return
	 */
	private boolean hasElement( BinaryNode<AnyType> node, AnyType element ) {
		//FIX THIS JMC
		if( node == null )
			return false;
		
		int compareResult = element.compareTo( node.getElement() );
		
		if( compareResult < 0 )
			return hasElement( node.getLeft(), element );
		else if( compareResult > 0 )
			return hasElement( node.getRight(), element);
		else
			return true; // Match
		
		
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
	} // end hasElement() overloaded method
	
	/**
	 * Find the node with the minimum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType findMin() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return findMin( root ).getElement();
		
	} // end findMin() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the minimum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> node ) {
		//FIX THIS JMC
		if (node==null){
			return null;
		}
		else if(node.getLeft()==null){
			return node;
		}
		return findMin(node.getLeft());
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
	} // end findMin() method
	
	/**
	 * Find the node with the maximum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType findMax() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return findMax( root ).getElement();
		
	} // end findMax() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the maximum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMax( BinaryNode<AnyType> node ) {
		//FIX THIS JMC
		if(node !=null){
			while(node.getRight()!=null){
				node = node.getRight();
			}
		}
		return node;
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
	} // end findMax() method
	
	public String toString(){
		return toString(root);
		
		
	}
	
	public String toString(BinaryNode<AnyType> node){
		if(node!=null){
			toString(node.getLeft());
			System.out.println(node.getElement());
			toString(node.getRight());
			
		}
//		System.out.println(node.getElement());
		return null;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
		 * ------------------------------------
		 * TODO: You put your test cases here
		 * 
		 * 
		 */
		Integer x = 4;
		Integer z = 5;
		try {
			BinarySearchTree myBNS = new BinarySearchTree(x);
////			System.out.println(myBNS);
//			try {
////				System.out.println(myBNS.hasElement(5));
//				
//			} catch (EmptyBSTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			try {
				myBNS.findMax();
			} catch (EmptyBSTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Comparable temp = myBNS.findMax();
//				System.out.println(temp);
			} catch (EmptyBSTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Integer a = 10;
			Integer f = 100;
			int g = 2;
			Integer zero = 0;
			Integer three = 3;
			Integer one = 1;
			int oneHun2 = 102;
			int ninenine = 99;
			int neg = -100;
//			String myString = "hello";
//			Double dub = 5.0;
			try {
				myBNS.add(a);
				myBNS.add(f);
				myBNS.add(g);
				myBNS.add(zero);
				myBNS.add(three);
				myBNS.add(one);
				myBNS.add(oneHun2);
				myBNS.add(ninenine);
				myBNS.add(neg);
//				myBNS.add(myString);
//				myBNS.add(dub);
				System.out.println("FULL"+myBNS);
			} catch (DuplicateElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				System.out.println("MAX:"+myBNS.findMax());
			} catch (EmptyBSTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				System.out.println("MIN:"+myBNS.findMin());
			} catch (EmptyBSTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int temp1 = 19;
			myBNS.makeEmpty();
			String hello1 = "hello1";
			try {
				myBNS.add(hello1);
				myBNS.add("hello2");
				
			} catch (DuplicateElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("ANSWER"+myBNS.findMin());
				int fdsaf=0;
			} catch (EmptyBSTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				myBNS.add(10);
//				myBNS.add(9);
////				myBNS.add(10);
//			} catch (DuplicateElementException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				myBNS.hasElement(10);
//			} catch (EmptyBSTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//			try {
//				myBNS.add(18);
////				myBNS.add(18);
//				try {
//					System.out.println(myBNS.findMax());
//				} catch (EmptyBSTException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (DuplicateElementException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				myBNS.hasElement(temp1);
//			} catch (EmptyBSTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				myBNS.add(temp1);
//				try {
//					System.out.println(myBNS.hasElement(12));
//				} catch (EmptyBSTException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				int sd = 0;
//			} catch (DuplicateElementException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			
			
		} catch (NullBinaryNodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		try {
//			String new_str = "hello";
//			BinarySearchTree myBNS2 = new BinarySearchTree(new_str);
//			System.out.println(myBNS2);
//		} catch (NullBinaryNodeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	} // end main method
	

} // end BinarySearchTree class
