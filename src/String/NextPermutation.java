package String;

//https://leetcode.com/problems/next-permutation
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int i=nums.length-2;
        //Find decreasing element
        while(i>=0 && nums[i+1] <= nums[i]) {
            i--;
        }
        //Find an element greater than i
        if(i >= 0) {
            int j=-nums.length-1;
            while(j>=0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums,i,j);

        }
        //Reverse next character from i
        reverse(nums,i+1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int i=start,j=nums.length-1;
        while(i<j) {
            swap(nums,i,j);
            i++;
            j--;
        }
    }


}
