package week1.day2;

public class Palindrome {
	/*- Store the original string in one variable, say str1
	  - Store the reversed in another variable, str2
	  -use if statement to see if  str1.equals(str2)
	  - If it equals then type as palindrome.
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "malayalam";
		String text2 = "";
		char[] charArray = text1.toCharArray();

		for (int i = charArray.length - 1; i >= 0; i--) {
			// System.out.println("charArray[" + i + "]: " + charArray[i]);
			text2 = text2 + charArray[i];
		}

		System.out.println("Given Text is : " + text1);
		System.out.println("Reversed Text is : " + text2);

		if (text1.equals(text2)) {
			System.out.println("The Given text is Palindrome");
		}

	}
}
