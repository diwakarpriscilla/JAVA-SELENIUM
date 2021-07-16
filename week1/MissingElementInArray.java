package week1.day2;

import java.util.Arrays;

public class MissingElementInArray {

	public static void main(String[] args) {

		// Here is the input
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };

		// Sort the array
		Arrays.sort(arr);

		// find length of array
		int length = arr.length;

		// loop through the array (start i from arr[0] till the length of the array)
		// check if the iterator variable is not equal to the array values respectively
		int i;

		for (i = 0; i <= length; i++) {

			if (arr[i] != i+1) {
				int a = i+1 ;
				System.out.println("The missing array is " + a); // print the number
				break; // once printed break the iteration
			}
		}

	}

}
