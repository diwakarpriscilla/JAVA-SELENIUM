package week1.day1;

public class FibonacciSeries {

	// Goal: To find Fibonacci Series for a given range

	public static void main(String[] args) {
		
		// initialize 3 int variables (Tip: range = 8, firstNum = 0, secNum = 1, sum in the series)

		int range = 8;
		int firstNum = 0;
		int secNum = 1;
		int sum = 0;

		// Print first number
		System.out.println(firstNum);
		// Print second number
		System.out.println(secNum);

		// Iterate from 1 to the range
		for (int i = 1; i < range; i++) {
			sum = firstNum + secNum; // add first and second number assign to sum
			firstNum = secNum; // Assign second number to the first number
			secNum = sum; // Assign sum to the second number
			System.out.println(sum); // print sum

		}

	}

}
