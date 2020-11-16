package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.MainController;
import enums.Genre;
import model.Book;
import model.Customer;
import model.Shop;

public class ControllerTest {
	
	private MainController mainController;
	private TestEnvironment testEnvironment;

	
		/**
		 * the setup method, which will create the testEnvironment before each test. 
		 * The testEnvironment will have 10 books. 5 of them are valid and can be found in shops. 
		 * The testEnvironment also has 3 customers and 8 shops. 
		 * @throws Exception
		 */
		@Before
		public void setUp() throws Exception {
			// Books
			int[] book1ISBN = {9,7,8,3,6,0,8,9,6,3,7,6,2}; //978-3608963762
			Book book1 = new Book("book1", 25.0, 300, Genre.BIOGRAPHY, book1ISBN);
			int[] book2ISBN = {9,7,8,3,2,4,2,2,4,7,7,4,7}; //978-3242247747
			Book book2 = new Book("book2", 20.50, 200, Genre.COMIC, book2ISBN);
			int[] book3ISBN = {9,7,8,3,7,5,8,2,7,5,1,5,9}; //978-3758275159
			Book book3 = new Book("book3", 50.0, 1300, Genre.FANTASY, book3ISBN);
			int[] book4ISBN = {9,7,8,3,8,4,1,3,3,5,1,8,0}; //978-3841335180
			Book book4 = new Book("book4", 15.99, 100, Genre.ADVENTURE, book4ISBN);
			int[] book5ISBN = {9,7,8,3,6,4,2,2,6,7,8,1,9}; //978-3642267819
			Book book5 = new Book("book5", 33.20, 550, Genre.ADVENTURE, book5ISBN);
			int[] book6ISBN = {9,7,8,3,4,4,2,2,6,7,7,4,7}; //978-3442267747
			Book book6 = new Book("book6", 24.50, 175, Genre.COMIC, book6ISBN);
			int[] book7ISBN = {9,7,2,3,7,5,8,2,4,5,1,5,9}; //972-3758245159
			Book book7 = new Book("book7", 60.0, 1000, Genre.FANTASY, book7ISBN);
			int[] book8ISBN = {9,1,8,3,4,4,2,2,6,7,8,1,9}; //918-3442267819
			Book book8 = new Book("book8", 35.0, 270, Genre.ADVENTURE, book8ISBN);
			int[] book9ISBN = {9,7,9,7,5,8,2,4,5,1,5,9}; //979-758245159
			Book book9 = new Book("book9", 60.0, 1000, Genre.FANTASY, book9ISBN);
			int[] book10ISBN = {2,7,8,3,4,4,2,2,6,7,8,1,9}; //278-3442267819
			Book book10 = new Book("book10", 35.0, 270, Genre.ADVENTURE, book10ISBN);
			
			//shops
			ArrayList<Book> shop1Books = new ArrayList<>();
			shop1Books.add(book1);
			shop1Books.add(book2);
			double sales1 = 131.6;
			Shop shop1 = new Shop("Shop1", shop1Books , sales1);
			
			ArrayList<Book> shop2Books = new ArrayList<>();
			shop2Books.add(book3);
			shop2Books.add(book4);
			shop2Books.add(book5);
			double sales2 = 273.67;
			Shop shop2 = new Shop("Shop2", shop2Books , sales2);
			
			ArrayList<Book> shop3Books = new ArrayList<>();
			shop3Books.add(book1);
			shop3Books.add(book2);
			shop3Books.add(book3);
			shop3Books.add(book4);
			shop3Books.add(book5);
			double sales3 = 493.43;
			Shop shop3 = new Shop("Shop3", shop3Books , sales3);
			
			ArrayList<Book> shop4Books = new ArrayList<>();
			double sales4 = 0;
			Shop shop4 = new Shop("Shop4", shop4Books , sales4);
			
			ArrayList<Book> shop5Books = new ArrayList<>();
			shop5Books.add(book3);
			shop5Books.add(book4);
			shop5Books.add(book5);
			double sales5 = 453.32;
			Shop shop5 = new Shop("Shop5", shop5Books , sales5);
			
			ArrayList<Book> shop6Books = new ArrayList<>();
			shop6Books.add(book3);
			shop6Books.add(book2);
			shop6Books.add(book5);
			double sales6 = 183.09;
			Shop shop6 = new Shop("Shop6", shop6Books , sales6);
			
			ArrayList<Book> shop7Books = new ArrayList<>();
			shop7Books.add(book1);
			shop7Books.add(book1);
			shop7Books.add(book1);
			shop7Books.add(book2);
			shop7Books.add(book5);
			shop7Books.add(book2);
			shop7Books.add(book2);
			shop7Books.add(book4);
			shop7Books.add(book5);
			shop7Books.add(book2);
			double sales7 = 593.52;
			Shop shop7 = new Shop("Shop7", shop7Books , sales7);
			
			ArrayList<Book> shop8Books = new ArrayList<>();
			shop8Books.add(book5);
			double sales8 = 755.02;
			Shop shop8 = new Shop("Shop8", shop8Books , sales8);
			
			// Customers
			ArrayList<Book> customer1Books = new ArrayList<>();
			customer1Books.add(book1);
			customer1Books.add(book4);
			Customer customer1 = new Customer("Customer1", customer1Books, 30.28);
			
			ArrayList<Book> customer2Books = new ArrayList<>();
			customer2Books.add(book2);
			customer2Books.add(book5);
			customer2Books.add(book1);
			Customer customer2 = new Customer("Customer2", customer2Books, 50.39);
			
			ArrayList<Book> customer3Books = new ArrayList<>();
			customer3Books.add(book10);
			Customer customer3 = new Customer("Customer3", customer3Books, 126.73);
			
			mainController = new MainController();
			ArrayList<Shop> shops = new ArrayList<>();
			shops.add(shop1);
			shops.add(shop2);
			shops.add(shop3);
			shops.add(shop4);
			shops.add(shop5);
			shops.add(shop6);
			shops.add(shop7);
			shops.add(shop8);
			ArrayList<Customer> customers = new ArrayList<>();
			customers.add(customer1);
			customers.add(customer2);
			customers.add(customer3);
			ArrayList<Book> books = new ArrayList<>();
			books.add(book1);
			books.add(book2);
			books.add(book3);
			books.add(book4);
			books.add(book5);
			books.add(book6);
			books.add(book7);
			books.add(book8);
			books.add(book9);
			books.add(book10);
			testEnvironment = new TestEnvironment(shops,books,customers);
		}	
		
