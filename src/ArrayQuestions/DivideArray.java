package ArrayQuestions;
import java.util.*;

public class DivideArray {

    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int x: nums)
            map.put(x,map.getOrDefault(x,0)+1);

        for(int n : map.keySet()) {

            int curr = map.get(n);
            if(curr == 0) continue;
            for(int i=n;i<k+n;i++) {
                if(!map.containsKey(i) || map.get(i) <= 0) {
                    return false;
                }
                map.put(i, map.get(i)-curr);
            }

        }

        return true;
    }
}
