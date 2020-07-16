package ArrayQuestions;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean IsBadVersion(int v)
	{
		if(v%10 == 0)
		{
			return true;
		}
		return false;
	}
	
	public static int FirstBadVersion(int[] versions, int start, int end)
	{
		int mid = start + (end - start)/2;
		if(start >=end)
		{
			return start;
		}
		
		if(IsBadVersion(mid))
		{
			return FirstBadVersion(versions, start, mid);
		} else
		{
			return FirstBadVersion(versions, mid+1,end);
		}
	    
		
	}

}
