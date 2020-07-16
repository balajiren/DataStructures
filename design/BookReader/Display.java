package BookReader;

public class Display {

	 private Book activeBook; 
	 private User activeUser; 
	 private int pageNumber = 0; 
	 
	 
	 public void displayUser() {
		 
		 
	 }
	 
	 public void displayBook(Book _book) {
		 this.activeBook = _book;
		 
	 }
	 
	 public void turnPageForward() {
		 pageNumber++;
	 }
	 

	 public void turnPageBackward() {
		 pageNumber--;
	 }
	 
	 public void refreshUsername() 
	    { 
	        /* updates username display */
	        System.out.println("User name " + activeUser.getName() +  
	                                             " is refreshed"); 
	    } 
	 
	 public void refreshTitle() 
	    { 
	        /* updates title display */
	        System.out.println("Title of the book " + 
	                        activeBook.getTitle() + " refreshed"); 
	    } 
	  
	    public void refreshDetails() 
	    { 
	        /* updates details display */
	        System.out.println("Details of the book " + 
	                        activeBook.getTitle() + " refreshed"); 
	    } 
	  
	    public void refreshPage() 
	    { 
	        /* updated page display */
	        System.out.println("Page no " + pageNumber + " refreshed"); 
	    } 
	 

}
