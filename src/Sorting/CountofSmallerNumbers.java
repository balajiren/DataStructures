package Sorting;
import java.util.*;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class CountofSmallerNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = new int[]{5,2,6,1};
		CountofSmallerNumbers c = new CountofSmallerNumbers();
		List<Integer> result = c.countSmaller(input);
		System.out.println(Arrays.toString(result.toArray()));
	}
	
    public List<Integer> countSmaller(int[] nums) {
        
		int n = nums.length;
	
		int[] count = new int[n];
		int[] temp = new int[n];
		int[] indices = new int[n];
	
		for (int i = 0; i < n; i++) 
			indices[i] = i;
	
		mergeSort(indices, 0, n - 1, nums, temp, count);
	
		List<Integer> res = new ArrayList();
		for (int i = 0; i < n; i++) 
			res.add(count[i]);

	return res;
}

private void mergeSort(int[] indices, int start, int end, int[] nums, int[] temp, int[] count) {
	if (start >= end) return;

	int mid = start + ((end - start) >> 1);

	mergeSort(indices, start, mid, nums, temp, count);
	mergeSort(indices, mid + 1, end, nums, temp, count);
	merge(indices, start, mid, end, nums, temp, count);

	return;
}

private void merge(int[] indices, int start, int mid, int end, int[] nums, int[] temp, int[] count) {
	int rightCount = 0;

	for (int i = start; i <= end; i++)
		temp[i] = indices[i];

	for (int left = start, right = mid + 1, k = start; left <= mid || right <= end;) {
		if (left > mid || right <= end && nums[temp[left]] > nums[temp[right]]) {
			rightCount++;
			indices[k++] = temp[right++];
		} else {
			count[temp[left]] += rightCount;
			indices[k++] = temp[left++];
		}
	}
	return;
}

}
