package Number;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String result =FindLargestNumber(new int[]{10,2});
		System.out.println(result);

	}
	
	
	
	public static String FindLargestNumber(int[] nums)
	{
		if(nums.length == 0)
		{
			return null;
		}
		List<String> lstArr = new ArrayList<String>();
		
		for(Integer num : nums)
		{
			lstArr.add(num.toString());
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(lstArr,new Comparator<String>()
		{
	
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
				return (b+a).compareTo(a+b);
			}

			
		});

	
		for(String num : lstArr)
		{
			sb.append(num);
		}
		
		return sb.toString();
	
		
	}

}
