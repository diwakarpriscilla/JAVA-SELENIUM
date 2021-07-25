package week3.day1;

public class StringComp_Assign5 {

	public static void main(String[] args) {
        String str3 = new String("Kutty");
		 String str4 = new String("Kutty");
		 
		 if(str3==str4) {
			 System.out.println(" Same text");
		 }
		 else
			 System.out.println("Diff text");
		 
		 System.out.println("*****");

	}

}
/*
 * Justify the above output: As the referenced memory address is different
 * , it is displays Diff text
 */