package Sorting;
import  java.util.*;

public class NWayMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>() {{
		    add(1);
		    add(4);
		    add(6);
		}};
		List<Integer> list1 = new ArrayList<Integer>() {{
		    add(5);
		    add(6);
		    add(9);

		}};
		List<List<Integer>> coll = new ArrayList<List<Integer>>() {{
			add(list);
			add(list1);
			
		}};
		
		int[][] arr = new int[][]
		{
			{1,4,8},
			
			{3,7,7}
		};
		
		List<List<Integer>> data = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		List<Integer> result = Merge(coll);
		System.out.println(result);

	}
	

    /** Function to merge arrays **/
    private static int[] merge1(int[][] arr) 
    {
        int K = arr.length;
        int N = arr[0].length;
 
        /** array to keep track of non considered positions in subarrays **/
        int[] curPos = new int[K];
 
        /** final merged array **/
        int[] mergedArray = new int[K * N];
        int p = 0;
 
        while (p < K * N)
        {
            int min = Integer.MAX_VALUE;
            int minPos = -1;
            /** search for least element **/
            for (int i = 0; i < K; i++)
            {
                if (curPos[i] < N)
                {
                    if (arr[i][curPos[i]] < min)
                    {
                        min = arr[i][curPos[i]];
                        minPos = i;
                    }
                }                
            }
            curPos[minPos]++;            
            mergedArray[p++] = min;
        }
        return mergedArray;
    }
	
    public static List<Integer> Merge(List<List<Integer>> data){ 
    	
    	int totalSize=0;
    	for(List<Integer> l : data) {
    		totalSize+=l.size();
    	}
    	 List<Integer> result = new ArrayList<Integer>();
    	 List<Integer> min;
    	 while(result.size() < totalSize) {
    		 min=null;
    		 for(List<Integer> l : data) {
    			 
    			 if(min==null || min.size() == 0)
                     min = l;
    			 
    			 else if(l!=null && l.get(0) < min.get(0)) {
    				 min = l;
    			 }
    		
    		 }
    		 
    		 if(min.size() > 0) {
				 result.add(min.get(0));
				 min.remove(0);
			 }
    		 
    	 
    	 }
    	 return result;
    	
    }
    
    
	
	public static List<Integer> merge_test(List<List<Integer>> data){
        int totalSize = 0;
        for(List<Integer> l:data)
            totalSize = totalSize + l.size();
        
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> min ;
        
        while(result.size()<totalSize){
            min = null;
            for(List<Integer> l: data){
                
                if(min==null || min.size() == 0)
                    min = l;
                else if(l!=null && l.get(0)<min.get(0)){
                    min = l;
                }
            }
            if(min.size()  > 0)
            {
	            result.add(min.get(0));
	            min.remove(0);
            }
        }
        
        return result;
        
    } 

}
