package BookReader;
import java.util.*;


public class Library {
	
	private HashMap<Integer,Book> books;
	
	
	 public Library() 
	    { 
	        books = new HashMap<Integer, Book>(); 
	    } 
	  
	
	
	public boolean AddBook(int id, String name,String detail) {
		
		if(!books.containsKey(id)) {
			books.put(id,new Book(id,name,detail));
			return true;
		}
		return false;
	}
	
	public boolean RemoveBook(int id) {
		books.remove(id);
		return true;
	}
	
	public Book Find(int id) {
		
		if(books.containsKey(id)) {
			return books.get(id);
		}
		return null;
		
		
	}

}
