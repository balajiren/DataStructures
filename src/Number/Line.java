package Number;

import java.util.HashMap;

public class Line {

	
	static double epsilon = 0.00001;
	public double slope;
	public double yintersept;
	
	
	public Line(double s, double y)
	{
		
		slope = s;
		epsilon = y;
	}
	
	
	public class Point
	{
		float x;
		float y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean WillIntersect(Line line2)
	{
        return (Math.abs(line2.slope - slope) > epsilon || Math.abs(line2.yintersept - yintersept) < epsilon);
	}
	
	public int maxPoints(Point[] points) {
        if(points==null||points.length==0)
            return 0;
         if(points.length==1)
            return 1;
        int max=0;
        for(int i=0;i<points.length-1;i++){
            int currentPoints=1;
            int dup=0;
            HashMap<Double,Integer> map=new HashMap<>();
            for(int j=i+1;j<points.length;j++){
                if(points[i].x==points[j].x&&points[i].y==points[j].y){
                    dup++;
                    continue;
                }
                double slope;
                if(points[i].x-points[j].x==0){
                    slope=Double.MAX_VALUE;
                }
                else{
                    slope=(double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x);
                    slope+=0.0;
                }
                
                if(!map.containsKey(slope)){
                        map.put(slope,2);
                }
                else{
                        map.put(slope,map.get(slope)+1);
                        
                }
                        if(map.get(slope)+dup>currentPoints+dup)
                            currentPoints=map.get(slope);
                
                
            }
                currentPoints=currentPoints+dup;
                if(max<currentPoints)
                    max=currentPoints;
            
        }
        return max;
    }
	
}
	
	