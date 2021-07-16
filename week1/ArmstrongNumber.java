package week1.day1;

public class ArmstrongNumber {
	
	/*
	 * Goal: To find whether a number is an Armstrong number or not
	 * 
	 * inputs: 153
	 * output: (1*1*1)+(5*5*5)+(3*3*3) = 153
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//separate the digits using modulo, 2.Find cube 3.Add cubes
		
		int inputNumber = 153;
		int result1 = 0; 
		int sum1 = 0; 
		int result2 = inputNumber;

		
		while(inputNumber>0) {
			int a = inputNumber %10;  //3----5 ---1
			inputNumber = inputNumber/10; //15---1
			sum1 = a*a*a; //27---125 ---1
			result1 = result1 + sum1 ; //27 ----+125 ---+1
		}
		
		System.out.println("Sum of the cubes is : "+ result1);
		
		if(result1 ==result2)
		{
			System.out.println("The number is an Armstrong Number");
		}
		else {
			System.out.println("The number is not an Armstrong Number");
		}
		

	}

}
