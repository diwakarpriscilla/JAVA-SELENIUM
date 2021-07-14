package week1.day1;

public class PrimeNumber {
	
	//Goal: To find Prime Number

	public static void main(String[] args) {

		int num = 17; // Declare an Input and assign a value
		int a = num / 2; // Get half of the input

		boolean primeFlag = false; // Declare a boolean variable flag as false
		System.out.println(primeFlag);

		// Iterate from 2 to half of the input
		for (int j = 2; j <= a; j++) {

			int b = num % j; // Divide the input with each for loop variable and check the remainder
			if (b == 0) {
				primeFlag = true;
				System.out.println("Flag is set to true");// Set the primeFlag as true when there is no remainder
				break; // break the iterator if the remainder is 0
			}

		}
		// Check the primeFlag and print Prime or Not Prime 
		if (primeFlag == true) {
			System.out.println(num + " is NOT Prime Number");
		}

		else {
			System.out.println(num + " is Prime Number");

		}

	}

}