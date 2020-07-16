package Hashing;
import java.util.*;

public class EncodeDecodeTinyUrl {

	static Map<Integer, String> map = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encoded = encode("http://balaji.com");
		System.out.print(encoded);
		System.out.print(decode(encoded));

	}
	 
	
	//Iterate over chars and get ASCII
	// Calc the hash value by hashcode%256
	
	public static String encode(String longUrl) {
		
		map.put(longUrl.hashCode(), longUrl);
		return "http://tinyurl.com/" + longUrl.hashCode();
		
		
	}
	
	public static String decode(String shortUrl) {
		
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}

}
