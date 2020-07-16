package MultiThreading;

import java.util.Vector;

import Common.Utils;

public class Producer implements Runnable {

	private final Vector sharedQueue;
	private final int Size;
	
	public Producer(Vector queue, int size) {
		// TODO Auto-generated constructor stub
		sharedQueue = queue;
		Size = size;
	}

	
	
	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
               
            }

        }
		
	}
	
	
	public void produce(int i) throws InterruptedException
	{
		
		while(sharedQueue.size() == Size)
		{
			synchronized (sharedQueue) {
				Utils.PrintMessage("Queue is full");
				sharedQueue.wait();
			}
		}
		
		synchronized (sharedQueue) {
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
		
	}

}