		/**
		 * the constructor for the test. 
		 */
		public ControllerTest() {
			
		}
		
		/**
		 * Test for "Filter von Büchern". 
		 * @throws Exception 
		 */
		@Test
		public void showAdvantureBooksTest() throws Exception
		{
			System.out.println("");
			System.out.println("-> Test for the (showAdvantureBooks) method:");
			Shop shop1 = testEnvironment.getShops().get(0);			
			Shop shop2 = testEnvironment.getShops().get(1);
			Shop shop6 = testEnvironment.getShops().get(5);
			Shop shop7 = testEnvironment.getShops().get(6);
			System.out.println("Shop1 has the following books genre:");
			shop1.getBooks().stream().forEach(c -> System.out.print(c.getGenre() + ","));
			System.out.println("");
			System.out.println("Shop2 has the following books genre:");
			shop2.getBooks().stream().forEach(c -> System.out.print(c.getGenre() + ","));
			System.out.println("");
			System.out.println("Shop6 has the following books genre:");
			shop6.getBooks().stream().forEach(c -> System.out.print(c.getGenre() + ","));
			System.out.println("");
			System.out.println("Shop7 has the following books genre:");
			shop7.getBooks().stream().forEach(c -> System.out.print(c.getGenre() + ","));
			System.out.println("");
			
			System.out.println("After applaying the method (showAdvantureBooks), here are the results: ");
			ArrayList<Book> result1 = mainController.showAdvantureBooks(shop1);
			ArrayList<Book> result2 = mainController.showAdvantureBooks(shop2);
			ArrayList<Book> result3 = mainController.showAdvantureBooks(shop6);
			ArrayList<Book> result4 = mainController.showAdvantureBooks(shop7);
			System.out.println("Shop1 shows the following books genre:");
			result1.stream().forEach(c -> System.out.print(c.getGenre() + ","));
			System.out.println("");
			System.out.println("Shop2 shows the following books genre:");
			result2.stream().forEach(c -> System.out.print(c.getGenre() + ","));
			System.out.println("");
			System.out.println("Shop6 shows the following books genre:");
			result3.stream().forEach(c -> System.out.print(c.getGenre() + ","));
			System.out.println("");
			System.out.println("Shop7 shows the following books genre:");
			result4.stream().forEach(c -> System.out.print(c.getGenre() + ","));
			System.out.println("");
			System.out.println("Notice that shop7 had two books of book5 before the apply and showed us "
					+ "just two Advanture books after applying and that is because it shows"
					+ " Advanture books distinctly");
			System.out.println("::::::::::::::::");
			
			assertEquals(0,result1.size());
			assertEquals(2,result2.size());
			assertEquals(1,result3.size());
			assertEquals(2,result4.size());
			
			assertEquals(result2.get(0).getTitle() , "book4");
			assertEquals(result2.get(1).getTitle() , "book5");
			assertEquals(result3.get(0).getTitle() , "book5");
			assertEquals(result4.get(1).getTitle() , "book4");
			assertEquals(result4.get(0).getTitle() , "book5");
			
			assertThrows(NullPointerException.class,() -> mainController.showAdvantureBooks(null));
		}

