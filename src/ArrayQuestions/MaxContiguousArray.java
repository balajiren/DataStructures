package ArrayQuestions;
import java.util.*;

public class MaxContiguousArray {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int count=0,result = 0;
        for(int i=0;i<nums.length;i++) {

            if(nums[i] ==1) {
                count+=1;
            } else {
                count-=1;
            }
            if(map.containsKey(count)) {
                result = Math.max(result,i-map.get(count));
            } else {
                map.put(count,i);
            }

        }
        return result;

    }
}
