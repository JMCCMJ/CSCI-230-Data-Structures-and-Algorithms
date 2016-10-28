import java.util.Scanner;




public class Binary_Counter {
	static StringBuffer binary_number = new StringBuffer();
	public static void Divide(int a) {
		if(a<=0){
			return;
		}
		
		int leftover;
		
		leftover = a%2;
		int b = a/2;
		//Binary_Counter(a)
		Divide(b);
		//System.out.print(leftover);
		binary_number.append(Integer.toString(leftover));
		
	}
	public static void main(String[] args) {
		int user_input = 0;
		Scanner scanner = new Scanner(System.in);
		Boolean pos_0 = true;
		
		while(pos_0)
		{
			System.out.println("Please enter a number greater than or equal to 0: ");
			user_input = scanner.nextInt();
			if(user_input < 0 )
			{
				System.out.println("The number entered was less than 0.");
				
			}
			else{
				pos_0=false;
			}
		}
		//System.out.println("pass");
		Divide(user_input);
		//System.out.println(binary_number);
		int counter = 0;
		
		for(int i=0; i<binary_number.length();i++)
		{
			if(binary_number.charAt(i)=='1'){
				counter++;
			}
		}
		System.out.println("The number of 1’s in binary representation of "+ user_input+" is " +counter+".");
	}
	
	

}
