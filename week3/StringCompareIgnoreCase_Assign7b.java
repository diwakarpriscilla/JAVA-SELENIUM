package week3.day1;

public class StringCompareIgnoreCase_Assign7b {
	/*
	 * String 1="I am Learning Java" String 2="I am learning java? Explore with ==
	 * operator equals equalsignorecase
	 */

	public static void main(String[] args) {

		String text1 = "I am Learning Java";
		String text2 = "I am learning java";

		if(text1 == text2) {
			System.out.println("Using ==, The strings are equal ");
			System.out.println("The == operator compares references not values");
		}

		else if (text1.equals(text2)) {
			System.out.println("Using .equals, The strings are equal");
			System.out.println("The String class equals() method compares the original content of the string. It compares values of string for equality.");
		}

		else if (text1.equalsIgnoreCase(text2)) {
			System.out.println("Using .equalsIgnoreCase, The strings are equal");
			System.out.println("Decision is based on content of the text irrespective of cases");
		}

		else {
			System.out.println("The strings are not Equal");
		}

	}
}
