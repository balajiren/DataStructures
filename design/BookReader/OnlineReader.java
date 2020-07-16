package BookReader;

public class OnlineReader {
	
	private Library library;
	private User user;
	private Book activeBook;
	private Display display;
	private UserManager userManager;
	
	OnlineReader(Library _library, Book _activeBook) {
		
	}
	public Library getLibrary() 
    { 
        return library; 
    } 
  
    public UserManager getUserManager() 
    { 
        return userManager; 
    } 
  
    public Display getDisplay() 
    { 
        return display; 
    } 
  
    public Book getActiveBook() 
    { 
        return activeBook; 
    } 
    
    public void SetActiveBook(Book _book) {
    	this.activeBook = _book;
    }
    
    
}
