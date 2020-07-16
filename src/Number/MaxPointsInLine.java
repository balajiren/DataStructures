package Number;

import java.util.HashMap;

import Number.Line.Point;

public class MaxPointsInLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//O(N2) TIME AND O(N) SPACE'
  //The idea is very simple : draw the lines passing through the point i and each of the
//next points. Save these lines is a hash table with a counter 2 = two points on this line.
	public int maxPoints(Point[] points) {
	    if(points == null || points.length == 0) return 0;
	 
	    HashMap<Double, Integer> result = new HashMap<Double, Integer>();
	    int max=0;
	   //
	    for(int i=0; i<points.length; i++){
	        int duplicate = 1;//
	        int vertical = 0;
	        for(int j=i+1; j<points.length; j++){
	            //handle duplicates and vertical
	            if(points[i].x == points[j].x){
	                if(points[i].y == points[j].y){
	                    duplicate++;
	                }else{
	                    vertical++;
	                }
	            }else{
	                double slope = points[j].y == points[i].y ? 0.0
					        : (1.0 * (points[j].y - points[i].y))
							/ (points[j].x - points[i].x);
	 
	                if(result.get(slope) != null){
	                    result.put(slope, result.get(slope) + 1);
	                }else{
	                    result.put(slope, 1);
	                }
	            }
	        }
	 
	        for(Integer count: result.values()){
	            max = Math.max(max,count+duplicate);
	        }
	 
	        max = Math.max(vertical + duplicate, max);
	        result.clear();
	    }
	 
	 
	    return max;
	}
	
	
	

}
