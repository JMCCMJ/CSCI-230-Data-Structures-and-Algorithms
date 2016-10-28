package edu.cofc.cs.csci230;

import java.util.ArrayList;

public class SinglyLinkedList_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int points = 0;
		ArrayList testList = new ArrayList(50);
		SinglyLinkedList list = new SinglyLinkedList();
		boolean passed;

		System.out.println("----------------------------------");
		System.out.println("Test Case_1:");

		try {
			list.get(0);
			System.out.println("[Failed]");
		} catch (Exception e){
			System.out.println("[Passed]");
			points += 10;
		}

		System.out.println("----------------------------------");
		System.out.println("Test Case_2:");

		passed = true;

		try {

			for(int i = 0; i < 25; i++){
				testList.add(i, i);
				list.add(new Node<Integer> (i));
			}

		} catch( Exception error ) {

			passed = false;
		}

		if ( passed ) {

			try{
				for (int i = 0; i < 25; i++){
					if(testList.get(i) != list.get(i).getData())
						passed = false;
				}
			} catch (Exception e){
				passed = false;
			}

		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} 
		else{
			System.out.println("[Failed]");
		}

		System.out.println("----------------------------------");
		System.out.println("Test Case_3:");

		try {

			list.clear();

			if(list.isEmpty()){
				System.out.println("[Passed]");
				points += 10;
			}
			else{
				System.out.println("[Failed]");
			}

		} catch( Exception error ) {
			System.out.println("[Failed]");
		}

		testList.clear();

	
		System.out.println("----------------------------------");
		System.out.println("Test Case_4:");

		passed = true;

		try{
			for(int i = 0; i < 5; i++){
				testList.add(i, i);
				list.add(i, new Node<Integer> (i));
			}
		} catch (Exception e){
			passed = false;
		}

		try{
			for (int i = 0; i < 5; i++){
				if(testList.get(i) != list.get(i).getData())
					passed = false;
			}
		} catch (Exception e){
			passed = false;
		}

		try{
			testList.add(2, 6);
			list.add(2, new Node<Integer>(6));
		} catch (Exception e){
			passed = false;
		}

		try{
			if(testList.get(0) != list.get(0).getData() ||
			   testList.get(3) != list.get(3).getData() ||
			   testList.get(5) != list.get(5).getData()){
				passed = false;
			}
		} catch (Exception e){
			passed = false;
		}

		if(passed) {
			System.out.println("[Passed]");
			points += 10;
		} 
		else{
			System.out.println("[Failed]");
		}

		System.out.println("----------------------------------");
		System.out.println("Test Case_5:");

		passed = true;

		try{
			testList.set(1, 10);
			list.set(1, new Node<Integer>(10));
		} catch (Exception e){
			passed = false;
		}

		try{
			if ((list.get(1).getData()) != (testList.get(1)) || 
				(list.get(2).getData()) != (testList.get(2))){
				passed = false;
			}
		} catch (Exception e){
			passed = false;
		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} else{
			System.out.println("[Failed]");
		}

		System.out.println("----------------------------------");
		System.out.println("Test Case_6:");

		passed = true;

		try{
			testList.remove(3);
			list.remove(3);
		} catch (Exception e){
			passed = false;
		}
		
		try{
			list.get(5);
//			System.out.println(x+"@@@@@@@@@@@@@@@@@@");
			System.out.println("[Failed]");
		} catch (Exception e){
			
			if(passed){
				System.out.println("[Passed]");
				points += 10;
			} else{
				System.out.println("[Failed]");
			}
		}

		System.out.println("----------------------------------");
		System.out.println("Test Case_7:");

		if (list.size() == 5){
			System.out.println("[Passed]");
			points += 10;
		} 
		else{
			System.out.println("[Failed]");
		}

		System.out.println("----------------------------------");
		System.out.println("Test Case_8:");

		try {

			testList.clear();
			list.clear();

			if(list.size() != 0){
				System.out.println("[Failed]");
			} else{
				System.out.println("[Passed]");
				points += 10;
			}

		} catch( Exception error ) {
			System.out.println("[Failed]");
		}

		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("---------------------------------------------------------------");
		System.out.println("                            Points Possible    Points Received");
		System.out.println("SinglyLinkedList Compiles         10                 10  ");
		System.out.println("SinglyLinkedList Runs              5                  5  ");
		System.out.println("Thorough test cases                5                    ");
		System.out.println("Instructor Test Cases             80                 " + points);
		System.out.println("    (8 @ 10pts each)");
		System.out.println("                                              Total points: " + (points+15));
		System.out.println("---------------------------------------------------------------");
	}

}