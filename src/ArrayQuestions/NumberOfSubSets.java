package ArrayQuestions;
import java.util.*;

//For a given list of integers and integer K, find the number of non-empty subsets S such that min(S) + max(S) <= K.
public class NumberOfSubSets {
//    nums = [2, 4, 5, 7]
//    k = 8
//    Output: 5
//    Explanation: [2], [4], [2, 4], [2, 4, 5], [2, 5]

    public static int countSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int low = 0, high = nums.length - 1; low <= high; ) {
            if (nums[low] + nums[high] > k) {
                high--;
            } else {
                count += 1 << (high - low);
                low++;
            }
        }
        return count;
    }
}