		/**
		 * Test for "Bücher hinzufügen".
		 * @throws Exception 
		 */
		@Test
		public void addBooksToShopTest() throws Exception
		{
			System.out.println("");
			System.out.println("-> Test for the (addBooksToShop) method:");
			Shop shop4 = testEnvironment.getShops().get(3);
			System.out.println("Shop4 has no books: ");
			shop4.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			
			System.out.println("The books will be given to add to shop4 are: ");
			testEnvironment.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("After applaying the method (addBooksToShop), here are the books in Shop4: ");
			Shop newShop4 = mainController.addBooksToShop(testEnvironment.getBooks(), shop4);
			shop4.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Notice that just the added books had valid ISBN");
			System.out.println("The ISBN for all books are: ");
			System.out.println("book1: 978-3608963762");
			System.out.println("book2: 978-3242247747");
			System.out.println("book3: 978-3758275159");
			System.out.println("book4: 978-3841335180");
			System.out.println("book5: 978-3642267819");
			System.out.println("book6: 978-3442267747");
			System.out.println("book7: 972-3758245159");
			System.out.println("book8: 918-3442267819");
			System.out.println("book9: 979-758245159");
			System.out.println("book10: 278-3442267819");
			System.out.println("You can check it yourself again");
			System.out.println("::::::::::::::::");
			
			assertEquals(5,newShop4.getBooks().size());
			assertEquals(newShop4.getBooks().get(0), testEnvironment.getBooks().get(0));
			assertEquals(newShop4.getBooks().get(1), testEnvironment.getBooks().get(1));
			assertEquals(newShop4.getBooks().get(2), testEnvironment.getBooks().get(2));
			assertEquals(newShop4.getBooks().get(3), testEnvironment.getBooks().get(3));
			assertEquals(newShop4.getBooks().get(4), testEnvironment.getBooks().get(4));
			
			assertThrows(NullPointerException.class,() -> mainController.addBooksToShop(null, null));
			assertThrows(NullPointerException.class,() -> mainController.addBooksToShop(null, shop4));
			assertThrows(NullPointerException.class,() -> mainController.addBooksToShop(shop4.getBooks(), null));
		}
		
