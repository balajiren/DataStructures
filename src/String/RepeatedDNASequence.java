package String;
import java.util.*;

public class RepeatedDNASequence {

	public static final Map<Character,Integer> hashEncoding = new HashMap<Character,Integer>();
	static
	{
		hashEncoding.put('A', 0);
		hashEncoding.put('C', 1);
		hashEncoding.put('G', 2);
		hashEncoding.put('T', 3);
	}
	private final static int TWO_POW_9 = (int) Math.pow(2, 9);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 GetRepeatedSequences("AACAAAAACAAAACCAAAAACAAAAACAAAA");

	}
	
	public static void GetRepeatedSequences(String s)
	{
		Set<String> result = new HashSet<String>();
		Map<Integer,String> duplicates = new HashMap<Integer,String>();
		
		for(int i=0, rhash= 0; i<s.length();i++)
		{
			if(i > 9)
			{
				rhash = rhash - TWO_POW_9 * hashEncoding.get(s.charAt(i-10));
				rhash = 2 * rhash + hashEncoding.get(s.charAt(i));
			}
			if( i > 8)
			{
				if(duplicates.get(rhash) !=null)
				{
					result.add(s.substring(i-9,i+1));
				}
				else
				{
					duplicates.put(rhash,"");
				}
			}
			
			
		}
		ArrayList<String> arrResults =  new ArrayList<String>(result);
		 for (int i = 0; i < arrResults.size(); i++)
	        {
			   
	            System.out.println(arrResults.get(i));
	        }
		
	}

}
