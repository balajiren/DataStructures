package ArrayQuestions;

import java.util.HashSet;
import java.util.*;

public class MountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = LargestMountain(new int[]{0,1,2,3,4,5,4,3,2,1,0});
		System.out.println(result);

	}

	public int longestMountain(int[] A) {
		int max = 0;
		for(int i = 1; i < A.length -1; i++) {
			int k = 1;
			int left = i;
			while(left > 0 && A[left-1] < A[left]) {
				left--;
			}
			int right = i;
			while(right + 1 < A.length && A[right+1] < A[right]) {
				right++;
			}
			int length = 1 + (i-left) + (right - i);
			if(i-left > 0 && (right - i) > 0)
				max = Math.max(max, length);
		}
		return max;
	}
	
	public static int LargestMountain(int[] A)
	{
		int leftPeakLength = 0;
		int rightPeakLength = 0;
		int maxPeak = 0;
			if(A.length == 0)
		{
			return 0;
		}
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<A.length-1;i++)
		{
			if(A[i] < A[i+1] )
			{
				leftPeakLength++;
				result.add(A[i]);

				
			}
			if(leftPeakLength > 0 && A[i] > A[i+1])
			{
				result.add(A[i+1]);
				rightPeakLength++;
			}
			if(leftPeakLength > 0 && leftPeakLength == rightPeakLength)
			{
				maxPeak = Math.max(maxPeak, result.size()+1);
				leftPeakLength = 0;
				rightPeakLength = 0;
				result.clear();
			}
		}
		
		return maxPeak;
	}

}
