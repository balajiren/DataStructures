package String;

public class ReplaceSpaces {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		String str = "b a l";
		replaceSpaces(str.toCharArray(),str.toCharArray().length-1);
	}

	
	public void replaceAll( String str )
	{
	    String temp = str.trim();

	    char[] arr = temp.toCharArray();
	    StringBuffer sb = new StringBuffer();

	    for( int i = 0; i < arr.length; i++ )
	    {
	        if( arr[i] == ' ' )
	        {
	            sb.append( "%20" );
	        }
	        else
	        {
	            sb.append( arr[i] );
	        }
	    }
	}
	
public static String ReplaceSpace(String input, String placeholder)  {
		
		char[] chars = input.toCharArray();
		int size = input.length();
		String output= "";
		StringBuilder builder = new StringBuilder(size);
		
		for(char c : chars) 
		{
			if(chars[c] == ' ') {
						builder.append(String.valueOf(placeholder));

			}
		}
		
		return builder.toString();
		
	}

	
	public static char[] replaceSpaces(char[] str, int length)
	{
		int spaceCount=0,newlength,i;
		for(i=0;i<str.length;i++)
		{
			if(str[i] == ' ')
			{
				spaceCount++;
			}
		}
		newlength = spaceCount + length * 2;
		
		str[newlength] = '\0';
		for(i=length-1;i>=0;i--)
		{
			if(str[i] == ' ')
			{
				str[newlength-1] = '0';
				str[newlength-1] = '2';
				str[newlength-1] =  '%';
				newlength = newlength-3;
			}
			else
			{
				str[newlength-1] = str[i];
				newlength = newlength-1;
					
			}
		}
		return str;
	}
}
