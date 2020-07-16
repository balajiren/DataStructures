package MultiThreading;

import java.util.Vector;

public class ProducerConsumer {

	public ProducerConsumer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		Vector sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
        prodThread.start();
        consThread.start();


	}
}
