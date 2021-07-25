package week3.day1;

public class CharIndex_Assign7a {
	
	/*
	 * Write a Java program to get the character at the given index within the
	 * String. String text = Java Exercise Index for character E and s
	 */
	public static void main(String[] args) {
		String text = "Java Exercise";
		 char[] charArray = text.toCharArray();
		 for (int i = 0; i < charArray.length; i++) {
			//System.out.println("charArray[" + i + "]: " +  charArray[i]);
			
			if(charArray[i] == 'E') {
				System.out.println("The Index of E in text " +text +" is " +i);
			}
			else if(charArray[i] == 's') {
				System.out.println("The Index of s in text " +text +" is " +i);
			}
		}
		
	}

}
