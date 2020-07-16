package URLShorterner;
import java.util.*; 


/*
 * Insert
Insertion:
1. Calculate the hash value of the id of the long URL
2. Locate the server by the hash value and store the id and longURL there.
3. Calculate the short URL based on base conversion and return.
Query (redirect):
1. Calculate the id of the short URL by base conversion algorithm.
2. Locate the server by the hashing the id.
3. find the long URL and redirect.
 * 
 */

public class Main {

    static String strmap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static char[] map = strmap.toCharArray();
              
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	public static String idToShortURL(int n)
	{
	    // Map to store 62 possible characters

	 
	    String shorturl;
	    StringBuilder sb = new StringBuilder();
	 
	    // Convert given integer id to a base 62 number
	    while (n > 0)
	    {
	        // use above map to store actual character
	        // in short url
	    	sb.append(map[n%62]);
	        n = n/62;
	    }
	 
	    // Reverse shortURL to complete base conversion
	    shorturl = sb.reverse().toString();
	 
	    return shorturl;
	}
	 
	// Function to get integer ID back from a short url
	long  shortURLtoID(String strshortURL)
	{
	    long  id = 0; // initialize result
	    char[] shortURL = strshortURL.toCharArray();
	 
	    // A simple base conversion logic
	    for (int i=0; i < shortURL.length; i++)
	    {
	        if ('a' <= shortURL[i] && shortURL[i] <= 'z')
	          id = id*62 + shortURL[i] - 'a';
	        if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
	          id = id*62 + shortURL[i] - 'A' + 26;
	        if ('0' <= shortURL[i] && shortURL[i] <= '9')
	          id = id*62 + shortURL[i] - '0' + 52;
	    }
	    return id;
	}
	
	//id % base , id/=base
	 public static String shorturl_1(int id, int base, HashMap map) {
		  StringBuilder res = new StringBuilder();
		  while (id > 0) {
		    int digit = id % base;
		    res.append(map.get(digit));
		    id /= base;
		  }
		  while (res.length() < 6)  res.append('0');
		  return res.reverse().toString();
		}
	 
	public String CreateUrl(String longUrl)
	{
		return null;
		
	}
	
	public String GetUrl(String longUrl)
	{
		return null;
		
	}

}
