package PhoneDirectory;
import java.util.*;

public class Directory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int maxValue = 0;
    Queue<Integer> queue;
    Set<Integer> notGiven;
    int currNumber = 0;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public Directory(int maxNumbers) {
        this.maxValue = maxNumbers;
        this.queue = new LinkedList<Integer>();
        this.notGiven = new HashSet<Integer>();
        int i = 0;
        while(i < maxNumbers) {
            this.queue.offer(i);
            this.notGiven.add(i);
            i++;
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        // Use case 1.
        if(!this.queue.isEmpty()) {
            int res = this.queue.remove();
            notGiven.remove(res);
            return res;
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number > this.maxValue || !this.notGiven.contains(number)) return false;
        return true;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!this.notGiven.contains(number)){
            this.queue.offer(number);
            this.notGiven.add(number);
        }
    }

}
