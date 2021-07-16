package week1.day1;

public class Factorial {
	/*
	 * Goal: Find the Factorial of a given number
	 * 
	 * input: 5
	 * output: 5*4*3*2*1 = 120
	 */

	public static void main(String[] args) {
		int input = 5;
		int factorial = 1;
		int i=1;
		for(i=1; i<=input; i++) {
			factorial = factorial*i;
			}
		System.out.println("The factorial of input: "+input +" is " +factorial);
	}
}
