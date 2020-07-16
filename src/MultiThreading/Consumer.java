package MultiThreading;

import java.util.Vector;

import Common.Utils;

public class Consumer implements Runnable {

	private final Vector sharedQueue;
	private final int Size;
	public Consumer(Vector _sharedQueue, int _size){
		// TODO Auto-generated constructor stub
		sharedQueue = _sharedQueue;
		Size = _size;
				
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			 try {
				System.out.println("Consumed: " + Consume());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private int Consume() throws InterruptedException
	{
		while(sharedQueue.isEmpty())
		{
			synchronized (sharedQueue) {
				Utils.PrintMessage("Nothing to consume. Emtpty");
				sharedQueue.wait();
			}
			
		}
		synchronized (sharedQueue) 
		{
			sharedQueue.notifyAll();
			return (Integer) sharedQueue.remove(0);
		}
			
	}

}
