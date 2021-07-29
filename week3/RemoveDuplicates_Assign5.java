package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates_Assign5 {
	/*
	 * Assignment 5: RemoveDuplicates ------------------------------
	 * 
	 * Declare a String as PayPal India
	 * 
	 * 1.Convert it into a character array
	 * 
	 * 2.Declare a Set as charSet for Character
	 * 
	 * 3.Declare a Set as dupCharSet for duplicate Character
	 * 
	 * 4.Iterate character array and add it into charSet Note: add() method in a set
	 * returns boolean value. Duplicate values will not be added and hence will
	 * return "false" So, we can find out if an element is added to the set or not
	 * using IF condition.
	 * 
	 * 5. If the element is not added in the step 4, it means the character is a
	 * duplicate and the character is already in the charSet Then, add it to the
	 * dupCharSet
	 * 
	 * 6.Check the dupCharSet elements and remove those in the charSet Note: use
	 * removeAll()
	 * 
	 * 7.Iterate using charSet
	 * 
	 * 8.Check the iterator variable isn't equals to an empty space
	 * 
	 * 9.print it
	 */

	public static void main(String[] args) {
		String givenText = "PayPal India";
		
		//1.Convert it into a character array
		char[] charArray = givenText.toCharArray();
		
		//2.Declare a Set as charSet for Character
		Set<Character> charSet = new LinkedHashSet<Character>();
		
		//3.Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		
		//4.Iterate character array and add it into charSet
		int i=0;
		for (i=0; i<charArray.length; i++) {
			boolean add = charSet.add(charArray[i]);
			if(add == false) {
				dupCharSet.add(charArray[i]);
			}
					}
		
		System.out.println("Print each character without duplicating in the set " +charSet);
		System.out.println("Print duplicate character" +dupCharSet);
		
		//6.Check the dupCharSet elements and remove those in the charSet Note: use removeAll()
		charSet.removeAll(dupCharSet);
		System.out.println("Print unique character " +charSet);
		//7.Iterate using charSet
		for (Character character : charSet) { 
			if(character !=  ' ') {
				System.out.println("Print unique character without any space " +character);	
			}
			
			
		}
	}
}
