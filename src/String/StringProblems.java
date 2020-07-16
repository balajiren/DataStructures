package String;

import java.util.*;

public class StringProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//GetAnagram("LISTEZN","SILENT");
		//int[] result = MakePivotSort(new int[]{19,15,3,22,28,30,17,18}, 16, 22);
		//System.out.println(Arrays.toString(result));
		FindSubString1("balaji","shhjdfhdjbalajidfff");

	}
	//{10,15,3,22,28,30,16} {16, 22}
	public static int[] MakePivotSort(int[] nums, int min, int max)
	{
		int minIndex = 0;
		int maxIndex = nums.length-1;
		int midIndex = 0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i] < min)
			{
				//nums[minIndex] = nums[i];
				swap(nums,minIndex,i);
				minIndex++;
			} else
			
			if(nums[i] > max)
			{
				//result[maxIndex] = nums[i];
				swap(nums,i, maxIndex);
				maxIndex--;
			}
			/*else if (nums[i] > min && nums[i] < max)
			{
				midIndex 
				swap(nums,minIndex,i);
				//minIndex++;
				
			} */
	

		}
		return nums;
		
	}
	public static void swap(int[] nums, int a, int b)
	{
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	
	public static String FindSubString1(String pattern, String input)
	{
		String result= null;
		int start = 0;
		int end = 0;
		while(start < pattern.length() && end < input.length())
		{
			if(pattern.charAt(start) == input.charAt(end))
			{
				start++;
			}
			end++;
			if(start == pattern.length())
			{
				result = input.substring(end-start,end);
		        System.out.println(result);
				return result;
			}
			
		}	

		return null;
	}
	
	public static boolean GetAnagram(String s, String t)
	{
	
		int[] vals = new int[26];
		int[] vals1 = new int[26];
		boolean status = true;
		int count1=0;
		int count2 = 0;
		for(int i=0;i<s.length();i++)
		{
			char ch = s.charAt(i);
			count1 += vals['Z' - ch]+1;
		}
		for(int i=0;i<t.length();i++)
		{
			char mch = t.charAt(i);
			count2 += vals1['Z' - mch]+1;
		
		}
		if(count1!=count2)
		{
			status = false;
		}
		System.out.println(status);
		return status;
		
		
		
		
	}
	
	
	
	 
    private static boolean CheckStringPermutation(String s,String t)
    {
        
        int[] charMap = new int[256];

        char[] arr = s.toCharArray();

        for(char c : arr)
        {
            charMap[c]+=1;
      
            
        }
        //System.out.print(charMap);
        
        for(int i=0;i<t.length();i++)
        {
            char c =  t.charAt(i);
            if(--charMap[c] < 0)
            {
                return false;
            }
            
        }
        
        return true;
        
    }
	
	public static void ReverseString(String s)
	{
		
		char[] stringchars = s.toCharArray();
		StringBuffer buffer = new StringBuffer();
		for(int i = stringchars.length-1; i>=0;i--)
		{
			buffer.append(stringchars[i]);
		}
		
		System.out.print(buffer.toString());
		
	}
	
	
	public boolean IsValidPalindrome(String	 s)
	{
		s=  s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		
		int len = s.length();
		if (len < 2)
			return true;
	 
		Stack<Character> stack = new Stack<Character>();
		
		int index = 0;
		while (index < len / 2) {
			stack.push(s.charAt(index));
			index++;
		}
	 
		if (len % 2 == 1)
			index++;
	 
		while (index < len) {
			if (stack.empty())
				return false;
	 
			char temp = stack.pop();
			if (s.charAt(index) != temp)
				return false;
			else
				index++;
		}
		
		return true;
	}
	
	
	//Time O(N) Memory O(N)
	public static void RemoveSpaces(String s)
	{
		char[] stringchars = s.toCharArray();
		int numSpaces = 0;
		for (int i = 0; i < stringchars.length; i++)
		{
			if(stringchars[i] == ' ')
			{
				numSpaces+=1;
			}
			else
			{
			 stringchars[i-numSpaces] = stringchars[i];
			
			}
		}
		
		stringchars = Arrays.copyOf(stringchars, stringchars.length - numSpaces);
		System.out.print(new String(stringchars));
		
	}

}
