package ArrayQuestions;

import java.util.List;

interface NestedInteger
{
	public boolean isInteger();
	public Integer getInteger();
	public List<NestedInteger> getList();
}

public class NestedListWeightSum
{
	
	public int NestedListWeightSum(List<NestedInteger> input, int sum,int depth) {
		
		if(input.size() == 0)
		{
			return sum;
		}
         for(NestedInteger nestedInt: input)
         {
        	 if(nestedInt.isInteger())
        	 {
        		 sum += nestedInt.getInteger();
        	 }
        	 else
        	 {
        		 sum+=NestedListWeightSum(nestedInt.getList(), sum, depth+1);
        	 }
         }
         return sum;
	}

	
}


