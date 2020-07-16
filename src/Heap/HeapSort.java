package Heap;


public class HeapSort {

	public static void main(String args[])
	{
		int[] array = new int[]{4, 10, 3, 5, 1};
		   
		  new HeapSort().Sort(array);
		   
		  for (int i : array) {
		   System.out.print(i + " ");
		  } 
	}
	
	
	public static void Sort(int[] data)
	{
		int size = data.length;
		for(int i=data.length/2-1; i>= 0 ; i--)
		{
			Heapify(i,data,size);
	
		}
		
		for(int i=data.length-1; i>= 0 ; i--)
		{
			int temp = data[i];
			data[i] = data[0];
			data[0] = temp;
			
			size = size-1;
			
			Heapify(0,data,size);		
					
		}
		
	}
	
	public static int GetLeftChild(int i)
	{
		return 2 * i+1;
	}
	
	public static int GetRightChild(int i)
	{
		return 2 * i+2;
	}
	public static void Heapify(int i, int[] data, int size)
	{
		int largestElementIndex = i;
		int leftChildIndex = GetLeftChild(i);
		int rightChildIndex = GetLeftChild(i);
		if(leftChildIndex < size && data[leftChildIndex] > data[largestElementIndex])
		{
			largestElementIndex = leftChildIndex;
		}
		if(rightChildIndex < size && data[rightChildIndex] > data[largestElementIndex])
		{
			largestElementIndex = rightChildIndex;
		}
		if(largestElementIndex != i)
		{
			int temp = data[i];
			data[i] = data[largestElementIndex];
			data[largestElementIndex] = temp;
			Heapify(largestElementIndex,data,size);
		}
		
		
	}
	
}


