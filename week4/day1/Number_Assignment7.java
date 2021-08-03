package week4.day1;


public class Number_Assignment7 {
	/*
	 * Java Program for practice:  
	 * Assignment 7: 
	 * int[] num = {4,0,3,0,1,5,2,0} 
	 * move all the 0 to the right 
	 * output: 4,3,1,5,2,0,0,0
	 * Taken from: https://www.geeksforgeeks.org/move-zeroes-end-array/
	 */
	 
    static void pushZerosToEnd(int num[], int n)
    {
        int count = 0;  // Count of non-zero elements
  
        for (int i = 0; i < n; i++)
            if (num[i] != 0)
                num[count++] = num[i]; // here count is incremented
        while (count < n)
            num[count++] = 0;
    }
 
    
    public static void main (String[] args)
    {
        int[] num = {4,0,3,0,1,5,2,0};
        int n = num.length;
        pushZerosToEnd(num, n);
        System.out.println("Array after pushing zeros to the back: ");
        for (int i=0; i<n; i++)
            System.out.print(num[i]+" ");
    }
}