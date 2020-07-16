 package String;

public class ReplaceDupString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String output = ReplaceDupStrings("bbcaeefg");
        System.out.println(output);
	}
	
	
	public static String Reverse(char[] s)  
	{
		int i=0;
		for(int j=0;j<s.length;j++)
		{
			if(s[j] == ' ')
			{
				reverse(s,i,j-1);
				i=j+1;
			}
		}
		 reverse(s, i, s.length-1);
		 
		 reverse(s, 0, s.length-1);
		return s.toString();
	}
	
	public static void reverse(char[] s, int start, int end)
	{
		while(start < end) 
		{
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
			
		}

	}
	
	public static String ReplaceDupStrings(String input)
	{
	   char[] St = new char[input.length()];
	   int j = input.length()-1;
	   int swaps = 0;
	   for(int i=0;i<input.length()-swaps;i++)
	   { 
	       
	       if(i==0)
	       {
	         St[i] = input.charAt(i);
	       
	       }
	       else if(i>=1)
	       {
		       if(St[i-1] == input.charAt(i))
		       {
		         St[i] = input.charAt(j);
		         St[j] = input.charAt(i);
		         j--;
		         swaps++;
		         
		       }
		       else
		       {
		    	   St[i] = input.charAt(i);
		       }
	       }
	 
	   }
	   return String.valueOf(St);
	 }



}
