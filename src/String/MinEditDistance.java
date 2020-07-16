package String;

public class MinEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = FindMinEditDistance("eternal","emernel");
		System.out.println(result);

	}
	//TIME COMPLEXITY & SPACE COMPLEXITY - M * N
	public static int FindMinEditDistance(String s, String t)
	{
		int m  = s.length();
		int n = t.length();
		int maxlen = 0;
		if(s.length() >t.toString().length())
		{
			maxlen = n;
		} else
		{
			maxlen = m;
		}
		int editDistance = 0;
		int i=0;
		int j = 0;
		while(i < m && j < n)
		{
			 if(s.charAt(i) == t.charAt(j))
			 {
				 i++;
				 j++;
			 }
			 else
			 {
				 editDistance++;
				/* if(editDistance > 1)
				 {
					 break;
				 } */
				 if(m > n)
				 {
					 i++;
				 } else if(m < n)
				 {
					 j++;
				 } else
				 {
					 i++;
					 j++;
				 }
			 }
			 
		}
			
		if(i < m || j < n)
		 {
			 editDistance++;
		 }
		
		return editDistance;
	
	}

}
