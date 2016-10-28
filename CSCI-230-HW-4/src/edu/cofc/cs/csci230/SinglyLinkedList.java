package edu.cofc.cs.csci230;
 
import java.util.ArrayList;
 
 
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
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
     
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
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
         
        if ( index < 0 || index >= size ) {
             
            throw new IndexOutOfBoundsException();
             
        }
         
        Node<AnyType> node = get( index );
         
        if ( index == 0 ) {
             
            headNode = node.getNextNode();
             
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
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
         
        if ( index < 0 || index >= size ) {
             
            throw new IndexOutOfBoundsException();
             
        }
         
        Node<AnyType> node = headNode;
         
        for ( int i=1; i<=index; i++ ) {
             
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
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
         
        headNode = null;
        size=0;
         
    } // end clear method
     
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
         
        ArrayList<Integer> alist = new ArrayList<Integer>();
         
        SinglyLinkedList<Integer> slist = new SinglyLinkedList<Integer>();
         
        for ( int i=0; i<5; i++ ) {
         
            slist.add( new Node<Integer>(i*2) );
            alist.add( new Integer( i*2 ) );
             
        }
         
        // -------------------------------------
        // Try remove functionality
        // -------------------------------------
        /*
        Node<Integer> rnode = slist.remove( 4 );
        System.out.println( rnode.getData() );
         
        Integer inode = alist.remove( 4 );
        System.out.println( inode );
        */
         
        // -------------------------------------
        // Try add functionality
        // -------------------------------------
        /*
        slist.add( slist.size(), new Node<Integer>(-1) );
        alist.add( alist.size(), new Integer(-1) );
        */
         
        // -------------------------------------
        // Try set functionality
        // -------------------------------------
        /*
        slist.set( 0, new Node<Integer>(-1) );
        alist.set( 0, new Integer(-1) );
        */
         
        // -------------------------------------
        // Try clear functionality
        // -------------------------------------
        /*
        slist.clear();
        alist.clear();
        */
        
        
//        for ( int i=0; i<5; i++ ) {
//            
//            alist.remove(0);
//            slist.remove(0);
//             
//        }
        
        System.out.printf("ll size = %d\n", slist.size() );
        System.out.printf("al size = %d\n", alist.size() );
         
        for ( int i=0; i<slist.size(); i++ ) {
             
            System.out.printf( "(%d,%d)\n", slist.get( i ).getData(), alist.get( i ) );
             
        }
         
         
    } // end main() method
  
} // end SinglyLinkedList class definition