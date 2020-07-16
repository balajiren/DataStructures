package BFS;
import java.util.*;

public class OpenLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int openLock(String[] deadends, String target) {
	        
	        Set<String> dead = new HashSet();
	        for (String d: deadends) dead.add(d); 
	        Queue<String> queue = new LinkedList();
	        queue.offer("0000");
	        queue.offer(null);
	        Set<String> seen = new HashSet<String>();
	        seen.add("0000");
	        int depth=0;
	        while(!queue.isEmpty()) {
	            
	            String code = queue.poll();
	        
	            if (code == null) {
	                depth++;
	                if (queue.peek() != null)
	                    queue.offer(null);
	            }
	            
	            else if(code.equals(target)) {
	                return depth;
	            }
	            else if(!dead.contains(code)) {
	                
	                for(int i=0;i<4;i++) {
	                   
	                	//for each of turn -1 or +1
	                   for(int d=-1;d<=1;d+=2) {
	                       //wrap it so that after 9 the number
	                       int y = ((code.charAt(i)-'0') + d + 10) % 10;
	                       String neighbour = code.substring(0,i) +("" + y) +                code.substring(i+1);
	                       if(!seen.contains(neighbour)) {
	                           seen.add(neighbour);
	                           queue.offer(neighbour);
	                       }
	                       
	                       
	                   }
	                    
	                    
	                    
	                    
	                    
	                }
	                
	                
	                
	            }
	            
	    
	            
	            
	        }
	        
	        
	        return -1;
	    }

}