		/**
		 * Test for "Vergleich".
		 * @throws Exception 
		 */
		@Test
		public void compareTest() throws Exception
		{
			System.out.println("");
			System.out.println("->Test for the (compare) method");
			Shop shop2 = testEnvironment.getShops().get(1);
			Shop shop5 = testEnvironment.getShops().get(4);
			Shop shop3 = testEnvironment.getShops().get(2);
			Shop shop6 = testEnvironment.getShops().get(5);
			System.out.println("Here are the books in " + shop2.getShopName());
			shop2.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the books in " + shop5.getShopName());
			shop5.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the books in " + shop3.getShopName());
			shop3.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the books in " + shop6.getShopName());
			shop6.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			
			System.out.println("After applaying the method (compare), here are the books results: ");
			System.out.println("Comparing shop2 and shop5: ");
			boolean result1 = mainController.compare(shop2, shop5);
			System.out.println(result1);
			System.out.println("Comparing shop2 and shop3: ");
			boolean result2 = mainController.compare(shop2, shop3);
			System.out.println(result2);
			System.out.println("Comparing shop2 and shop6: ");
			boolean result3 = mainController.compare(shop2, shop6);
			System.out.println(result3);
			System.out.println("::::::::::::::::");
			
//			mainController.compare(null, null);
//			mainController.compare(shop3, null);
//			mainController.compare(null, shop3);

			assertTrue(result1);
			assertFalse(result2);
			assertFalse(result3);
			
			assertThrows(NullPointerException.class,() -> mainController.compare(null, null));
			assertThrows(NullPointerException.class,() -> mainController.compare(shop3, null));
			assertThrows(NullPointerException.class,() -> mainController.compare(null, shop3));
		}
		
		/**
		 * Test for "Entfernen von Duplikaten".
		 * @throws Exception 
		 */
		@Test
		public void showBookOnceTest() throws Exception
		{
			System.out.println("");
			System.out.println("-> Test for the (showBookOnce) method");
			Shop shop7 = testEnvironment.getShops().get(6);
			System.out.println("Here are all the books from " + shop7.getShopName() + ":");
			shop7.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			
			System.out.println("After applaying the method (showBookOnce), this is the result: ");
			ArrayList<Book> shop7OnceBooks = mainController.showBooksOnce(shop7);
			shop7OnceBooks.stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("::::::::::::::::");
			
			assertEquals(4, shop7OnceBooks.size());
			
			assertThrows(NullPointerException.class,() -> mainController.showBooksOnce(null));
		}
		
		
		/**
		 * Test for "Verkauf eines bestimmten Buches von einem Shop an einen Kunden".
		 * @throws Exception 
		 */
		@Test 
		public void saleABookTest() throws Exception 
		{
			System.out.println("");
			System.out.println("-> Test for the (saleABook) method");
			Shop shop3 = testEnvironment.getShops().get(2); // has book3 once.
			Shop shop7 = testEnvironment.getShops().get(6); // has book5 several times.
			System.out.println("Here are all the books from " + shop3.getShopName() + ":");
			shop3.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the sales from " + shop3.getShopName() + ":");
			System.out.println(shop3.getSaleSum());
			
			System.out.println("Here are all the books from " + shop7.getShopName() + ":");
			shop7.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the sales from " + shop7.getShopName() + ":");
			System.out.println(shop7.getSaleSum());
			
			Book book3 = testEnvironment.getBooks().get(2);
			Book book5 = testEnvironment.getBooks().get(4);
			System.out.println("Here is the price of " + book3.getTitle() + " :" + book3.getPreis());
			System.out.println("Here is the price of " + book5.getTitle() + " :" + book5.getPreis());
			
			Customer customer1 = testEnvironment.getCustomers().get(0); // does not have book3.
			Customer customer3 = testEnvironment.getCustomers().get(2); // does not have book3 and book5.
			Customer customer2 = testEnvironment.getCustomers().get(1);	// does not have book3. 
			System.out.println("Here are all the books from " + customer1.getCustonerName() + ":");
			customer1.getCustomerBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here is the money of " + customer1.getCustonerName() + " :" + customer1.getMoney());
			System.out.println("Here are all the books from " + customer2.getCustonerName() + ":");
			customer2.getCustomerBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here is the money of " + customer2.getCustonerName() + " :" + customer2.getMoney());
			System.out.println("Here are all the books from " + customer3.getCustonerName() + ":");
			customer3.getCustomerBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here is the money of " + customer3.getCustonerName() + " :" + customer3.getMoney());
			
			System.out.println("After applaying the method (saleABook) with " + customer1.getCustonerName() + " ,"
					+  book3.getTitle() + " and " + shop3.getShopName() + ", this is the result: ");
			mainController.saleABook(book3, customer1, shop3); // customer1 does not have enough money to buy book3.
			assertTrue(shop3.getBooks().contains(book3)); // the shop still has book3. 
			assertFalse(customer1.getCustomerBooks().contains(book3)); //Customer1 could not buy book3.
			assertTrue(shop3.getSaleSum() == 493.43); // sales of shop3 still the same.
			System.out.println("Here are all the books from " + customer1.getCustonerName() + " after applying:");
			customer1.getCustomerBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here is the money of " + customer1.getCustonerName() + " after applying:"
					+ customer1.getMoney());
			System.out.println("Here are all the books from " + shop3.getShopName() + " after applying:");
			shop3.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the sales from " + shop3.getShopName() + " after applying:");
			System.out.println(shop3.getSaleSum());
			
