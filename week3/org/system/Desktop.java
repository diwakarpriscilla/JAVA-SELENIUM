package org.system;

public class Desktop extends Computer {

	public void desktopSize() {
		String desktopBrand = "Dell";
		System.out.println("The brand of the desktop is " + desktopBrand);
	}

	public static void main(String[] args) {

		Desktop obj2 = new Desktop();
		obj2.computerModel();
		obj2.desktopSize();

	}

}
