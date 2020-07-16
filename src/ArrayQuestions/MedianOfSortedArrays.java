package ArrayQuestions;

public class MedianOfSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
			int[] arr1 =  new int[] {1, 12, 15, 26, 39};
			int[] arr2 =  new int[]  {2, 13, 17};
			
			double result = findMedianSortedArrays(arr1, arr2);
			System.out.print(result);
			
			double result1 = findMedianSortedArraysDifferentSize(arr1, arr2);
			System.out.print(result1);
			
		

	}
	

	
	public static double findMedianSortedArraysDifferentSize(int[] arr1, int[] arr2) {
		        if(arr1 == null && arr2 == null) {
		    return -1;
		}
		if(arr1.length == 0 && arr2.length == 0) {
		    return -1;
		}
		
		int x = arr1.length;
		int y = arr2.length;
		
		if(x > y) {
		    return findMedianSortedArraysDifferentSize(arr2, arr1);
		}
		int low = 0;
		int high = x;
		while (low <= high) {
		    int partitionX = (low + high) / 2;
		    int partitionY = (x + y + 1) / 2 - partitionX;
		
		    int maxleftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
		    int minRightX = partitionX == x ? Integer.MAX_VALUE : arr1[partitionX];
		
		    int maxleftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY - 1];
		    int minRightY = partitionY == y ? Integer.MAX_VALUE : arr2[partitionY];
		
		    if(maxleftX <= minRightY && maxleftY <= minRightX) {
		        if((x + y)%2 == 0) {
		            return (Math.max(maxleftX, maxleftY) + Math.min(minRightX, minRightY)) / 2.0;
		        } else {
		            return Math.max(maxleftX, maxleftY);
		        }
		    } else if(maxleftX > minRightY) {
		        high = partitionX - 1;
		    } else {
		        low = partitionX +  1;
		    }
		}
		return  -1;
}

	
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int total = nums1.length+nums2.length;
	    if(total%2==0){
	        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
	    }else{
	        return findKth(total/2+1, nums1, nums2, 0, 0);
	    }
	}
	
	
	public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
	    if(s1>=nums1.length)
	        return nums2[s2+k-1];
	 
	    if(s2>=nums2.length)
	        return nums1[s1+k-1];
	 
	    if(k==1)
	        return Math.min(nums1[s1], nums2[s2]);
	 
	    int m1 = s1+k/2-1;
	    int m2 = s2+k/2-1;
	 
	    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
	    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
	 
	    if(mid1<mid2){
	        return findKth(k-k/2, nums1, nums2, m1+1, s2);
	    }else{
	        return findKth(k-k/2, nums1, nums2, s1, m2+1);
	    }
	}

}
