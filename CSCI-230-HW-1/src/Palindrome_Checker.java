import java.util.Scanner;


public class Palindrome_Checker {
	static String lowerCaseString;
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String user_input = null;
		Scanner scanner = new Scanner(System.in);
		
		
		
		Boolean all_char_dig_bool = true;
		int char_checker = 0;
		
		
		
		while(all_char_dig_bool)
		{
			System.out.println("Enter a word to check if it is a palindrome (Please enter only letters and numbers): ");
			user_input = scanner.next();
			//System.out.println(user_input);
			
			lowerCaseString = user_input.toLowerCase();
			//System.out.println(lowerCaseString);
			all_char_dig_bool = false;
			
			for( int i=0; i<lowerCaseString.length(); i++ )
			{
				Character char_value = lowerCaseString.charAt(i);
				int char_num = char_value.charValue();
				if(!((char_num <= 122 && char_num >= 97) || (char_num <=57 && char_num >=48))) 
				{
					System.out.println("Please enter only letters or numbers.");
					all_char_dig_bool=true;
					break;
					
				}
				
			}	
				
		}
		
		//System.out.println("pass");
		
		StringBuffer new_stringbuf = new StringBuffer();
		
		for (int i=0; i < lowerCaseString.length();i++)
		{
			new_stringbuf.append(lowerCaseString.charAt(lowerCaseString.length()-1-i));
		}
		//System.out.println(new_stringbuf);
		
		if (new_stringbuf.toString().equals(lowerCaseString))
		{
			System.out.println("The word "+ user_input+" is a palindrome!");
		}
		else
		{
			System.out.println("The word "+user_input+" is not a palindrome.");
		}
	}
}
