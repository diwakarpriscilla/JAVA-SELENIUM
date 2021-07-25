package week3.day1;

public class Students {
	
public void getStudentInfo(){
		int id = 9820;
		String name = "Dhi";
		String email = "dhi@yahoo.com";
		double phoneNumber = 9837287228d;
		System.out.println("Student's id is " + id);
		System.out.println("Student's name is " + name);
		System.out.println("Student's email is " + email);
		System.out.println("Student's phone number is " + phoneNumber);
	}

	public void getStudentInfo(int id){
		System.out.println("Student's id is " + id);
	}

	public void getStudentInfo(int id, String name){
		System.out.println("Student's id is " + id);
		System.out.println("Student's name is " + name);
	}

	public void getStudentInfo(String email, double phoneNumber){
		System.out.println("Student's email is " + email);
		System.out.println("Student's phone number is " + phoneNumber);
}

	public static void main(String[] args) {
		Students info = new Students();
		info.getStudentInfo(23);
		info.getStudentInfo();
		

	}

}
