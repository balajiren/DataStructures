package String;

public class IsSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int index = IsSubSequence("la","balaji");
		System.out.println(index);
	}
	
	public static int IsSubSequence(String source, String target)
	{
		
		int i = 0;
		int j = 0;
		int targetLen = target.length();
		while( i < source.length() && j < targetLen)
		{
			if(source.charAt(i) ==  target.charAt(j))
			{
				i++;
				
			}
			j++;

			if(i == source.length())
			{
			  return j-i;
			}
			
			
			
		}
		
		return -1;
		
	}

}
