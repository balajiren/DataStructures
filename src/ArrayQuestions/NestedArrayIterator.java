package ArrayQuestions;
import java.util.*;

public class NestedArrayIterator implements Iterator<Integer>{

	public interface NestedInteger
	{
		public boolean IsInteger();
		public Integer getInteger();
		public List<Integer> getList();
	}
	
	Stack nestedStack;
    Integer top;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	NestedArrayIterator(List<NestedInteger> inputlist)
	{
		nestedStack = new Stack<>();
		nestedStack.push(inputlist.iterator());
		top  = null;
		
		
	}
	
	public boolean hasNext()	
	{
		if(top !=null)
		{
			return true;
		}
		while(nestedStack.size() > 0)
		{
			Iterator iter = (Iterator) nestedStack.peek();
			if(iter.hasNext())
			{
				NestedInteger curr = (NestedInteger) iter.next();
				if(curr.IsInteger())
				{
					top = curr.getInteger();
					return true;
				} else
				{
					nestedStack.push(curr.getList().iterator());
				}
				
				
			}
			//Iterator has reached the array size then pop out the iterator as there will be no elements
			else
			{
				nestedStack.pop();
			}
		}
	
		return false;
	}
	
	public Integer next()
	{
      Integer result  = null;
	  if(top !=null)		
	  {
		  result = top;
		  top  = null;

	  }
	  return result;
	}

}
