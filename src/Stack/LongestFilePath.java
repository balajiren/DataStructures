package Stack;

import java.util.Stack;

public class LongestFilePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Node
	{
		int level;
		int len;
		Node(int lev, int l)
		{
			this.level = lev;
			this.len = l;
		}
		
	}
	
	public int LongestPath(String input)
	{
		int maxlen= 0;
		String[] names = input.split("\n");
		Stack<Node> st = new Stack<Node>();
		
		for(int i=0;i<input.length();i++)
		{
			int j=0;
			int count = 0;
			String s = names[i];
			while( j < s.length())
			{
				if(s.substring(j,j+1) == "\t")
				{
					count++;
					j++;
				} else
				{
					break;
				}
			}
			if(s.contains("."))
			{
				if(st.isEmpty())
				{
					maxlen = Math.max(maxlen,s.length()-count);
				} else
				{
					maxlen = Math.max(maxlen, st.peek().len+s.length()-count);
				}
			} else
			{
				if(st.isEmpty())
				{
					st.push(new Node(count, s.length()-count+1));
				} else
				{
					st.push(new Node(count, st.peek().len+s.length()-count));
				}
				
			}
			
			
		}
		
		
		
		
		return maxlen;
		
		
	}

}
