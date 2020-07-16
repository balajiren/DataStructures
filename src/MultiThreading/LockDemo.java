package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Philosopher
	{
		Lock lock;
		boolean ifleftPicked = false;
		boolean ifRightPicked = false;
		
		Philosopher()
		{
			lock = new ReentrantLock();
		}
		
		public void pickUpLeftFork()
		{
			lock.lock();
			ifleftPicked = true;
		}
		public void dropLeftFork()
		{
			
			ifleftPicked = false;
			lock.unlock();
		}
		
	}
	
	

}
