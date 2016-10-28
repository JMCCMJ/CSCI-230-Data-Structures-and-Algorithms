package edu.cofc.cs.csci230;

/**
 * Utilities class that will sort (in increasing order)
 * the elements of a list.
 *
 * The sorting algorithms supported in this class are:
 *	1. selection sort
 *	2. bubble sort
 *	3. insertion sort
 *  4. heap sort (includes min and max heapify)
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2015
 *
 */
public class Utils {

	/**
	 * 
	 */
	private Utils() {

	} // end private constructor

	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable<? super AnyType>> void selectionSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		int min = 0;

		for ( int i=0; i<= list.size()-2; i++ ) {

			min = i;

			for ( int j=i+1; j<=list.size()-1; j++ ) {
				

				if ( list.get( j ).compareTo( list.get( min ) ) < 0 ) {
				
					min = j;
					
				}

			}

			list.swap( i, min );

		}

	} // end selectionSort() method

	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable<? super AnyType>> void bubbleSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		for ( int i=0; i<= list.size()-2; i++ ) {

			for ( int j=0; j<=list.size()-2-i; j++ ) {

				if (  list.get( j+1 ).compareTo( list.get( j ) ) < 0 ) {
					
					list.swap( j, j+1 );
					
				}

			}

		}

	} // end bubbleSort() method

	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable<? super AnyType>> void insertionSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		AnyType v = null;
		
		int j = 0;

		for ( int i=1; i< list.size(); i++ ) {
			
			v = list.get( i );
			
			if ( v instanceof Node<?> )
				v = (AnyType)((Node<AnyType>)v).clone();
			
			j = i - 1;

			while( j >= 0 && ( list.get( j ).compareTo( v ) > 0 ) ) {
					
				list.set( j+1, list.get( j ) );
				j--;
				
			}
			
			list.set( j+1, v );
			
		}


	} // end insertionSort() method
	
	/**
	 * 
	 * @param list
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable<? super AnyType>> void maxHeapify( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * Implement max heapify algorithm as
		 * described in class and in the course 
		 * textbook. The pseudo-code for this 
		 * algorithm can also be found in 
		 * the content section on OAKS.
		 * 
		 */
		
		if(list.size()<1){
			throw new IndexOutOfBoundsException();
		}
		
		int n = list.size();
		int j = 0;
		int k = 0;
		boolean heap;
		AnyType v;
		for (int i = (int) Math.floor((n-2)/2); i > -1;i--){
			k = i;
			v = list.get(k);
			heap = false;
			while(!heap && (2*k+2)<=n){
				j = 2*k+1;

				if (j+1 < n){
					if (list.get(j).compareTo(list.get(j+1))==-1){
						j = j+1;
					}
//					System.out.println("IF 1");
					

				}
				if(v.compareTo(list.get(j))==1 || v.compareTo(list.get(j))==0){
//					System.out.println("IF 2");
					heap = true;
				}
				else{
//					System.out.println("ELSE");
					list.set(k, list.get(j));
//					list.swap(k, j);
					k = j;
				}

			}
			list.set(k, v);
			
			
		}
		
		
		
		
		
		
		
		
	} // end maxHeapify() method
	
	
	/**
	 * 
	 * @param list
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable<? super AnyType>> void minHeapify( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * Implement min heapify algorithm as
		 * described in class and in the course 
		 * textbook. The pseudo-code for this 
		 * algorithm can also be found in 
		 * the content section on OAKS.
		 * 
		 */
		if(list.size()<1){
			throw new IndexOutOfBoundsException();
		}
		
		int n = list.size();
		int j = 0;
		int k = 0;
		boolean heap;
		AnyType v;
		for (int i = (int) Math.floor((n-2)/2); i > -1;i--){
			k = i;
			v = list.get(k);
			heap = false;
			while(!heap && (2*k+2)<=n){
				j = 2*k+1;

				if (j+1 < n){
					if (list.get(j).compareTo(list.get(j+1))==1){
						j = j+1;
					}
//					System.out.println("IF 1");
					

				}
				if(v.compareTo(list.get(j))==-1 || v.compareTo(list.get(j))==0){
//					System.out.println("IF 2");
					heap = true;
				}
				else{
//					System.out.println("ELSE");
//					AnyType temp = list.get(k);
					list.set(k, list.get(j));
//					list.set(j, temp);
					
					
//					list.swap(k, j);
					k = j;
				}

			}
			list.set(k, v);
			
			
		}
		
		
		
		
		
		
	} // end minHeapify() method

	/**
	 * 
	 * @param sorted_list
	 * @param list
	 * @param increasing
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable<? super AnyType>> void heapSort( List<AnyType> sorted_list, List<AnyType> list, Boolean increasing ) throws IndexOutOfBoundsException {
		
		/*
		 * Implement heap sort algorithm as
		 * described in class and in the course 
		 * textbook. The pseudo-code for this 
		 * algorithm can also be found in 
		 * the content section on OAKS.
		 * 
		 */
		if(list.size()<1){
			throw new IndexOutOfBoundsException();
		}
		if(increasing == false){
			maxHeapify(list);
			for(int i = 0; i < list.size()-1;i++){
//				list.swap(0, list.size()-1);
//				list.set(0, list.get(list.size()-1));
//				list.remove(list.size()-1);
//				maxHeapify(list);
				AnyType temp = list.remove(0);
				sorted_list.add(temp);
			}
			
		}
		else{
			minHeapify(list);
			for(int i = 0; i < list.size()-1;i++){
				AnyType temp = list.remove(0);
				sorted_list.add(temp);
			}
		}
			
		
		
		
		
				
	} // end heapSort() method

} // end Utils class definition
