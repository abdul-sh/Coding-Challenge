package controller;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.stream.Collectors;
import enums.Genre;
import model.Book;
import model.Customer;
import model.Shop;

public class MainController {
	
	/**
	 * Constructor of the mainController which has all the methods.
	 */
	public MainController()
	{
		
	}
	
	/**
	 * This is the method for"Verkauf eines bestimmten Buches von einem Shop an einen Kunden".
	 * @param book, which the customer want to buy.
	 * @param customer: is the customer who want to buy the book.
	 * @param shop, which received the customer.
	 */
	public void saleABook(Book book, Customer customer, Shop shop) throws Exception
	{
		if(book == null || customer == null || shop == null)
		{
			throw new NullPointerException();
		}
		else
		{
			if(customer.getMoney() >= book.getPreis())
			{
				if(bookIsFound(shop.getBooks(), book))
				{
					shop.setBooks(removeBook(shop.getBooks(), book));
					customer.setMoney(customer.getMoney() - book.getPreis());
					ArrayList<Book> customerBooks = customer.getCustomerBooks();
					customerBooks.add(book);
					customer.setCustomerBooks(customerBooks);
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					String s = df.format(shop.getSaleSum() + book.getPreis());
					shop.setSaleSum(Double.valueOf(s));
				}
				else {System.out.println(book.getTitle() + " is not avilable in this shop: " + shop.getShopName());}
			}
			else {System.out.println( customer.getCustonerName() +" has no enough money");}
		}
	}
	
	/**
	 * a private method to reomve a book from a list of books. 
	 * @param books: the list of books to remove from.
	 * @param book: the book to be removed.
	 * @return the list of books after removing the book.
	 */
	private ArrayList<Book> removeBook(ArrayList<Book> books, Book book) throws Exception
	{
			ArrayList<Book> newAllBooks = new ArrayList<>();
			boolean removed = false;
			for(Book currentBook : books)
			{
				if(currentBook.equals(book) && !removed)
				{
					removed = true;
					continue;
				}
				newAllBooks.add(currentBook);
			}
			return newAllBooks;
	}
	
	/**
	 * private method to search for a book in a list of books.
	 * @param books: the list of books to search in.
	 * @param book: the book to search for.
	 * @return true, when the list of books does have the book, which is being searched for. 
	 */
	private boolean bookIsFound(ArrayList<Book> books, Book book) 
	{
		return books.stream()
			 .anyMatch(c -> c.equals(book));
	}
	
	/**
	 * This is the method for "Filtern von Büchern".
	 * @param shop, which is given to look in it for the advanture books.
	 * @return books that have the genre Advanture from the shop.
	 */
	public ArrayList<Book> showAdvantureBooks(Shop shop) throws Exception
	{
		if(shop == null)
		{
			throw new NullPointerException();
		}
		else
		{
			ArrayList<Book> allBooks = showBooksOnce(shop);		
			return (ArrayList<Book>) allBooks
					  .stream()
					  .filter(c -> c.getGenre().equals(Genre.ADVENTURE))
					  .collect(Collectors.toList());
		}
		
	}
	
	/**
	 *  This is the method for "Entfernen von Duplikaten".
	 * @param shop, which is given to show all its books distinctly. 
	 * @return all books in the shop without duplications.
	 */
	public ArrayList<Book> showBooksOnce(Shop shop) throws Exception
	{
		if(shop == null)
		{
			throw new NullPointerException();
		}
		else
		{
			ArrayList<Book> allBooks = shop.getBooks();
			return (ArrayList<Book>) allBooks
											.stream()
											.distinct()
											.collect(Collectors.toList());
		}
	}
	
	
	/**
	 * This is the method for "Vergleich".
	 * @param firstShop is the first shop to compare.
	 * @param secondShop is the second shop to compare.
	 * @return true if the first shop has exact the same books as the second shop.
	 */
	public boolean compare(Shop firstShop, Shop secondShop) throws Exception
	{
		if(firstShop == null || secondShop == null)
		{
			throw new NullPointerException();
		}
		else
		{
			ArrayList<Book> firstBooks = showBooksOnce(firstShop);
			ArrayList<Book> secondBooks = showBooksOnce(secondShop);
			if(firstBooks.size() == secondBooks.size())
			{
				for(Book firstBook : firstBooks)
				{
					if(secondBooks.stream().anyMatch(c -> c.equals(firstBook)) == false)
					{
						return false;
					}
				}
				return true;
			}
			return false;
		}
	}

	
	/**
	 * This is the method for "Bücher hinzufügen".
	 * @param books, that should be added to the shop
	 * @param shop to add books to it. 
	 * @return the shop after adding the new books. 
	 */
	public Shop addBooksToShop(ArrayList<Book> books, Shop shop) throws Exception
	{
		if(books == null || shop == null)
		{
			throw new NullPointerException();
		}
		else
		{
			ArrayList<Book> allBooks = shop.getBooks();
			allBooks.addAll(books.stream()
								 .filter(c -> isValidISBN(c))
								 .collect(Collectors.toList()));
			shop.setBooks(allBooks);
			return shop;
		}
	}
	
	/**
	 *  private method to check whether the ISBN of a book valid or not.
	 * @param book, which its ISBN will be checked. 
	 * @return true, when the ISBN valid.
	 */
	private boolean isValidISBN(Book book)
	{
		int[] iSBN = book.getiSBN();
		int oneCount = 0;
		int threeCount = 0;
		int count = 0;
		if(iSBN.length == 13 && iSBN[0] == 9 && iSBN[1] == 7 &&
				(iSBN[2] == 8|| iSBN[2] == 9))
		{
			for(int index = 0; index < iSBN.length; index++)
			{
				if(index % 2 == 0)
				{
					oneCount = oneCount + iSBN[index];
				}
				else
				{
					threeCount = threeCount + (iSBN[index] * 3);
				}
			}
			count = oneCount + threeCount;
			if(count % 10 == 0)
			{
				return true;
			}
		}
		return false;
	}
}