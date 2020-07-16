package Sorting;

import java.util.*;
import Sorting.NestedInteger;

public class DeepNestedIterator implements Iterator<Integer> {

	private  static Stack numstack = new Stack();
	private static Integer top = null;
	public static void main(String[] args) {
		NestedInteger list1 = new NestedInteger();
		list1.add(new NestedInteger(8));
		list1.add(new NestedInteger(4));
		List<NestedInteger> lst = new ArrayList<>();
		lst.add(list1);
		DeepNestedIterator result = new DeepNestedIterator(lst);
		while(result.hasNext())
		{
			System.out.println(result.next());
		}

	}

	Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
	Integer current;

	public DeepNestedIterator(List<NestedInteger> nestedList) {
		if(nestedList==null)
			return;

		stack.push(nestedList.iterator());
	}

	@Override
	public Integer next() {
		Integer result = current;
		current = null;
		return result;
	}

	@Override
	public boolean hasNext() {
		while(!stack.isEmpty() && current==null){
			Iterator<NestedInteger> top = stack.peek();
			if(!top.hasNext()){
				stack.pop();
				continue;
			}

			NestedInteger n = top.next();
			if(n.isInteger()){
				current = n.getInteger();
				return true;
			}else{
				stack.push(n.getList().iterator());
			}
		}

		return false;
	}

}
