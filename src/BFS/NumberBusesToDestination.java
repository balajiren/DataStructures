package BFS;
import java.util.*;

//https://leetcode.com/problems/bus-routes/
public class NumberBusesToDestination {

	class Point {
		
		int x=0,y=0;
		Point(int point1, int point2) {
			x=point1;
			y=point2;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numBusesToDestination(int[][] routes, int S, int T) {
    	
    	int N = routes.length;
    	List<List<Integer>> graph = new ArrayList();
    	for(int i=0;i<N;i++) {
    		Arrays.sort(routes[i]);
    		graph.add(new ArrayList());
    	}
    	  Set<Integer> seen = new HashSet();
          Set<Integer> targets = new HashSet();
          Queue<Point> queue = new ArrayDeque();
    	
          for(int i=0;i<N;i++) {
        	  
        	  for(int j=i+1;j<N;j++) {
        		  
        		  if (intersect(routes[i], routes[j])) {
        			  graph.get(i).add(j);
                      graph.get(j).add(i);
        		  }
        		  
        		  
        	  }
        	  
        	  
          }
          
          //
          for(int i = 0; i < N; ++i) { 
        	  
        	  if (Arrays.binarySearch(routes[i], S) >= 0) {
        		  
        		  seen.add(i);
        		  queue.offer(new Point(i,0));
        	  }
        	  
        	  if (Arrays.binarySearch(routes[i], T) >= 0) {
        		  
        		  targets.add(i);
        	  }
        	  
  
        	  
          }
          
          while(!queue.isEmpty()) {
        	  
        	  Point info = queue.poll();
        	  int node = info.x, depth = info.y;
        	  if (targets.contains(node)) return depth+1;
        	  for(Integer neigh : graph.get(node)) {
        		  if(!seen.contains(neigh)) {
        			  seen.add(neigh);
        			  queue.add(new Point(neigh, depth+1));
        		  }
        	  }
        	  
        	  
        	  return -1;
          }
		return N;
        		  
    
    	
    }
    
    public boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++; else j++;
        }
        return false;
    }

}
