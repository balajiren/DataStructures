package Heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//Max heap is the default
//Use collections.reverse for minheap
public class CustomPQ  implements Comparable<CustomPQ>{

	public int pIndex;
	
	CustomPQ(int _pIndex)
	{
		pIndex = _pIndex;
	}
	PriorityQueue<ArrayContainer> P1 = new PriorityQueue<ArrayContainer>(new PQComparator() {
	
		public int compare(ArrayContainer o2, ArrayContainer o1) {
			return o2.index - o1.index;
		}
	});
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<CustomPQ> pq1 = new PriorityQueue<CustomPQ>(Collections.reverseOrder());
		PriorityQueue<CustomPQ> pq = new PriorityQueue<CustomPQ>(new Comparator<CustomPQ>() {

			@Override
			public int compare(CustomPQ o1, CustomPQ o2) {
				// TODO Auto-generated method stub
				return o1.pIndex - o2.pIndex;
			}
			
		});

		pq.offer(new CustomPQ(2));
		pq.offer(new CustomPQ(9));
		while(pq.size() > 0)
		{
			CustomPQ q = pq.poll();
			System.out.println(q.pIndex);
			
		}

	}
	
	public class ArrayContainer
	{
		int index;
		int value;
		
	}
	
	public class PQComparator implements Comparator<ArrayContainer>
	{

		@Override
		public int compare(ArrayContainer o1, ArrayContainer o2) {
			// TODO Auto-generated method stub
			return o1.index - o2.index;
		}

		
	}

	@Override
	public int compareTo(CustomPQ o) {
		// TODO Auto-generated method stub
		return o.pIndex - this.pIndex;
	}

}
