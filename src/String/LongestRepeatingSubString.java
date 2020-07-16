package String;


import java.util.*;

// MEMORY COMPLEXITY BELOW IS O(NLOGN). CAN BE OPTIMIZED BY SUFFIX TREE TO O(N)
//http://yuanhsh.iteye.com/blog/2186611
public class LongestRepeatingSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongestRepeatingString("asdfsaasdf");

	}
	
	
	 public int search(int L, int a, long modulus, int n, int[] nums) {
		    // compute the hash of string S[:L]
		    long h = 0;
		    for(int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

		    // already seen hashes of strings of length L
		    HashSet<Long> seen = new HashSet();
		    seen.add(h);
		    // const value to be used often : a**L % modulus
		    long aL = 1;
		    for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

		    for(int start = 1; start < n - L + 1; ++start) {
		      // compute rolling hash in O(1) time
		      h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
		      h = (h + nums[start + L - 1]) % modulus;
		      if (seen.contains(h)) return start;
		      seen.add(h);
		    }
		    return -1;
		  }

		  public int longestRepeatingSubstring(String S) {
		    int n = S.length();
		    // convert string to array of integers
		    // to implement constant time slice
		    int[] nums = new int[n];
		    for(int i = 0; i < n; ++i) nums[i] = (int)S.charAt(i) - (int)'a';
		    // base value for the rolling hash function
		    int a = 26;
		    // modulus value for the rolling hash function to avoid overflow
		    long modulus = (long)Math.pow(2, 24);

		    // binary search, L = repeating string length
		    int left = 1, right = n;
		    int L;
		    while (left <= right) {
		      L = left + (right - left) / 2;
		      if (search(L, a, modulus, n, nums) != -1) left = L + 1;
		      else right = L - 1;
		    }

		    return left - 1;
		  }
	
	public static String LCP(String s1,String s2)
	{
		int min = Math.min(s1.length(), s2.length());
		for(int i=0;i<min;i++)
		{
			if(s1.charAt(i)!=s2.charAt(i))
			{
				return s1.substring(0,i);
			}
		}
		
		return s1.substring(0,min);
	}
	
	public static String LongestRepeatingString(String s)
	{
			int n= s.length();
			String[] suffices = new String[n];
			for(int i=0;i<n;i++)
			{
				suffices[i] = s.substring(i,n);
			}
			Arrays.sort(suffices);
			System.out.print(Arrays.toString(suffices));
			String lrs = "";
			
			for(int i=0;i<n-1;i++)
			{
			   String x = LCP(suffices[i],suffices[i+1]);
			   if(x.length() > lrs.length())
			   {
				   lrs = x;
			   }
			}
		   System.out.print(lrs);
		   return lrs;
		
	}

}
