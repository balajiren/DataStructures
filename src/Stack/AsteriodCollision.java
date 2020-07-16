package Stack;
import java.util.*;

public class AsteriodCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int[] asteroidCollision(int[] asteroids) {
        
	  Stack<Integer> stack = new Stack<>();
      for(int ast: asteroids){
          if(ast > 0)
          {// if +ve--- always keep it,
              stack.push(ast);
          }
          else{ // if -ve, 4 conditions
              while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast)){
                  // 1. if prev is +ve and smaller than this -ve num, remove prev
                  stack.pop();
              }
              
              if(!stack.isEmpty()  && (ast + stack.peek() == 0)){
                   // 2. if prev is +ve and same, keep none
                  stack.pop();
              }
              else if(stack.isEmpty() || stack.peek() < 0){
                   // 3. if prev is also -ve keep both
                  stack.push(ast);
              }
              // 4. if prev +ve and greater than this, keep prev and ignore this. i.e do nothing
          }
      }
      
      int len = stack.size()-1;
      int[] res = new int[len+1];   
      while(!stack.isEmpty()){
          res[len--] = stack.pop();
      } 

      return res;
        
    }

}
