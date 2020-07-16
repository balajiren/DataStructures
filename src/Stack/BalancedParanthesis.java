package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesis {

	public BalancedParanthesis() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(isBalanced("{(([])[])[]]}"));

	}
	
	private static String isBalanced(String s) {
		if(s.length() > 0)  {
		       Map<Character,Character> charMap = new HashMap<Character,Character>();
		           charMap.put('{','}');
		           charMap.put('[',']');
		           charMap.put('(',')');
		           
		           Stack<Character> st = new Stack<Character>();
		           for(int i=0;i<s.length();i++) {
		               char c = s.charAt(i);
		               if(charMap.containsKey(c))  {
		            	   st.push(c);
		               } else {
		            	   if(st.size() > 0 && charMap.get(st.peek()) == c) {
		            		   st.pop();
		            	   }
		               }
		               
		               
		           }
		           if (st.size()  == 0) {
		                return "YES";
		           } 

		     } 
		    System.out.print("NO");
		    return "NO";

	}

	
	private static boolean checkBalancedParentheses(String input){
		Stack<String> stack = new Stack<String>();
		boolean isBalanaced = false;

		for(int i=0; i < input.length(); i++){
			String str = ""+input.charAt(i);		//store characters as String

			//if opening bracket then push into stack
			if(str.equals("(") || str.equals("[") || str.equals("{")){
				stack.push(str);
			}

			//if closing bracket, pop bracket and compare if its a pair
			if(str.equals(")") || str.equals("]") || str.equals("}")){
				//if stack becomes empty in between then also its not balanced
				if(stack.isEmpty()){
					return false;
				}
				String opening = stack.peek();
				if(str.equals(")") && opening.equals("(")){
					stack.pop();
				}
				if(str.equals("]") && opening.equals("[")){
					stack.pop();
				}
				if(str.equals("}") && opening.equals("{")){
					stack.pop();
				}
			}			
		}
		//if stack is empty at end, then its balanced
		if(input.length() > 0 && stack.isEmpty()){
			isBalanaced = true;
		}

		return isBalanaced;
	}

}
