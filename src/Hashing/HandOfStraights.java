package Hashing;
import java.util.*;

//https://leetcode.com/problems/hand-of-straights/
public class HandOfStraights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	Time Complexity: log NlogN due to the complexity of TreeMap.
//
//	Space Complexity: O(N)
	
	 public boolean isNStraightHand(int[] hand, int W) {
	        

	        TreeMap<Integer,Integer> count = new TreeMap();
	        for(int card : hand) {
	            count.put(card,count.getOrDefault(card,0)+1);
	        }
	        
	        while(count.size() > 0) {
	            int first = count.firstKey();
	            for(int card=first;card<first+W;card++) {
	                
	                if(!count.containsKey(card)) {
	                    return false;
	                }
	                int c = count.get(card);
	                if(c == 1) count.remove(card);
	                else count.replace(card,c-1);
	                
	                
	            }
	 
	        }
	       return true;
	    }

}
