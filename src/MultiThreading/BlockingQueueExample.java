package MultiThreading;

import java.util.concurrent.*;

class TestProducer implements Runnable{
	
	BlockingQueue<Integer> queue;
	TestProducer(BlockingQueue<Integer> _queue) {
		queue = _queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
            process();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}
	
	 private void process() throws InterruptedException {

	        // Put 20 ints into Queue
	        for (int i = 0; i < 20; i++) {
	            System.out.println("[Producer] Put : " + i);
	            queue.put(i);
	            System.out.println("[Producer] Queue remainingCapacity : " + queue.remainingCapacity());
	            Thread.sleep(100);
	        }

	    }
	
	
}

class TestConsumer implements Runnable {
	
	BlockingQueue<Integer> queue;
	TestConsumer(BlockingQueue<Integer> _queue) {
		queue = _queue;
	}

	 @Override
	    public void run() {

	        try {
	            while (true) {
	                Integer take = queue.take();
	                process(take);
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }

	    }
	 
	 private void process(Integer take) throws InterruptedException {
	        System.out.println("[Consumer] Take : " + take);
	        Thread.sleep(500);
	    }

	   
	
}

public class BlockingQueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

	        new Thread(new TestProducer(queue)).start();
	        new Thread(new TestConsumer(queue)).start();

	}
	
	

}
