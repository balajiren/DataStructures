package ArrayQuestions;

public class MergeArraysInPlace {

	 
    final static int INVALID_NUM = 0;
	 public static void main(String args[])
	    {
	      
	   
	       int[] arrayA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM};
	        int[] arrayB = {-1, 2, 6, 12};
	         
	        MergeArraysInPlace(arrayA, arrayB);
	        for (int i = 0;  i < arrayA.length; i++)
	        {
	            System.out.print(arrayA[i] + ", ");
	        }
	      
	    
	    }
	 
	 
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	        
	        int p1 = m-1;
	        int p2 = n-1;
	        int p = m + n -1;
	        int[] result = new int[p];
	        while(p1>=0 && p2>=0) {
	            
	            if(nums1[p1] > nums2[p2]) {
	                nums1[p--] = nums1[p1--];
	            } else {
	                nums1[p--] = nums2[p2--];
	            }
	         
	        }
	        
	        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	         
		        
	       
	        
	        
	    }
	 
	 
	 private static void MergeArraysInPlaceWith1Space(int[] nums1, int[] nums2) {
		 
		 int m = nums1.length;
		 int n = nums2.length;
		 int p1 = m-1;
		 int p2 = n-1;
		 while(p1>=0 && p2>=0) {
			 
			 nums1[p1--] = nums1[p1] > nums2[p2] ? nums2[p2--] : nums1[p1--];
			 
			 
		 }
		 while(p2>=0) {
			 nums1[p1--] = nums2[p2--];
		 }
		 
		 
	 }
	
	    		
	    
	    private static void MergeArraysInPlace(int[] arr1, int[] arr2)
	    {
	        
	        int validInddex = arr1.length-1;
	        for(int i=arr1.length-1;i >= 0 ;i--)
	        {
	            
	            if(arr1[i] != INVALID_NUM)
	            {
	                arr1[validInddex] = arr1[i];
	                validInddex-=1;
	            }
	          
	            
	        }
	        
	            int i = validInddex+1;
	            int k=0; int j= 0;
	            while(i < arr1.length  && j< arr2.length)
	            {
	                if(arr1[i] <  arr2[j])
	                {
	                    arr1[k++] = arr1[i++];
	                }
	                else
	                {
	                    arr1[k++] = arr2[j++];
	                }
	                
	            }
	            while(j < arr2.length)
	            {
	                arr1[k++] = arr2[j++];
	            }
	        
	        
	    }
	    

}
