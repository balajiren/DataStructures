package ArrayQuestions;

import java.util.Arrays;
import java.util.HashMap;

public class SmallerNumberThanSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] GetSmallerNums(int[] nums) {
		
		int[] temp = Arrays.copyOf(nums, nums.length);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < temp.length; i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i], i);
            }                                                   
        }  
		for(int i = 0; i < nums.length; i++){
			
			nums[i] = map.get(nums[i]);
			
		}
		return nums;
		
	}

}
