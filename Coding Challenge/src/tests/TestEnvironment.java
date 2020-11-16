package tests;

import java.util.ArrayList;

import model.Book;
import model.Customer;
import model.Shop;

public class TestEnvironment {

	private ArrayList<Shop> shops;
	private ArrayList<Book> books;
	private ArrayList<Customer> customers;
	
	public TestEnvironment(ArrayList<Shop> shops, ArrayList<Book> books,
			ArrayList<Customer> customers)
	{
		this.setShops(shops);
		this.setBooks(books);
		this.setCustomers(customers);
	}

	public ArrayList<Shop> getShops() {
		return shops;
	}

	public void setShops(ArrayList<Shop> shops) {
		this.shops = shops;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
}
