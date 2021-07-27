package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collections_Assignment4 {
	/*
	 * Assignment 4: Sort using collection
	 * 
	 * 1.Declare a String array and add the Strings values as
	 * (Google,Microsoft,TestLeaf,Maverick)
	 * 
	 * 2. Get the length of the array
	 * 
	 * 3. sort the array
	 * 
	 * 4. Iterate it in the reverse order
	 * 
	 * 5. print the array
	 * 
	 * 6. Required Output: Wipro, HCL , CTS, Aspire Systems
	 */
	public static void main(String[] args) {
		
		List<String> companyName = new ArrayList<String>();
		companyName.add("Google");
		companyName.add("Microsoft");
		companyName.add("TestLeaf");
		companyName.add("Maverick");
		
		//Length of Array
		System.out.println("The length of the array is "+ companyName.size());
		
		//Sort the Array
		Collections.sort(companyName);
		System.out.println("Sorted Array list is "+ companyName);
		
		//Iterate it in reverse order and print array
		Collections.reverse(companyName);
		System.out.println("Printing reverse Order of array "+ companyName);
		
	}

}
