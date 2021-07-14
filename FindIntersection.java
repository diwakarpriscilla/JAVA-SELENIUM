package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		/* Pseudo Code
		 * a) Declare An array for {3,2,11,4,6,7}; 
		 * b) Declare another array for {1,2,8,4,9,7}; 
		 * c) Declare for loop iterator from 0 to array length 
		 * d) Declare a nested for another array from 0 to array length 
		 * e) Compare Both the arrays using a condition statement
		 * f) Print the first array (should match item in both arrays)
		 */
		int[] array1 = { 3, 2, 11, 4, 6, 7 };
		int[] array2 = { 1, 2, 8, 4, 9, 7 };
		boolean isMatched = false;

		for (int i = 0; i<array1.length; i++) {
			
			for (int j = 0; j<array2.length; j++) {
				
				if (array1[i] == array2[j]) {
					isMatched = true; 
					System.out.println("The first array that matches in the both list is: " + array1[i]);
					break;
				}
				
			}
			if (isMatched == true) { 
				break; //to get all intersection elements do not use isMatched flag
			} 
		}
	}
}
