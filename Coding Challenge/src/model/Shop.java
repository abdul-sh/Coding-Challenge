package model;
import java.util.ArrayList;

public class Shop {
	private String shopName;
	private ArrayList<Book> books;
	private double saleSum;
	
	public Shop(String name, ArrayList<Book> books, double saleSum)
	{
		this.shopName = name;
		this.books = books;
		this.setSaleSum(saleSum);
		
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public double getSaleSum() {
		return saleSum;
	}

	public void setSaleSum(double saleSum) {
		this.saleSum = saleSum;
	}
}
