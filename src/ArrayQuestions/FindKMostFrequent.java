package ArrayQuestions;

import java.util.*;

public class FindKMostFrequent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<Integer> FindKMostFrequent(int[] nums, int k)
	  {
	    Map<Integer, Integer> freqmap = new HashMap<Integer,Integer>();
	    //create the hashmap
	    for(int i : nums)
	    {
	      if(freqmap.containsKey(i))
	      {
	        freqmap.put(i,freqmap.get(i)+1);
	      } else
	      {
	        freqmap.put(i,1);
	        
	      }
	      
	    }
	        // get the max frequency
	    int max= 0;
	    for(Map.Entry<Integer,Integer> entry : freqmap.entrySet())
	    {
	       max = Math.max(entry.getValue(), max);
	      
	    }
	    
	  

	   ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
	    //create array buckets
	    for(int i=0;i<max;i++)
	    {
	      arr[i] = new ArrayList<Integer>();
	      
	    }
	    
	    for(Map.Entry<Integer,Integer> entry : freqmap.entrySet())
	    {
	      int count = entry.getValue();
	      int key = entry.getKey();
	      arr[key].add(count);
	      
	    }
	     List<Integer> result = new ArrayList<Integer>();
	    for(int j=max;j>0;j--)
	    {
	      if(arr[j].size() > 0)
	      {
	        for(int i : arr[j])
	        {
	          result.add(i);
	          if(result.size() == k)
	          {
	              break;
	          }
	          
	        }
	        
	      }
	      
	    }
	    
	    return result;
	    
	  }

}
