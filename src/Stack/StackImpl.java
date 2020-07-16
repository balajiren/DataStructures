package Stack;

import java.lang.reflect.Array;

public class StackImpl<E> {

	public static void main(String[] args) {
		 
		//StackImpl<String> stack = new StackImpl<String>(String[].class, 11);
		//week typing
		StackImpl<String> stack = new StackImpl<String>(11);
		stack.push("hello");
		stack.push("world");
 
		System.out.println(stack.peek());
 
		stack.pop();
		System.out.println(stack.peek());
 
		stack.pop();
		System.out.println(stack.peek());
	}
	
	private E[] arr = null;
	private int size = 0;
	private int top = -1;
	private int maxSize;
	
	
	//public StackImpl(Class<E[]> type,int cap)
	public StackImpl(int cap)
	{
		
		this.maxSize = cap;

		//this.arr = (E[]) Array.newInstance(type, cap);
		this.arr = (E[]) new Object[cap];
	}
	
	public boolean push(E element)
	{
		if(isFull())
		{
			return false;
		};
		
		this.size++;
		this.arr[++top] = element;
		return false;
	}
	public E peek()
	{
		if(this.size == 0)
		{
			return null;
		}
		return arr[top];
	}
	public E pop()
	{
		if(this.size == 0)
		{
			return null;
		}
		this.size--;
		E result = this.arr[top];
		this.arr[top] = null;
		this.top--;
		return result;
		
	}
	
	public boolean isFull()
	{
		return size== maxSize;
	}

}
