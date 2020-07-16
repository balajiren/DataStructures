package ArrayQuestions;

public class SearchRotatedArray {

	public SearchRotatedArray() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String args[])
	{
		int[] in = new int[] {4, 5, 6 ,7 ,0, 1, 2};
		boolean value = SearchRotatedArray(in, 0,in.length-1,1);
		System.out.println(value);
		
	}
	
	 private static boolean SearchRotatedArray(int[] a,int l, int r, int key)
	    {
	        
	      while(r>=l)
	    {
	        int m = (l+r)/2;

	        if(a[m]==key) return true;

	        if(a[l] < a[m])
	        {

	            if(a[m] > key && key >= a[l])
	                r=m-1;
	            else
	                l=m+1;
	        }
	        else
	        {


	            if(a[m] < key && key<=a[r])
	            {
	                l=m+1;
	            }
	            else
	                r=m-1;
	        }
	    }
	    return false;
	    }
	    
}
