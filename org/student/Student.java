package org.student;

import org.department.Department;

public class Student extends Department {
	public void studentName() {
		String sName = "Supriya";
				System.out.println("Print students name "+ sName);

	}

	public void studentDept() {
		String sDept = "EEE";
				System.out.println("Print students dept "+ sDept);
	}

	public void studentId() {
		int sID = 4322;
				System.out.println("Print students id "+ sID);
	}

	public static void main(String[] args) {
		Student obj1 = new Student();
		obj1.collegeCode();
		obj1.collegeName();
		obj1.collegeRank();
		obj1.deptName();
		obj1.studentDept();
		obj1.studentId();
		obj1.studentName();

	}

}
