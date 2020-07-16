package Deque;

import java.util.*;

public class LogRateLimiter {
	
	public static final String YES = "YES";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Pair<U, V> {
		  public U first;
		  public V second;

		  public Pair(U first, V second) {
		    this.first = first;
		    this.second = second;
		  }
		}
	
	LinkedList<Pair<String,Integer>> logQue = new LinkedList<Pair<String,Integer>>();
	Set<String> messageSet = new HashSet<String>();
	
	LogRateLimiter() {
		
	}
	
	public boolean shouldPrintMessage(int timestamp, String message) {
		
		//prune the head
		while(logQue.size() > 0) {
			
			Pair<String,Integer> head = logQue.getFirst();
			if (timestamp - head.second > 10) {
				logQue.removeFirst();
				messageSet.remove(head.first);
				
			} else {
				break;
			}
			
		}
	
		if(!messageSet.contains(message)) {
			
			logQue.add(new Pair(message,timestamp));
			messageSet.add(message);
			return true;
			
		}
		
		return false;
		
	}

}
