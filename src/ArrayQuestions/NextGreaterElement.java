package ArrayQuestions;
import java.util.*;

public class NextGreaterElement {

    //Time & Space = O(M+N)
    //https://leetcode.com/problems/next-greater-element-i/
    public int[] nextGreaterElement(int[] findNums, int[] nums) {

        Stack<Integer> st = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[findNums.length];
        for(int i=0;i<nums.length;i++) {
            while(st.isEmpty() && st.peek() < nums[i]) {
                map.put(st.pop(),nums[i]);
            }
            st.push(nums[i]);
        }
        while(!st.isEmpty()) {
            map.put(st.pop(),-1);
        }
        for(int i=0;i<findNums.length;i++) {
            result[i] = map.get(findNums[i]);
        }

        return result;

    }



}
