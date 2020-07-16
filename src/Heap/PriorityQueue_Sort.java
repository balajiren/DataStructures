package Heap;

import java.util.*;
import java.util.PriorityQueue;

class Entry {
	
	String value;
	Entry(String _value) {
		value = _value;
	}
	
	
}

public class PriorityQueue_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortValue();


	}
	public static void SortValue() {
		
		
		@SuppressWarnings("unchecked")
		
		PriorityQueue<Entry> pq = new PriorityQueue<Entry>((x,y) -> y.value.compareTo(x.value));
		
		pq.offer(new Entry("swathi"));
		pq.offer(new Entry("balaji"));
		pq.offer(new Entry("nethra"));
		
		while(pq.size() > 0) {
			System.out.print(pq.poll().value);
		}
		
	}

}
