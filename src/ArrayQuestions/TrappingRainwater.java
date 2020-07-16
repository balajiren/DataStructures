package ArrayQuestions;

public class TrappingRainwater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int trap(int[] height) {
		
		int left[] = new int[height.length];
		int right[]= new int[height.length];
		
		int max = height[0];
		left[0] = height[0];
		int result = 0;
		
		 //scan from left to right
		for(int i=1;i<height.length;i++) {
			
			if(height[i] < max) {
				left[i] = max;
			} else {
				
				max = height[i];
				left[i] = height[i];
			}
			
		}
		//scan from right to left
		max = height[height.length-1];
		right[height.length-1] = height[height.length-1];
		for(int i=height.length-2;i>0;i--) {
			
			if(height[i] < max) {
				right[i] = max;
			} else {
				
				max = height[i];
				right[i] = height[i];
			}
			
		}
		//calculate total
		for(int i=0;i<height.length;i++) {
			result+=Math.min(left[i], right[i])-height[i];
		}
		
		return result;
	}

}
