package MultiThreading;

public class QueueObject {

	private boolean isNotified = false;
	
	public synchronized void doWait() throws InterruptedException 
	{
		while(!isNotified)
		{
			this.wait();
		}
		this.isNotified = false;
		
	}
	
	public synchronized void doNotify()
	{
		
		if(!isNotified)
		{  
			 this.isNotified = true;
			 this.notify();
			
		}
		
	}

	
}
