 package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class  MergeArrayContainer implements Comparable<MergeArrayContainer>
{
	int[] _arr;
	int _index;
	public MergeArrayContainer(int[]arr, int index)
	{
		_arr = arr;
		_index = index;
	}
	
	@Override
	public int compareTo(MergeArrayContainer o)
	{
		return this._arr[this._index] - o._arr[o._index];
	}
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = MergeKSorted(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));

	}
	
	
	public static int[] MergeKSorted(int[][] arr)
	{
		
		PriorityQueue<MergeArrayContainer> queue = new PriorityQueue<MergeArrayContainer>();
		int total = 0;
		

		for(int i=0;i<arr.length;i++)
		{
			MergeArrayContainer container = new MergeArrayContainer(arr[i],0);
			queue.add(container);
			total +=arr[i].length;
		}
		
		int[] results = new int[total];
		int resultIndex=0;
		while(queue.size() > 0)
		{
			
			MergeArrayContainer cont = queue.poll();
			System.out.print(Arrays.toString(cont._arr));
			results[resultIndex++] = cont._arr[cont._index];
			if(cont._index < cont._arr.length-1)
			{
				queue.add(new MergeArrayContainer(cont._arr, cont._index+1));
			}
			
			
			
		}
		
		return results;
	}
	

	//Me
	/*public ListNode mergeKLists(ListNode[] lists) {
	    if(lists==null||lists.length==0)
	        return null;
	 
	    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
	        public int compare(ListNode l1, ListNode l2){
	            return l1.val - l2.val;
	        }
	    });
	 
	    ListNode head = new ListNode(0);
	    ListNode p = head;
	 
	    for(ListNode list: lists){
	        if(list!=null)
	            queue.offer(list);
	    }    
	 
	    while(!queue.isEmpty()){
	        ListNode n = queue.poll();
	        p.next = n;
	        p=p.next;
	 
	        if(n.next!=null)
	            queue.offer(n.next);
	    }    
	 
	    return head.next;
	 
	} */

}


