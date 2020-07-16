package Sorting;

public class HeapSortImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		
		public void Sort(int[] arr)
		{
		  int n = arr.length;
		  for(int i=n/2-1;i>0;i--)
		  {
			  heapify(arr, n, i);

		  }
		for(int i=n-1;i>0;i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
		}
		
		
	   }
		
		public void heapify(int[] arr, int n, int i)
		{
			int l = 2 * i + 1;
			int r  = 2 * i+ 2;
			int largest = 0;
			
			if(l < n && arr[l] > arr[largest])
			{
				largest = arr[l];
			} 
			if(r < n && arr[r] > arr[largest])
			{
				largest = arr[r];
			}
			
			if(largest!=i)
			{
				int temp = arr[i];
				arr[i] = arr[largest];
				arr[largest] = temp;
				heapify(arr, n, largest);
				
			}
			
			
		}

}
