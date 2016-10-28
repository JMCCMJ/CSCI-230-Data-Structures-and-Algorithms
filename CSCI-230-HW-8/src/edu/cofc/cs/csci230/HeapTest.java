package edu.cofc.cs.csci230;

public class HeapTest {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> sorted_list = new ArrayList<Integer>();
		
		list.add( 5 );
		list.add( 16 );
		list.add( 8 );
		list.add( 14 );
		list.add( 20 );
		list.add( 1 );
		list.add( 26 );
//		list.add( 5 );
//		list.add( 16 );
//		list.add( 8 );
//		list.add( 14 );
//		list.add( 20 );
//		list.add( 1 );
//		list.add( 26 );
//		list.add(4);
//		list.add(30);
//		list.add(-4);
		
		
//		int length = list.size();
//		for(int i = 0; i < length;i++){
//			System.out.println(list.get(i));
//		}
//		
//		Utils.minHeapify(list);
//		System.out.println("\n");
//		
//		for(int i = 0; i < list.size();i++){
//			System.out.println(list.get(i));
//		}
//		Utils.maxHeapify(list);
//		System.out.println("\n");
//		for(int i = 0; i < list.size();i++){
//			System.out.println(list.get(i));
//		}
//		
//		Boolean increasing=false;
//		Utils.heapSort(sorted_list, list, increasing);
//		int length = list.size();
//		for(int i = 0; i < length;i++){
//			System.out.println(list.get(i));
//		}
		
		
		
		Utils.heapSort( sorted_list, list, true );
		int length3 = list.size();
		int length4 = list.size();
		System.out.println("BEFORE");
		for(int i = 0; i < length3;i++){
			System.out.println(list.get(i));
		}
		System.out.println("SORTED:");
		for(int i = 0; i < length4-1;i++){
			System.out.println(sorted_list.get(i));
		}
//		System.out.println ( sorted_list );
//		
//		SinglyLinkedList<Integer> slist = new SinglyLinkedList<Integer>();
//		SinglyLinkedList<Integer> sorted_slist = new SinglyLinkedList<Integer>();
//		
//		slist.add( new Node<Integer>(5) );
//		slist.add( new Node<Integer>(16) );
//		slist.add( new Node<Integer>(8) );
//		slist.add( new Node<Integer>(14) );
//		slist.add( new Node<Integer>(20) );
//		slist.add( new Node<Integer>(1) );
//		slist.add( new Node<Integer>(26) );
//		
//		int length2 = slist.size();
//		for(int i = 0; i < length2;i++){
//			System.out.println(slist.get(i));
//		}
//		
//		Utils.minHeapify(slist);
//		System.out.println("NEXT");
//		
//		for(int i = 0; i < list.size();i++){
//			System.out.println(slist.get(i));
//		}
		
//		Utils.heapSort(sorted_slist, slist, true );
//		System.out.println( sorted_slist );

	}

}
