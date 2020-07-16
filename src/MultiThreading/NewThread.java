package MultiThreading;

import Common.Utils;

public class NewThread implements Runnable {

	static volatile int x =0 , y =0;
	public NewThread() {
		// TODO Auto-generated constructor stub
	}
	
	public void run()
	{
	  Utils.PrintMessage(Thread.currentThread().getName()+"dfdf");
	   
	}
	
	
	static synchronized void method1()
	{
		x++; 
		y++;
		
	}
	
	static synchronized void method2()
	{
		System.out.println("x=" + x + " y=" + y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread()
		{
			public void run()
			{
				 for(int i=0; i<10;i++)
                     method1();
			}
		};
		
		
		Thread t2 = new Thread()
		{
			public void run()
			{
				 for(int i=0; i<10;i++)
                     method2();
			}
		};
		
		t1.start();
		t2.start();

	}

}
