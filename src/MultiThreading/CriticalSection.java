package MultiThreading;

public class CriticalSection {
	
	//threads will wait to execute
	private Integer sum1Lock = new Integer(1);
	public void add(int num1, int num2) {
		synchronized(sum1Lock) {
			
		}
		
	}
	 public void test() {
		 System.out.println("Lambda Runnable running");
	 }
	
	 
	 
	public static void main(String[] args) {
		CriticalSection section = new CriticalSection();
		section.test();
		Runnable task = () -> {section.test();};
		Thread t1 = new Thread(task);
		t1.start();
		
	}

}
