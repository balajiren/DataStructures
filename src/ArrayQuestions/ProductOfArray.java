package ArrayQuestions;

public class ProductOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int[] productExceptSelf(int[] nums) {
	        
		    int[] t1 = new int[nums.length];
		    int[] t2 = new int[nums.length];
		    int[] result = new int[nums.length];
	        //assign first as 1
	        result[0]=1;
	        result[nums.length-1] = 1;
	        //Scan from left
	        for(int i=0;i<nums.length-1;i++) {
	            
	            t1[i+1] = nums[i] * t1[i];
	            
	        }
	        
	        //Scan from right
	        for(int i=nums.length-1;i>0;i--) {
	            
	            t2[i-1] = nums[i] * t2[i];
	            
	        }
	        int totalProduct = 1;
	        for(int i=0;i<nums.length-1;i++) {
	            
	        	result[i] = t1[i] * t2[i];
	            
	        }
	        
	        return result;
	    }
	 
	   public int[] productExceptSelf_Optimized(int[] nums) {
	        
	        int[] result = new int[nums.length];
	        //assign first as 1
	        result[0]=1;
	        //1 2 6 24
	        for(int i=1;i<nums.length;i++) {
	            
	            result[i] = nums[i-1] * result[i-1];
	            
	        }
	        int totalProduct = 1;
	        for(int i=nums.length-1;i>=0;i--) {
	            result[i] = result[i] * totalProduct;
	            totalProduct *=nums[i]; 
	            
	        }
	        return result;
	    }

}