			System.out.println("After applaying the method (saleABook) with " + customer3.getCustonerName() + " ,"
					+  book3.getTitle() + " and " + shop3.getShopName() + ", this is the result: ");
			mainController.saleABook(book3, customer3, shop3); //customer3 does have enough money to buy book3.
			assertFalse(shop3.getBooks().contains(book3)); // the shop does not have book3 anymore.
			assertTrue(customer3.getCustomerBooks().contains(book3)); // customer3 bought book3.
			assertTrue(shop3.getSaleSum() == 543.43); 
			assertTrue(shop3.getBooks().size() == 4); //lists are actualized.
			System.out.println("Here are all the books from " + customer3.getCustonerName() + " after applying:");
			customer3.getCustomerBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here is the money of " + customer3.getCustonerName() + " after applying:"
					+ customer3.getMoney());
			System.out.println("Here are all the books from " + shop3.getShopName() + " after applying:");
			shop3.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the sales from " + shop3.getShopName() + " after applying:");
			System.out.println(shop3.getSaleSum());
			
			System.out.println("After applaying the method (saleABook) with " + customer2.getCustonerName() + ", "
					+  book3.getTitle() + " and " + shop3.getShopName() + ", this is the result: ");
			mainController.saleABook(book3, customer2, shop3); // customer2 has enough money to buy book3.
			assertFalse(shop3.getBooks().contains(book3)); // shop3 does not have book3 anymore.
			System.out.println("Here are all the books from " + customer2.getCustonerName() + " after applying:");
			customer2.getCustomerBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here is the money of " + customer2.getCustonerName() + " after applying:"
					+ customer2.getMoney());
			System.out.println("Here are all the books from " + shop3.getShopName() + " after applying:");
			shop3.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the sales from " + shop3.getShopName() + " after applying:");
			System.out.println(shop3.getSaleSum());
			
			System.out.println("After applaying the method (saleABook) with " + customer3.getCustonerName() + ", "
					+  book5.getTitle() + " and " + shop7.getShopName() + ", this is the result: ");
			mainController.saleABook(book5, customer3, shop7); // customer3 has enough money to buy book5.
			assertTrue(customer3.getCustomerBooks().contains(book5)); // customer3 bought book5.
			assertTrue(shop7.getBooks().contains(book5)); // shop7 has other copies of book5.
			assertTrue(shop7.getSaleSum() == 626.72); 
			assertTrue(shop7.getBooks().size() == 9); //lists are actualized. 
			System.out.println("Here are all the books from " + customer3.getCustonerName() + " after applying:");
			customer3.getCustomerBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here is the money of " + customer3.getCustonerName() + " after applying:"
					+ customer3.getMoney());
			System.out.println("Here are all the books from " + shop7.getShopName() + " after applying:");
			shop7.getBooks().stream().forEach(c -> System.out.print(c.getTitle() + ","));
			System.out.println("");
			System.out.println("Here are the sales from " + shop7.getShopName() + " after applying:");
			System.out.println(shop7.getSaleSum());
			System.out.println("::::::::::::::::");
			
			assertThrows(NullPointerException.class,() -> mainController.saleABook(null, null, null));
			assertThrows(NullPointerException.class,() -> mainController.saleABook(book3, null, null));
			assertThrows(NullPointerException.class,() -> mainController.saleABook(null, customer3, null));
			assertThrows(NullPointerException.class,() -> mainController.saleABook(null, null, shop3));
			assertThrows(NullPointerException.class,() -> mainController.saleABook(book3, customer3, null));
			assertThrows(NullPointerException.class,() -> mainController.saleABook(null, customer3, shop3));
			assertThrows(NullPointerException.class,() -> mainController.saleABook(book3, null, shop3));
		}
}
