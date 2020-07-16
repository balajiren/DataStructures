package String;

import java.util.HashSet;
import java.util.Set;

public class LongestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int val = lengthOfLongestSubstring2("aababbcbcbaaabbbdefeeee");
		System.out.print(val);

	}
	
	
	public static int lengthOfLongestSubstring2(String s) {
	    if (null == s || s.length() == 0) {
	        return 0;
	    }
	    Set<Character> set = new HashSet<Character>();
	    int left = 0, right = 0;
	    int res = 0;
	    while (right < s.length()) {
	        char c = s.charAt(right);
	        if (set.contains(c)) {
	            res = Math.max(res, right - left);
	            if (s.charAt(left) != c) {
	                set.remove(s.charAt(left));
	            } else {
	                right++;
	            }
	            left++;
	        } else {
	            set.add(c);
	            right++;
	        }
	    }
	    
	    return Math.max(res, right - left);
	}
	 
	 
	 
	public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.print(ans);
        return ans;
    }
	
	public static void LengthOfLongestString1(String input)
	{
	  //set to maintain chars
	   Set<Character> uniqueSet = new HashSet<Character>();

	  //sliding window var
	   int i=0, j= 0;
	   int maxLength = Integer.MIN_VALUE;
	   while(i<input.length() && j < input.length())
	   {
	      if(!uniqueSet.contains(input.charAt(j)))
	      {
	         uniqueSet.add(input.charAt(j++));
	         maxLength = Math.max(maxLength,j-1);

	      }
	      else
	      {
	        uniqueSet.remove(input.charAt(i++));

	      }
	 
	   }
	   System.out.print(maxLength);
	  // return input.substring(0,maxLength);   

	}

}
