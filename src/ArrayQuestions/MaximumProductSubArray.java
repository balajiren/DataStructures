package ArrayQuestions;

public class MaximumProductSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int res = MaxProductSubArray(new int[] {2,3,-2, 4});
		System.out.println(res);

	}
	
	//input : [2,3,-2,4]
	//output : 6
	public static int MaxProductSubArray(int[] nums)
	{
	    int[] max = new int[nums.length];
        int[] min = new int[nums.length];
 
    max[0] = min[0] = nums[0];
    int result = nums[0];
 
    for(int i=1; i<nums.length; i++){
        if(nums[i]>0){
            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
        }else{
            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
        }
 
        result = Math.max(result, max[i]);
    }
 
    return result;
		
	}
	
	public int maxProduct(int[] nums) {
        int product =1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            product *= nums[i];
            max = Math.max(max, product);
            if(product == 0) product = 1;
        }
        
        product = 1;
        for(int i=nums.length-1;i>=0;i--){
            product *= nums[i];
            max = Math.max(max, product);
            if(product == 0) product = 1;
        }
        
        return max;
    }

}
