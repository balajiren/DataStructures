package ArrayQuestions;
import java.util.*;

public class SubArraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int subarraySum(int[] nums, int k) {
        //keep pointer and increment pointer
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count=0; int sum=0;
        map.put(0,1);
        for(int num : nums) {
            sum+=num;
            if(map.containsKey(sum-k)) {
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        
        return count;
    }

}
