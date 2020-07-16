package Sorting;

import java.util.Arrays;

  class MinHeapUtil {
	
	public int capacity = 10;
	public int size = 0;
	
	int[] items = new int[capacity];
	
	public int getleftChildIndex(int pos)
	{
		return 2 * pos + 1;
	}
	
	public int getRightChildIndex(int pos)
	{
		return 2 * pos + 2;
	}
	
	public int getParentIndex(int childIndex)
	{
		return (childIndex-1/2);
	}
	
	public boolean hasleftChild(int index)
	{
		return getleftChildIndex(index) < size;
	}
	
	public boolean hasRightChild(int index)
	{
		return getRightChildIndex(index) < size;
	}
	public boolean hasParent(int index)
	{
		return getParentIndex(index) >=0;
	}
	public int getleftChild(int index)
	{
		return items[getleftChildIndex(index)];
	}
	public int getRightChild(int index)
	{
		return items[getRightChildIndex(index)];
	}
	public void ensureExtraCapacity()
	{
		if(size == capacity)
		{
			items = Arrays.copyOf(items, capacity * 2);
			capacity *=2;
		}
	}
    public void swap(int i, int j)
    {
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp; 
    }    

}
 
public class MinHeap
{
	MinHeapUtil util = new MinHeapUtil();
	public int peek() throws Exception
	{
		if(util.items == null)
		{
			throw new Exception("EMPTY");
		}
		return util.items[0];
	}
	
	public int poll()
	{
		int item = util.items[0];
		util.items[0] = util.items[util.size-1];
		util.size--;
		heapifyDown();
		return item;
		
	}
	
	public void add(int item)
	{
		util.ensureExtraCapacity();
		util.items[util.size]=item;
		util.size++;
		heapifyUp();
		
	}
	
	//left child = index * 2 + 1;
	//right child = index * 2 +2 ;
	//parent = index - 1/2;
	

	//moves last element to the root of the tree
	public void heapifyUp()
	{
		int index = util.size-1;
		while(util.hasParent(index))
		{
			util.swap(util.getParentIndex(index),index);
			index = util.getParentIndex(index);
		}
		
	}
	
	public void heapifyDown()
	{
		int index = 0;

		while( util.hasleftChild(index))
		{
		int smallerIndex = util.getleftChildIndex(index);
		if(util.getRightChild(index) < util.getleftChild(index))
		{
			smallerIndex = util.getRightChildIndex(index);
		}
		if(util.items[index] < util.items[smallerIndex])
		{
			//nothing return
		} else
		{
			util.swap(index, smallerIndex);
		}
		index  = smallerIndex;
		
		}
		
	}
	
}
