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
	 * @throws NullBinaryNodeException 
	 * @throws DuplicateElementException 
	 */
	public void add( AnyType element ) throws DuplicateElementException, NullBinaryNodeException {
		
		if ( element == null ) {
			
			throw new NullBinaryNodeException();
			
		} if ( root == null ) {
			
			this.root = new BinaryNode<AnyType>( element );
			
		} else {
			
			add( root, element );
	
		}
		
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
		
		int compare = element.compareTo( node.getElement() );
		
		if ( compare == 0 ) {
			
			throw new DuplicateElementException();
			
		} else if ( compare < 0 ) {
			
			if ( node.getLeft() == null ) {
				
				node.setLeft( new BinaryNode<AnyType>( element ) );
				node.getLeft().setParent( node );
				
			} else {
				
				add( node.getLeft(), element );
				
			}
			
		} else if ( compare > 0 ) {
			
			if ( node.getRight() == null ) {
				
				node.setRight( new BinaryNode<AnyType>( element ) );
				node.getRight().setParent( node );
				
			} else {
				
				add( node.getRight(), element );
				
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
	 * @throws NullBinaryNodeException 
	 * @throws EmptyBSTException 
	 * 
	 */
	public boolean hasElement( AnyType element ) throws EmptyBSTException, NullBinaryNodeException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		else if ( element == null )
			throw new NullBinaryNodeException();
		
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
		
		if ( node == null )
			return false;
		
		int compare = element.compareTo( node.getElement() );
		
		if ( compare == 0 ) {
			
			return true;
			
		} else if ( compare < 0 ) {
			
			return hasElement( node.getLeft(), element );
			
		} else {
			
			return hasElement( node.getRight(), element );
			
		}
		
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
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		if ( node.getLeft() == null ) {
			
			return node;
			
		} else {
			
			return findMin( node.getLeft() );
		}
		
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
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		if ( node.getRight() == null ) {
			
			return node;
			
		} else {
			
			return findMax( node.getRight() );
		}
		
	} // end findMax() method
	
	/**
	 * Delete the node with the specified element value in the BST.
	 * 
	 * This method has one parameter:
	 * 	1) the element value to be deleted
	 * 
	 * This method performs the following delete operations
	 * 	1) delete node with no children (case 1)
	 * 	2) delete node with one child (case 2)
	 * 	3) delete node with two children (case 3)
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * If the element is null, throw a null binary node 
	 * exception
	 *  
	 * @param element
	 * @throws EmptyBSTException
	 * @throws NullBinaryNodeException
	 */
	public void delete( AnyType element ) throws EmptyBSTException, NullBinaryNodeException {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		if (isEmpty()){
			throw new EmptyBSTException();
		}
		if(element == null){
			throw new NullBinaryNodeException();
		}
		
		delete(root,element,0);
		
		
		
		
	} // end delete() method
	
	/**
	 * Private recursive method that walk the BST looking for 
	 * the specified element value to be removed.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being removed.
	 *  
	 * @param node
	 * @param element
	 */
	private void delete( BinaryNode<AnyType> node, AnyType element, Integer side ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		//LEFT = 1
		//RIGHT = 2;
		if (node == null){
			int abc = 123;
		}
		else{
			int compareResult = element.compareTo(node.getElement());
			
			if(compareResult<0){
				delete(node.getLeft(),element,1);
			}
			else if (compareResult>0){
				delete(node.getRight(),element,2);
			}
			else if(compareResult == 0 ){
//				System.out.println("Match Found");
//				System.out.println(node.getRight().toString());
				if (node.getRight()==null && node.getLeft()==null){
					if(node == root){
						root = null;
//						System.out.println("No Child");
						node.setElement(null);
						node=null;
//						System.out.println("Null Set");
					}
					else{
//						System.out.println("No Child");
						node.setElement(null);
						node=null;
//						System.out.println("Null Set");
					}
					
				}
				else if ((node.getRight()==null && node.getLeft() !=null)){
					if(node==root){
						node.getLeft().setParent(null);
						root = node.getLeft();
					}
					else{
						BinaryNode temp = node.getParent();
						if(side ==1){
							temp.setLeft(node.getLeft());
							node.getLeft().setParent(temp);
		
						}
						else if(side == 2){

							temp.setRight(node.getRight());
							node.getRight().setParent(temp);
							
							
						}
						
					}
					
		
				}
				else if ((node.getLeft()==null && node.getRight() !=null)){
					if(node==root){
						node.getRight().setParent(null);
						root = node.getRight();
					}
					else{
						BinaryNode temp = node.getParent();
						if(side ==1){
							temp.setLeft(node.getLeft());
							node.getLeft().setParent(temp);
							
						}
						else if(side == 2){
							temp.setRight(node.getRight());
							node.getRight().setParent(temp);
						}
					}
					
		
				}
				else if (node.getRight()!=null && node.getLeft()!=null){
					if(node==root){
						BinaryNode min = findMin(node.getRight());
						AnyType tempElement = (AnyType) min.getElement();
						node.setElement(tempElement);
						root = node;
						delete(min,tempElement,2);
						
						
					}
					else{
						BinaryNode temp = node.getParent();
						if(side ==1){
							BinaryNode min = findMin(node.getRight());
							AnyType tempElement = (AnyType) min.getElement();
							node.setElement(tempElement);
							if(min.getParent()== node){
								delete(min,tempElement,2);
							}
							else{
								delete(min,tempElement,1);
							}
							
							
						}
						else if(side == 2){
							BinaryNode min = findMin(node.getRight());
							AnyType tempElement = (AnyType) min.getElement();
							node.setElement(tempElement);
							if(min.getParent()== node){
								delete(min,tempElement,2);
							}
							else{
								delete(min,tempElement,1);
							}
						}
						
					}
					
					
				}
					
			}
			
			
			
		}
		
		
		
		
		
	} // end delete() method
	
	/**
	 * Recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an post-order 
	 * tree traversal format.
	 * 
	 * The return string MUST be formated as follows:
	 * <element>,<element>,<element>,<element>, .... <element>
	 * where <element> is the element value
	 * For example,
	 * 	1,3,2
	 * Hint: you may want to use regular expressions
	 * 
	 * Discussed in class, please review 
	 * your notes
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search 
	 * tree exception
	 * 
	 * @throws EmptyBSTException 
	 * @return
	 * 
	 */
	public String postOrder() throws EmptyBSTException {
		if(isEmpty()){
			throw new EmptyBSTException();
		}
		String postEdit = "";
		String postOrderString = postOrder(root,postEdit);
		String returnString = postOrderString.substring(0, postOrderString.length()-1);
		return returnString;
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
		
		
	} // end postOrder() method
	
	/**
	 * Private recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an post-order 
	 * tree traversal format. 
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *  
	 * @param node
	 * @return
	 * 
	 */
	private String postOrder( BinaryNode<AnyType> node,String postEdit ) {
		//JMC FIX THIS
		
		if(node!=null){
			
//			
//			System.out.print(postOrder(node.getLeft()));
//			System.out.print(postOrder(node.getRight()));
//			if(node==root){
//				System.out.print(node.getElement());
//				
//			}
//			else{
//				System.out.print(node.getElement()+",");
//			}
			postEdit= postOrder(node.getLeft(),postEdit);
			postEdit =  postOrder(node.getRight(),postEdit);
			postEdit = postEdit+node.getElement()+",";
			
			
		}
		
		
		return postEdit;
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
		
		
	} // end postOrder() method
	
	/**
	 * Recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an pre-order 
	 * tree traversal format.
	 * 
	 * The return string MUST be formated as follows:
	 * <element>,<element>,<element>,<element>, .... <element>
	 * where <element> is the element value
	 * For example,
	 * 	2,1,3
	 * Hint: you may want to use regular expressions
	 * 
	 * Discussed in class, please review 
	 * your notes
	 * 
	 * If the BST is empty, throw an empty binary search 
	 * tree exception
	 * 
	 * @throws EmptyBSTException 
	 * @return 
	 * 
	 */
	public String preOrder() throws EmptyBSTException {
		//JMC FIX THIS
		if(isEmpty()){
			throw new EmptyBSTException();
		}
		String preEdit = "";
		String preOrderString = preOrder(root,preEdit);
		String returnString = preOrderString.substring(0, preOrderString.length()-1);
		return returnString;
		
		
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
		
		
	} // end preOrder() method
	
	/**
	 * Private recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an pre-order 
	 * tree traversal format. 
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *  
	 * @param node
	 * @return
	 * 
	 */
	private String preOrder( BinaryNode<AnyType> node,String preEdit ) {
		//JMC FIX THIS
		if(node!=null){

			preEdit = preEdit+node.getElement()+",";
			preEdit= postOrder(node.getLeft(),preEdit);
			preEdit =  postOrder(node.getRight(),preEdit);
			


		}


		return preEdit;
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
		
	} // end preOrder() method
	
	/**
	 * Recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an in-order 
	 * tree traversal format. 
	 * 
	 * The return string MUST be formated as follows:
	 * <element>,<element>,<element>,<element>, .... <element>
	 * where <element> is the element value
	 * For example,
	 * 	1,2,3
	 * Hint: you may want to use regular expressions
	 * 
	 * Discussed in class, please review 
	 * your notes
	 * 
	 * If the BST is empty, throw an empty binary search 
	 * tree exception
	 * 
	 * @throws EmptyBSTException 
	 * @return
	 * 
	 */
	public String inOrder() throws EmptyBSTException {
		//JMC FIX THIS
		if(isEmpty()){
			throw new EmptyBSTException();
		}
		String inEdit = "";
		String inOrderString = inOrder(root,inEdit);
		String returnString = inOrderString.substring(0, inOrderString.length()-1);
		return returnString;
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
		
		
		
	} // end inOrder() method
	
	
	/**
	 * Private recursive method that traverses the BST 
	 * dynamically creating a string with the element 
	 * values stored in an in-order tree traversal format.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *  
	 * @param node
	 * @return
	 * 
	 */
	private String inOrder( BinaryNode<AnyType> node,String inEdit ) {
		//JMC FIX THIS
		if(node!=null){

			inEdit= inOrder(node.getLeft(),inEdit);
			inEdit = inEdit+node.getElement()+",";
			inEdit =  inOrder(node.getRight(),inEdit);
			


		}


		return inEdit;
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
		
		
	} // end inOrder() method
	
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
		Integer w = 2;
		Integer x = 1;
		Integer y = 3;
		Integer z = 100;
		Integer a = 20;
		Integer b = 4;
		Integer c = 7;
		Integer d = 8;
		Integer f = 6;
		try {
			BinarySearchTree myBNS = new BinarySearchTree(w);
			
			try {
				myBNS.add(x);
				myBNS.add(y);
				myBNS.add(z);
				myBNS.add(a);
				myBNS.add(b);
				myBNS.add(c);
				myBNS.add(d);
				myBNS.add(f);
//			
				
			} catch (DuplicateElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
//			myBNS.makeEmpty();
////			
//			try {
//				System.out.println(myBNS.postOrder());
//				System.out.println(myBNS.preOrder());
//				System.out.println(myBNS.inOrder());
//
//			} catch (EmptyBSTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				System.out.println("START");
//				myBNS.delete(7);
//				System.out.println(myBNS.preOrder());
//				BinaryNode temp = new BinaryNode(5000);
//				myBNS.delete(temp);
//				myBNS.delete(null);
//				System.out.println("ALMOST");
//				System.out.println("Finish");
//			} catch (EmptyBSTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			
			
			
			
			
			
			
		} catch (NullBinaryNodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	} // end main method
	

} // end BinarySearchTree class
