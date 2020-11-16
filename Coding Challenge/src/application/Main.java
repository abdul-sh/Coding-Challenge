package application;

import tests.ControllerTest;

public class Main {

	private static ControllerTest controllerTest;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Here we can start the jUnit Test");
		controllerTest = new ControllerTest();
		controllerTest.setUp();
		controllerTest.saleABookTest();
		controllerTest.setUp();
		controllerTest.showAdvantureBooksTest();
		controllerTest.showBookOnceTest();
		controllerTest.compareTest();
		controllerTest.addBooksToShopTest();
		System.out.println("Thank you for sending the challenge to me and for giving me this opportunity");
	}
}
