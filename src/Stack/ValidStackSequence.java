package Stack;
import java.util.*;
//https://leetcode.com/problems/validate-stack-sequences/
//Given two sequences pushed and popped with distinct values, return true if and only 
//if this could have been the result of a sequence of push and pop operations on an initially empty stack.

//Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//Output: false
//Explanation: 1 cannot be popped before 2.
public class ValidStackSequence {
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();
        
        
        int j=0;
        for(int x :pushed) {
            
            stack.push(x);
            while(!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return j == N;

      
    }

}
