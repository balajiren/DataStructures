package ArrayQuestions;

import java.util.LinkedList;

public class MovingAverageFromStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class MovingAverage
	{
		LinkedList<Integer> queue;
		int size;
		double avg;
		
		MovingAverage(int size)
		{
			queue = new LinkedList<Integer>();
			this.size = size;
		}
		
		public double next(int val)
		{
			
			if(queue.size() < this.size)
			{
				queue.offer(val);
				int sum = 0;
				for(int i : queue)
				{
					sum+=i;
				}
				avg =  (double) sum / queue.size();
				
			}
			
			else
			{
				int head = queue.poll();
				double minus = (double)head/this.size;
				queue.offer(val);
				double add  = (double)val/this.size;
				avg = avg+add-minus;
				
				
			}
			
			return avg;
		}
		
		
	}

}
