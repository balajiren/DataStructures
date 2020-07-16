package String;

import java.util.Arrays;
	
public class KMPPatternMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] lps = ComputeLPSArray("abab");
		// System.out.print(Arrays.toString(lps));
		 int result = Search("dfdf","djkdjkfdjkdkjdfdfiusdfisifiufid");
		 System.out.print(result);
		 int result1 = NaiveSearch("dfdf","djkdjkfdjkdkjdfdfiusdfisifiufid");
		 System.out.print(result1);
	}
	
	
	
	//NAIVE PROVIDES O(N) AVG BUT WORST CASE IS (N-M+1) * M
	public static int NaiveSearch(String pattern, String text)
	{
		int m = pattern.length();
		int n = text.length();
		
		for(int i=0;i<n-m;i++)
		{
			int j = 0;
			for(j=0;j<m;j++)
			{
				if(text.charAt(i+j) !=pattern.charAt(j))
				{
					break;
				}
			}
			if(j == m)
			{
				return i;
			}
			
		}
		
		return 0;
		
		
	}
	
	
	//OPTIMIZATION : PROVIDES O(N) WORST CASE PERFORMANCE 
	public static int Search(String pattern, String text)
	{
		if(pattern.length() == 0 || text.length() == 0)
		{
			return -1;
		}
		int[] lsp = ComputeLPSArray(pattern);
		int pattern_index= 0;
		for(int i=0;i < text.length();i++)
		{
			while(pattern_index > 0 && pattern.charAt(pattern_index)!=text.charAt(i))
			{
				pattern_index = lsp[pattern_index-1];
			}
			if(pattern.charAt(pattern_index)==text.charAt(i))
			{
				
				pattern_index++;
				if(pattern_index == pattern.length())
				{
					return i - (pattern_index-1);
				}
				
			}
			
		}
		return -1;
	}
	
	public static int[] ComputeLPSArray(String pattern)
	{
		int j = 0;
		int[] lpsArray = new int[pattern.length()];
		int i	 = 1;
		lpsArray[0] = 0;
		while(i < pattern.length())
		{
			if(pattern.charAt(i) == pattern.charAt(j))
			{
				lpsArray[i] = j+1;
				i++;
				j++;
			}
			else
			{
				if(j != 0)
				{
					j = lpsArray[j-1];
					
				}
				else
				{
					
					lpsArray[i] = 0;
					i++;
				}
			}
			
		}
		//System.out.print(lpsArray);
		return lpsArray;
		
	}

}
