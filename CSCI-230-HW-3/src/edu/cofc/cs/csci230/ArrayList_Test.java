package edu.cofc.cs.csci230;

public class ArrayList_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int points = 0;
		boolean passed;

		ArrayList<String> list = new ArrayList<String>();

		String island_1 = "Curacao"; 
		String island_2 = "Aruba";
		String island_3 = "Cayman Brac";
		String island_4 = "Saint Thomas";
		String island_5 = "Saint Lucia";
		String island_6 = "BoraBora";
		String island_7 = "Fiji";
		String island_8 = "Tahiti";
		String island_9 = "Maui";
		String island_10 = "Kangaroo Island";
		String island_11 = "Turks and Caicos";
		String island_12 = "Maldives";
		String island_13 = "Bermuda";
		String island_14 = "Bonaire";
		String island_15 = "Roatan";



		System.out.println("----------------------------------");
		System.out.println("Test Case_1:");

		try{
			list.get(0);
			System.out.println("[Failed]");
		} catch (Exception e){
			System.out.println("[Passed]");
			points += 10;
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_2:");
		passed = true;

		try{
			list.add(0, island_1);
			list.add(island_2);
			list.add(island_3);
			list.add(island_4);
			list.add(4, island_5);
			list.add(0, island_6);
			list.add(island_7);
			list.add(2, island_8);
			list.add(7, island_9);
			list.add(5, island_10);

			if (list.get(0) != "BoraBora" ||
				list.get(2) != "Tahiti" ||
				list.get(4) != "Cayman Brac" ||
				list.get(6) != "Saint Thomas" ||
				list.get(8) != "Maui"){
				passed = false;
			}
		} catch (Exception e){
			passed = false;
		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_3:");
		passed = true;
		list.clear();

		try{
			list.add(0, island_11);
			list.add(island_12);
			list.add(island_13);
			list.add(13,island_14);
			list.add(island_15);

			if (list.get(0) !=  "Turks and Caicos" ||
				list.get(10) !=  "Fiji" ||
				list.get(12) !=  "Bermuda" ||
				list.get(14) != "Roatan"){
				 passed = false;
			}
		} catch (Exception e){
			passed = false;
		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}
	


		System.out.println("----------------------------------");
		System.out.println("Test Case_4:");
		passed = true;

		try {
			list.set(0, "Bahamas");
			list.set(6, "Jamaica");
			list.set(14, "Tonga");

			if(list.get(0) != "Bahamas" ||
			   list.get(6) != "Jamaica" ||
			   list.get(14) != "Tonga"){
				passed = false;
			}
		} catch (Exception e){
			passed = false;
		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_5:");
		passed = true;

		try {
			list.remove(0);
			list.remove(0);
			list.remove(5);
			list.remove(10);
			list.remove(10);

			if(list.get(0) != "Curacao" ||
			   list.get(2) != "Aruba" ||
			   list.get(4) != "Jamaica" ||
			   list.get(6) != "Maui" ||
			   list.get(8) != "Maldives"){
				passed = false;
			}
		} catch (Exception e){
			passed = false; 
		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_6:");
		passed = true;

		try {
			list.remove(1);

			if(list.get(0) != "Curacao" ||
			   list.get(2) != "Cayman Brac" ||
			   list.get(4) != "Saint Lucia" ||
			   list.get(6) != "Fiji" ||
			   list.get(8) != "Bermuda"){
				passed = false;
			}
		} catch (Exception e){
			passed = false; 
		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_7:");
		passed = true;

		try{
			list.clear();

			if (list.size() != 0){
				passed = false;
			}
		} catch (Exception e){
			passed = false;
		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_8:");
		passed = true;

		try{
			for(int i = 0; i < 1000; i++){
				list.add(i, Integer.toString(i));
			}
		} catch (OutOfMemoryError e){
			passed = false;
		} catch (Exception error ) {

			passed = false;
		}

		if(passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("                     Points Possible    Points Received");
		System.out.println("ArrayList Compiles         10                 10  ");
		System.out.println("ArrayList Runs              5                  5  ");
		System.out.println("Thorough test cases         5                    ");
		System.out.println("Instructor Test Cases      80                 " + points);
		System.out.println("   (8 @ 10pts each)");
		System.out.println("                                      Total points: " + (points+15));
		System.out.println("-------------------------------------------------------");
	}

}