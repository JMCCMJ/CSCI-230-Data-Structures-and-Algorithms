package edu.cofc.cs.csci230;

/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable<? super AnyType>> implements List<AnyType> {
     
    // instance variables
    private Object[] array;
    private int size = 0;
    private final static int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
    	
    	array = new Object[ INITIAL_CAPACITY ];
    	
    } // end constructor
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
    	if ( size >= capacity )
    		grow();
    	
    	array[size]=t;
        size++;
         
    } // end add() method
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	if ( index < 0 ){
			throw new IndexOutOfBoundsException();
		}
    	if (index > size()){
			throw new IndexOutOfBoundsException();
		}
    	
    	
    	if ( size >= capacity )
    		grow();
    	for(int i=0; i < size()-index+1; i++){
    		array[(size()+1)-i]=array[size()-i];
    	}
    	
    	array[index]=t;
    	size++;
    	
    	
    } // end add() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	if ( index < 0 ){
			throw new IndexOutOfBoundsException();
		}

		if (index > size()){
			throw new IndexOutOfBoundsException();
		}
    	
    	
    	if ( size >= capacity )
    		grow();
    	array[index]=t;
    	
     
    	
         
    } // end set() method
 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
	public AnyType remove( int index ) throws IndexOutOfBoundsException {
		
    	//I MADE THIS RETURN STATEMENT TO GET RID OF ERROR
    	//FIX THIS JAN-MICHAEL
    	if ( isEmpty() == true ){
			throw new IndexOutOfBoundsException();
		}
		if ( index < 0 ){
			throw new IndexOutOfBoundsException();
		}
		if (index > size()){
			throw new IndexOutOfBoundsException();
		}

    	AnyType returnThis = (AnyType) array[index];
    	if ( size < capacity/2 )
    		shrink();
    	
    	for(int i=0; i < size()-index+1; i++){
//    		array[(size()+1)-i]=array[size()-i];
//    		array[(size()-i)]=array[(size()+1)-i];
    		array[index+i]=array[index+1+i];
    	}
    	size--;
    	
    	return returnThis;
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API) to perform left or right
         * shift operations
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
    @SuppressWarnings("unchecked")
	public AnyType get(int index) throws IndexOutOfBoundsException {
    	//I MADE THIS RETURN STATEMENT TO GET RID OF ERROR
    	//FIX THIS JAN-MICHAEL
    	if (index < 0 || index > size()||isEmpty()){
			throw new IndexOutOfBoundsException();
		}
    	return (AnyType) array[index]; 
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
         
        return ( size == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     * 
     */
    public void clear() {
    	array = new Object[INITIAL_CAPACITY];
    	capacity = INITIAL_CAPACITY;
    	size = 0;
    	
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	
         
         
    } // end clear method
    
    /**
     * Double the capacity of the array
     * 
     */
    private void grow() {
    	System.out.println("GROW HAS RUN");
    	capacity = capacity * 2;
    	Object[] temp_array = new Object[ capacity ];
    	
    	for(int i=0; i < size(); i++){
    		temp_array[i] = array[i];
    	}
    	
    	array = new Object[capacity];
    	
    	for(int i=0; i < size(); i++){
    		array[i] = temp_array[i];
    	}
    	
    	System.out.println("Capacity is: "+capacity);
    	
    	
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
    	
    	
    	
    } // end grow() method
    
    
    /**
     * Half the capacity of the array
     * 
     */
    private void shrink() {
    	
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
    	System.out.println("SHRINK HAS RUN");
    	capacity = (capacity / 2)+1;
    	Object[] temp_array = new Object[ capacity ];
    	
    	for(int i=0; i < size(); i++){
    		temp_array[i] = array[i];
    	}
    	
    	array = new Object[capacity];
    	
    	for(int i=0; i < size(); i++){
    		array[i] = temp_array[i];
    	}
    	
    	System.out.println("Capacity is: "+capacity);
    	
    	
    } // end shrink() method
    
    public String toString(){
    	String temp = new String();
    	
    	for (int i=0; i<size();i++){
    		temp = temp +" "+ "["+get(i).toString()+"]";
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
//    	System.out.println("Test Cases Start");
//    	ArrayList myArrayList = new ArrayList();
//    	
//    	for(int i=0;i<15;i++){
//
//			int x = i;
//			myArrayList.add(x);
//		}
//    	
//    	int q = 100;
//    	
//    	
//    	System.out.println("*NOTE* in code the original capacity is set to 10 and myArrayList has 15 items added into it therefore grow() works.");
//    	System.out.println("Current ArrayList: "+ myArrayList.toString());
//    	myArrayList.add(5,q);
//    	System.out.println("Adding integer 100 at index 5 results in: "+myArrayList.toString());
//    	System.out.println("Attempting to add integer 100 at a negative index:");
//    	try{
//			myArrayList.add(-1,100);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, Index out of Bounds");
//		}
//    	System.out.println("Attempting to add integer 100 at an index above size:");
//    	try{
//			myArrayList.add(100000,100);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, Index out of Bounds");
//		}
//    	myArrayList.set(5, 200);
//    	System.out.println("Setting integer 200 at index 5 results in: "+myArrayList.toString());
//    	System.out.println("Attempting to set integer 200 at a negative index:");
//    	try{
//			myArrayList.set(-1,200);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, Index out of Bounds");
//		}
//    	System.out.println("Attempting to set integer 200 at an index above size:");
//    	try{
//			myArrayList.set(10000,200);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, Index out of Bounds");
//		}
//    	myArrayList.remove(5);
//    	System.out.println("Removing index 5 results in: "+myArrayList.toString());
//    	System.out.println("Attemping to remove a negative index:");
//    	try{
//			myArrayList.remove(-1);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, Index out of Bounds");
//		}
//    	System.out.println("Attemping to remove an index greater than size:");
//    	try{
//			myArrayList.remove(10000);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, Index out of Bounds");
//		}
//    	int temp = (int) myArrayList.get(5);
//    	System.out.println("Getting index 5 from myArrayList results in the temp variable: "+temp+" from the ArrayList"+myArrayList.toString());
//    	System.out.println("Attempting to get a negative index:");
//    	try{
//    		temp = (int) myArrayList.get(-1);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, Index out of Bounds");
//		}
//    	System.out.println("Attempting to get an index above size:");
//    	try{
//    		temp = (int) myArrayList.get(100000);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, Index out of Bounds");
//		}
//    	myArrayList.clear();
//    	System.out.println("Clearing the ArrayList results in it being empty:" +myArrayList.toString());
//
//    	ArrayList myArrayList2 = new ArrayList();
//    	System.out.println("Attemping to remove an index on a new ArrayList myArrayList2 that is empty:");
//    	try{
//			myArrayList2.remove(2);
//			System.out.println("No Error");
//		}
//		catch (IndexOutOfBoundsException e){
//			System.out.println("Error, null");
//		}
//    	
//    	System.out.println("Refilling myArrayList");
//    	for(int i=0;i<15;i++){
//
//			int x = i;
//			myArrayList.add(x);
//		}
//    	
//    	System.out.println("Removing index objects to make myArrayList shrink from index 0:");
//    	System.out.println("*NOTE* when shrinking I had to shrink it by half then add 1 to capacity in order for code to work");
//    	for(int i=0;i<7;i++){
//			myArrayList.remove(0);
//		}
//    	System.out.println("ArrayList is shrunk and myArrayList contains:"+myArrayList.toString());
//    	
//    	System.out.println("Test cases ended");
    	
    	
    	ArrayList myArrayList = new ArrayList();
    	System.out.println(myArrayList.get(0));
    	
    	
    	
    	
                
         
    } // end main() method
  
} // end ArrayList class definition
