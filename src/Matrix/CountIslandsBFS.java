package Matrix;
import java.util.*;
public class CountIslandsBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numIslands(char[][] grid) {
	       if(grid.length == 0) {
		            return 0;
		    }
		        int nr = grid.length;
		        int nc = grid[0].length;
		        int countIslands = 0;
		        Queue<Integer> que = new LinkedList<Integer>();
		        
		        for(int i=0;i<nr;i++) {
		            
		            for(int j=0;j<nc;j++) {
		                
		                if(grid[i][j] == '1') {
		                    countIslands++; 
		                    que.add(i*nc+j);
		                    while(!que.isEmpty()) {
		                    	Integer val = que.poll();
		                    	int row = val / nc;
		                    	int col = val % nc;
		                    	if(row-1 >= 0 && grid[row-1][col] == '1') {
		                    		  que.add((row-1)*nc+col);
		                    		  grid[row-1][col] = '0';
		                    	}
		                    	if(col-1 >= 0 && grid[row][col-1] == '1') {
		                    		  que.add(row*nc+col-1);
		                    		  grid[row][col-1] = '0';
		                    	}
		                    	if(row+1 < nr && grid[row+1][col] == '1') {
		                    		  que.add((row+1)*nc+col);
		                    		  grid[row+1][col] = '0';
		                    	}
		                    	if(col+1 < nc && grid[row][col+1] == '1') {
		                    		  que.add(row*nc+col+1);
		                    		  grid[row][col+1] = '0';
		                    	}
		                    	
		                    	
		                    }
		                    
		                }
		            }
		        }
		        
		        return countIslands;
	        
	    }
		     

}
