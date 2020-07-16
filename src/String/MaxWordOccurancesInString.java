package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MaxWordOccurancesInString {

	public MaxWordOccurancesInString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       String input = "abvvckjdsfjdfsiujfdjdfjhfdjfdhfdererbbnfdjhwsadgywreuAJKSDNADHRYEADJKMSNBDBSDHSXXXXXXXXXXXXXS";
       HashMap<Character,Integer> count  = new HashMap<Character,Integer>();
       char[] arr = input.toCharArray();
       char maxChar;
       int charCount = 0;
      // char[26] chars = new char[]
       for(Character c : arr)
       {
    	   if(count.containsKey(c))
    	   {
    		   count.put(c, (Integer) count.get(c)+1);
     		
    	   }
    	   else
    	   {
    		   count.put(c, 1);

    	   }
    	
    		   
       }
       
      Iterator iter = count.keySet().iterator();
      int maxCount = 1;
      char mChar=Character.MIN_VALUE;
      while(iter.hasNext())
      {
    	   char c = (char) iter.next();
	    	if(count.get(c) > maxCount)
	    	{
	    		maxCount = count.get(c);
	    		mChar = c;
	    	}
      }
      System.out.print("Max appearances "+String.valueOf(mChar));
        
	}

}
