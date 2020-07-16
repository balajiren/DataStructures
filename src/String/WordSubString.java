package String;
import java.util.*;

public class WordSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 //Matching test
	 int result =	GetPatternMatchIndex("xxxqr", "xxhxxqxxxqrxxgxxxqr");
	 System.out.println(result);
	 search("xxhxxqxxxqrxxgxxxqr","xxxqr");
	 
	/* int result3 =	GetPatternMatchIndex("qxxxqr", "xxhxxqxxxqrxxgxxxqr");
	 System.out.println(result3);
	 
	 //Not matching test case
	 int result2 =	GetPatternMatchIndex("xxxqr", "xxhxxqxxxqqxxgxxxqb");
	 System.out.println(result2); */

	 
	

	}
	
	public static void search(String txt, String pat)
    {
        int M = pat.length();
        int N = txt.length();
 
        /* A loop to slide pat one by one */
        for (int i = 0; i <= N - M; i++) {
 
            int j;
 
            /* For current index i, check for pattern 
              match */
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
 
            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                System.out.println("Pattern found at index " + i);
        }
    }
	
	
	
	//Gets index of parent matching the child index. Average: O(N) Worst case when repeated patterns : O(M*N-M)
	public static int GetPatternMatchIndex(String source, String target)
    {
		int i = 0;
		int j = 0;
		int targetLen = target.length();
		while( i < source.length() && j < targetLen)
		{
			if(source.charAt(i) ==  target.charAt(j))
			{
				i++;
				
			}
			j++;

			if(i == source.length())
			{
			  return j-i;
			}
			
			
			
		}
		
		return -1;
    } 



	
	
	
}
