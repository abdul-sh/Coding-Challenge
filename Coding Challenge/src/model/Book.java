package model;
import enums.Genre;

public class Book {
	private String title;
	private double price;
	private int numOfPages;
	private Genre genre;
	private int[] iSBN;
	
	public Book(String title, double price, int numOfPages, Genre genre, int[] iSBN)
	{
		this.title = title;
		this.price = price;
		this.numOfPages = numOfPages;
		this.genre = genre;
		this.iSBN = iSBN;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPreis() {
		return price;
	}
	public void setPreis(double price) {
		this.price = price;
	}
	public int getSeitenZahl() {
		return numOfPages;
	}
	public void setSeitenZahl(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int[] getiSBN() {
		return iSBN;
	}

	public void setiSBN(int[] iSBN) {
		this.iSBN = iSBN;
	}
	
}
