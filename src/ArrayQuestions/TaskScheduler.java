package ArrayQuestions;
import java.util.*;

public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int leastInterval(char[] tasks, int n) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char ch : tasks)
	            map.put(ch, map.getOrDefault(ch, 0)+1);
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
	        pq.addAll(map.values());
	        
	        int cycles = 0;
	        while (!pq.isEmpty()) {
	            List<Integer> temp = new ArrayList<>();
	            for (int i = 0; i< n+1; i++) {
	                if (!pq.isEmpty())
	                    temp.add(pq.remove());
	            }
	            //IF MORE THAN SAME TASK THEN ADD THE NEXT TASK BACK TO QUEUE
	            for (int num : temp)
	                if (--num > 0) pq.add(num);
	            cycles += pq.isEmpty()?temp.size():n+1;
	        }
	        return cycles;
	    }

}
