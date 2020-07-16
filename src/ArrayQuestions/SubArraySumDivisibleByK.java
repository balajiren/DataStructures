package ArrayQuestions;
import java.util.*;

public class SubArraySumDivisibleByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int subarraysDivByK(int[] A, int K) {
	        
		     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		     map.put(0,1);
		     int runningsum=0, count=0;;
		     for(int i=0;i<A.length;i++) {
		         runningsum+=A[i];
		         int remainder = runningsum % K;
		         if(remainder < 0) {
		             remainder +=K;
		         }
		         if(map.containsKey(remainder)) {
		             count+=map.get(remainder);
		         }
		         map.put(remainder,map.getOrDefault(remainder,0)+1);
		     }

		        return count;
		        
		    }

}
