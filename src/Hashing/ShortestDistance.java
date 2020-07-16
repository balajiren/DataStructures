package Hashing;

import java.util.HashMap;

public class ShortestDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"practice", "makes", "perfect", "coding", "makes"};
	

	}
	
    
	public int getShortestDistance(String word1, String word2, String[] arr)
	{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			
			map.put(arr[i], i);
			
		}
		
		Integer i1 = map.get(word1);
		Integer i2 = map.get(word2);
		
		int i = 0,j=0;
		int shortest = Integer.MAX_VALUE;
		
		while(i < i1 && j < i2)
		{
			
			shortest = Math.min(shortest,i-j);
			if(i<i1)
			{
				i++;
			}
			else
			{
				j++;
			}

		}
		
		return shortest;
		
	}

}
