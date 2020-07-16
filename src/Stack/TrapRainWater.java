package Stack;
import java.util.*;

public class TrapRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	
	//https://leetcode.com/problems/trapping-rain-water/solution/
	 public int trap(int[] height) {
	        
	        //for each height
	        //current == next then calc
	        //current == next and i-1 then next higher from i-1 & i+1
	        //current == next and i+1 < i then equal
	        int ans = 0, current = 0;
	        Stack<Integer> st = new Stack<Integer>();
	        while(current < height.length) {
	            while(!st.isEmpty() && height[current] > height[st.peek()]) {
	                int top = st.peek();
	                st.pop();
	                if(st.isEmpty()) {
	                    break;
	                }
	                int distance = current - st.peek()-1;
	                int bounded_height = Math.min(height[current],height[st.peek()])-height[top];
	                ans+=distance * bounded_height;       
	            }

	            st.push(current++);
	        }
	        return ans;
	    }

}
