package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostFixEvaluation {

	public PostFixEvaluation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int result  = Evaluate("21+3*");
		System.out.print(result);
		

	}
	
	public static int Evaluate(String s)
	{
		
		Stack<Integer> stack = new Stack<Integer>();
		List<Character> Operators =new ArrayList<Character>();
		Operators.add('+');
		Operators.add('-');
		Operators.add('*');
		Operators.add('/');
		char[] arr  = s.toCharArray();
		
		for(int i=0;i<arr.length;i++)
		{
			if(Character.getNumericValue(arr[i]) > 0 && Character.getNumericValue(arr[i]) < 9)
			{
				stack.push(Character.getNumericValue(arr[i]));
			}
			if(Operators.contains(arr[i]))
			{
				Integer v1  = stack.pop();
				Integer v2  = stack.pop();
			    switch(arr[i])
			    {
			      case  '+' :
					{
			    	  stack.push(v1+v2);
					}
					break;
			       case  '-' :
					{
			    	  stack.push(v1-v2);
					}
					break;
			       case  '*' :
					{
			    	  stack.push(v1*v2);
					}
					break;
					
			       case  '/' :
					{
			    	  stack.push(v1/v2);
					}
					break;
			    }
			 	
				
			}
		}
		int result = stack.pop();
		return result;
		
	}
	

}
