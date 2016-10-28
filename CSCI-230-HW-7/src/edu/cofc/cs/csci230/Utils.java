package edu.cofc.cs.csci230;

import java.util.Arrays;
import java.util.Collections;

/**
 * Utilities class that will sort (in increasing order)
 * the elements of a list.
 *
 * The sorting algorithms supported in this class are:
 *	1. selection sort
 *	2. bubble sort
 *	3. insertion sort
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

		/* -------------------------------------
		 * TODO:
		 *
		 * Implement selection sort algorithm as
		 * described in class. The pseudo-code
		 * for this algorithm can be found in 
		 * the content section on OAKS.
		 * 
		 */
		int min;
		int listLength = list.size();
		for(int i = 0; i < listLength-1; i++){
			min = i;
			for(int j = i+1; j < listLength; j++){
				int compareResult = list.get(j).compareTo(list.get(min));
				if(compareResult==-1){
					min = j;
					
				}

			}
			list.swap(i, min);
		}
			
		

		
		
		
		
		
		
		
	} // end selectionSort() method

	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable<? super AnyType>> void bubbleSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		/* -------------------------------------
		 * TODO:
		 *
		 * Implement bubble sort algorithm as
		 * described in class. The pseudo-code
		 * for this algorithm can be found in 
		 * the content section on OAKS.
		 * 
		 */
		int listLength = list.size();
		for(int i = 0; i < listLength-1; i++){
			for(int j = 0; j < listLength-1-i; j++){
				int compareResult = list.get(j+1).compareTo(list.get(j));
				if(compareResult == -1){
					list.swap(j, j+1);
				}
			}
		}

		
		
		
		
		

	} // end bubbleSort() method

	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable<? super AnyType>> void insertionSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		/* -------------------------------------
		 * TODO:
		 *
		 * Implement insertion sort algorithm as
		 * described in class and in the course 
		 * textbook. The pseudo-code for this 
		 * algorithm can also be found in 
		 * the content section on OAKS.
		 * 
		 */
		
		AnyType temp = null;
        for (int i = 1; i < list.size(); i++) {
            for(int j = i ; j > 0 ; j--){
            	temp = list.get(j);
            	
            	list.set(i,list.get(i-1));
            	  
            }
            list.set(i,temp);
        }
//		int temp;
//        for (int i = 1; i < input.length; i++) {
//            for(int j = i ; j > 0 ; j--){
//                if(input[j] < input[j-1]){
//                    temp = input[j];
//                    input[j] = input[j-1];
//                    input[j-1] = temp;
//                }
//            }
//        }
        

		
//		int j;
//		for(int p = 1; p < list.size(); p++){
//			AnyType tmp = list.get(p);
//			System.out.println(tmp.toString());
//			for ( j = p; j > 0 && tmp.compareTo(list.get(j-1))<0;j--){
//				list.set(j, list.get(j-1));
//				System.out.println(list.toString());
//			}
//				
//			
//			list.set(j,tmp);
//		}
		
		
		
		//THIS
//		int j;
//		AnyType x;
//		for(int i=1; i< list.size();i++){
//			x = list.get(i);
//			j = i-1;
//			while(j>0 && list.get(j-1).compareTo(x) == 1){
//				list.set(j, list.get(j-1));
//				list.set(j-1, list.get(j));
////				list.swap(j, j-1);
//				
//				j--;
//				
//				
//			}
//			list.set(j+1, x);
//			list.set(i, list.get(j+1));
//			list.swap(j, i);
//		}
		
//		int listLength = list.size();
//		for(int i = 0; i < listLength-1; i++){
//			for(int j1 = 0; j1 < listLength-1-i; j1++){
//				int compareResult = list.get(j1+1).compareTo(list.get(j1));
//				if(compareResult == -1){
//					list.swap(j1, j1+1);
//				}
//			}
//		}
//		
//		AnyType v;
//		int j;
//		int listLength = list.size();
//		for(int i = 1; i < listLength; i++){
//			System.out.println("count");
//			v = list.get(i);
//			j = i;
//			int compareResult;
//			while( j > 0 && (compareResult = list.get(j).compareTo(v))==1){
//				System.out.println("HELLO");
//				AnyType temp1 = list.get(j);
//				
//				list.set(j+1, list.get(j));
//				j = j-1;
//				list.swap(j, j+1);
//			}
//			j = j-1;
//			
//			list.set(j+1, v);
//		}
//		int j;
//		for(int i=1; i < list.size(); i++){
//			AnyType temp = list.get(i);
//			for( j=i; j > 0 && temp.compareTo(list.get(j-1))<0; j--){
//				list.set(j, list.get(j-1));
//				
//			}
//			list.set(j, temp);
//		
//		
//		}

		
		
		
		
		
		
		
	} // end insertionSort() method
	public static void main( String[] args ) {
		Integer x = 0;
		Integer y = 1;
		Integer z = 2;
		Integer a = 3;
		Node zero = new Node(x);
		Node one = new Node(y);
		Node two = new Node(z);
		Node three = new Node(a);
		
		
		
		SinglyLinkedList mySLL = new SinglyLinkedList();
		mySLL.add(one);
		mySLL.add(zero);
		mySLL.add(three);
		mySLL.add(two);
		System.out.println(mySLL.toString());
		System.out.println();
		
		Utils sorter = new Utils();
		sorter.insertionSort(mySLL);
//		sorter.insertionSort(mySLL);
//		sorter.insertionSort(mySLL);
//		sorter.insertionSort(mySLL);
		System.out.println(mySLL.toString());
		
//		mySLL.bubbleSort();
		
		Integer[] input = {3,2,9,1};
		
		
		int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
       System.out.println(Arrays.toString(input));
       
       //WHY DOES THIS WORK AND MY INSERTIONSORT DOESNT
		
	}

} // end Utils class definition
