package week1.day2;

import java.util.Arrays;

public class Anagram {
	/*
	 * Pseudo Code
	 *Declare a String 
		String text1 = "stops";
	 *Declare another String
		String text2 = "potss"; 
	 * a) Check length of the strings are same then (Use A Condition)
	 * b) Convert both Strings in to characters
	 * c) Sort Both the arrays
	 * d) Check both the arrays has same value
	 * 
	 */

	public static void main(String[] args) {
		String text1 = "stops";
		String text2 = "potss";
		
		int i = text1.length();
		int j = text2.length();
		boolean status = false;
		
		if(i == j) {
			char[] ch1 = text1.toCharArray();
			char[] ch2 = text2.toCharArray();
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			System.out.println(ch1);
			System.out.println(ch2);
			
			status = Arrays.equals(ch1, ch2);
			
			if (status == true) {
				System.out.println("Both are anagrams");
			}
			else {
				System.out.println("Both are not anagrams");
			}
		}
		else {
			System.out.println("both are not anagrams");
		}
	}

}
