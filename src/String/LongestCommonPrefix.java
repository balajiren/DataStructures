package String;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             System.out.println("Longest common prefix is"+longestCommonPrefixBinary(new String[]{"leets","leetcode","leet"}));
             		
	}
	
	public static String longestCommonPrefix_Test(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}
	
	//O(N*N) - DO NOT USE - BRUTE FORCE
	public static String LongestCommonPrefix1(String[] strs)
	{
		int minLen = strs.length+1;
		for(String str  : strs)
		{
			minLen = Math.min(str.length(), minLen);
		}
		for(int i=0;i<minLen;i++)
		{
			for(int j=0;j<strs.length-1;j++)
			{
				String Str1 = strs[j];
				String Str2 = strs[j+1];
				if(Str1.charAt(i) != Str2.charAt(i))
				{
					return Str1.substring(0,i);
				}
			
			}
			
			
		}
		return strs[0].substring(0, minLen);
	}
	
	
	//log(n) memory complexity:

	public static String longestCommonPrefixBinary(String[] strs) {
	    if (strs == null || strs.length == 0) return "";    
	        return longestCommonPrefix(strs, 0 , strs.length - 1);
	}

	private static String longestCommonPrefix(String[] strs, int l, int r) {
	    if (l == r) {
	        return strs[l];
	    }
	    else {
	        int mid = (l + r)/2;
	        String lcpLeft =   longestCommonPrefix(strs, l , mid);
	        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
	        return commonPrefix(lcpLeft, lcpRight);
	   }
	}

	static String commonPrefix(String left,String right) {
	    int min = Math.min(left.length(), right.length());       
	    for (int i = 0; i < min; i++) {
	        if ( left.charAt(i) != right.charAt(i) )
	            return left.substring(0, i);
	    }
	    return left.substring(0, min);
	}

}


