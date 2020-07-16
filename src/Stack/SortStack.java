package Stack;

import java.util.Stack;

public class SortStack {

	//O(n^2) and o(n) space
	public static Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> res= new Stack<Integer>();
		while(!s.empty())
		{
			int temp = s.pop();
			while(!res.empty()&& res.peek() > temp)
			{
				s.push(res.pop());
			}
			res.push(temp);
		}
		
		return res;
		
	}

}
