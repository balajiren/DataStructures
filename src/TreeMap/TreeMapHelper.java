package TreeMap;

import java.util.*;

public class TreeMapHelper {
	
	
	SortedMap m = Collections.synchronizedSortedMap(new TreeMap());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
	      map.put(100,"Amit");    
	      map.put(102,"Ravi");    
	      map.put(101,"Vijay");    
	      map.put(103,"Rahul");    
	      System.out.println("Before invoking remove() method");  
	      for(Map.Entry m:map.entrySet())  
	      {  
	          System.out.println(m.getKey()+" "+m.getValue());    
	          System.out.println(map.floorKey(100));  
	      }  
	      
	      SortedMap<Integer,String> smap=new TreeMap<Integer,String>();   
	      

	}

}
