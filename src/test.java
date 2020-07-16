
import java.util.*;
public class test {

	public static void main(String[] args) {
	  System.out.println(solution(1));

	}
	
	public static int solution(int N) {
        // write your code in Java SE 8
		if(N >=Integer.MAX_VALUE || N <= Integer.MIN_VALUE || N == 0)
		{
			return 0;
		}
        char[] numarray = Integer.toBinaryString(N).toCharArray();
        Integer position = 0;
        List<Integer> postList = new ArrayList<Integer>();
        for(char i : numarray)
        {
         
            if(i == '1')
            {
               postList.add(position);
            }
            position+=1;
            
        }
        Integer maxGap  = 0;
        Integer Gap = 0;
        if(postList.size() == 1)
        {
        	return 0;
        }
        for(Integer a : postList)
        {
          
        	 if(a == 0)
        	 {
        		   Gap = postList.get(postList.indexOf(a)+1)  - 1;
        	 }
        	 else
        	 {
        		  Integer pos = postList.indexOf(a);
        		  if(pos < postList.size()-1)
        		  {
        		     Gap = (postList.get(postList.indexOf(a)+1)  - a)-1;
        		  }
        	 }
            
            if(Gap >  maxGap)
            {
                 maxGap = Gap;
            }
            
            
        }
        return maxGap;
    }

}
