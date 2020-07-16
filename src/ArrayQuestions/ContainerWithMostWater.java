package ArrayQuestions;
//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
	
//left and right pointer and reduce them to calculate area	
public int maxArea(int[] height) {
        
        int maxarea = 0, l=0, r=height.length-1;
        while(l<r) {
            maxarea = Math.max(maxarea,Math.min(height[l],height[r]) * (r-l));
            
            if(height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }         
            
        }    
        return maxarea;
        
        
    }

}
