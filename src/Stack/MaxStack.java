package Stack;

	import java.util.Collections;
	import java.util.LinkedList;
	import java.util.PriorityQueue;

	
	public class MaxStack<T> {

		 public static void main(String[] args) {
		        MaxStack<Integer> stack = new MaxStack<Integer>();
		        int[] arr = {3, 1, 2, 4, 6, 5};
		        for (Integer n: arr) {
		            stack.push(n);
		        }
		        System.out.println(stack.popMax());  // 6
		        System.out.println(stack.popMax());  // 5
		        System.out.println(stack.popMax());  // 4
		        System.out.println(stack.pop());     // 2
		        System.out.println(stack.popMax());  // 3
		    }
		 
	    LinkedList<T> stack;
	    PriorityQueue<T> maxHeap;

	    public MaxStack() {
	        stack = new LinkedList<T>();
	        maxHeap = new PriorityQueue<T>(10, Collections.reverseOrder());  // reverse order
	    }

	    public void push(T n) {
	        stack.addLast(n);
	        maxHeap.offer(n);
	    }

	    public T pop() {
	        T num = stack.removeLast();
	        maxHeap.remove(num);
	        return num;
	    }

	    public T top() {
	        return stack.peekLast();
	    }

	    public T peekMax() {
	        return maxHeap.peek();
	    }

	    public T popMax() {
	        T num = maxHeap.poll();
	        stack.remove(num);
	        return num;
	    }
	}
	   