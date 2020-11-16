package model;
import java.util.ArrayList;

public class Customer {
	private String custonerName;
	private ArrayList<Book> customerBooks;
	private double money;
	
	public Customer(String name, ArrayList<Book> books, double money)
	{
		this.custonerName = name;
		this.customerBooks = books;
		this.money = money;
	}
	
	public String getCustonerName() {
		return custonerName;
	}
	public void setCustonerName(String custonerName) {
		this.custonerName = custonerName;
	}
	public ArrayList<Book> getCustomerBooks() {
		return customerBooks;
	}
	public void setCustomerBooks(ArrayList<Book> customerBooks) {
		this.customerBooks = customerBooks;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}