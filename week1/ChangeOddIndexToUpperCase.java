package week1.day2;

public class ChangeOddIndexToUpperCase {
	/* Pseudo Code
	 
	 * Declare String Input as Follow
	  
	 * String test = "changeme";
	 
	 * a) Convert the String to character array
	 
	 * b) Traverse through each character (using loop)
	 
	 * c)find the odd index within the loop (use mod operator)
	 
	 * d)within the loop, change the character to uppercase, if the index is odd else don't change
	  
	 */
	
	public static void main(String[] args) {
		
		String test = "changeme";
		char[] change = test.toCharArray();
		int i=0;
		
		for(i=0; i<=change.length-1; i++) {
			
			if(i%2 == 1) {
				 char ch1 = Character.toUpperCase(change[i]);
				 System.out.print(ch1);	 			
			}
			
			else {
				System.out.print(change[i]);
			}
		}
	}

}
