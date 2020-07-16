
package Hashing;
import java.util.*;

public class CheckStringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean CheckIfPermutation()
	{
		boolean status = false;
		char[] s1 = "balaji".toCharArray();
		char[] s2 = "ijalab".toCharArray();
		Hashtable<Character,Integer> charMap = new Hashtable<Character,Integer>();
		for(int i=s1.length;i >=0; i--)
		{
			if(charMap.containsKey(s1[i]))
			{
				charMap.put(s1[i], charMap.get(s1[i])+1);
			}
			else
			{
				charMap.put(s1[i], 1);
			}
		}
		for(int j=s2.length;j >=0; j--)
		{
			if(charMap.containsKey(s2[j]))
			{
				charMap.put(s2[j], charMap.get(s2[j] -1));
			}
			else
			{
				charMap.put(s2[j], 1);
			}

					
		}
		int count =0;
		for(Integer frequency : charMap.values())
		{
			status =  frequency > 0;
		}
		   return status;
	}
 
}
