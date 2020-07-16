package CallCenter;

import java.util.Iterator;
import java.util.List;

public class CallHandler implements Iterable{

	
	private static CallHandler instance;
	List<List<Employee>> employeeLevels;
	List<List<Call>> calls;
	
	public enum Level {
		HIGH,
		MEDIUM,
		LOW
	}
	
	public static CallHandler getInstance()
	{
		
		if(instance == null)
		{
			instance = new CallHandler();
			
		}
		return instance;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
	

	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
