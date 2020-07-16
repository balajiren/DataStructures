package ArrayQuestions;

import java.util.*;

public class SlidingWindowMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public double[] medianSlidingWindow(int[] nums, int k) {
	        int n = nums.length;
	        double[] res = new double[n - k + 1];
	        int i = 0; //index of res

	        int l = 0, r = k - 1;
	        while (r < n) {
	            int[] tmp = Arrays.copyOfRange(nums, l, r + 1);
	            Arrays.sort(tmp);
	            if (k % 2 == 1) {
	                res[i++] = tmp[k / 2] * 1.0;
	            } else {
	                res[i++] = (tmp[k / 2 - 1] * 1.0 + tmp[k / 2] * 1.0) / 2;
	            }
	            l++; r++;
	        }
	        return res;
	    }
	 
	 
	 public double[] medianSlidingWindow_pq(int[] nums, int k) {
	        double[] res = new double[nums.length-k+1];
	        PriorityQueue<Integer> lower = new PriorityQueue(Collections.reverseOrder()), upper = new PriorityQueue();
	        int start = 0;
	        for (int i = 0; i < nums.length; i++) {
	            int num = nums[i];
	            upper.add(num);
	            lower.add(upper.poll());
	            if (lower.size() > upper.size()) upper.add(lower.poll());
	            if (i >= k - 1) {
	                if (upper.size()==lower.size()) {
	                    res[i-k+1] = 0.5 * ((double)upper.peek() + lower.peek());
	                } else {
	                    res[i-k+1] = (double) upper.peek();
	                }
	                int first = nums[start++];
	                if (first >= upper.peek()) {
	                    upper.remove(first);
	                } else {
	                    lower.remove(first);
	                }
	                if (lower.size() > upper.size()) upper.add(lower.poll());
	                else if (upper.size() > lower.size() + 1) lower.add(upper.poll());
	            }    
	        }
	        return res;
	    }

}
