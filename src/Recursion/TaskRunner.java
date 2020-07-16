package Recursion;

public class TaskRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunTasks();
	}
	
	public static void RunTasks()
	{
		
		String[] tasks = new String[]{"A","B","C"};
		
		int[] Intervals = new int[]{0,3,1};
		
		RunTask(tasks,Intervals,1,12);
		
	}
	
	
	public static void RunTask(String[] tasks, int[] intervals,int currentTaskCount,int currentTime)
	{
		
		int i =0;
		int count = tasks.length;
		if(currentTaskCount == tasks.length)
		{
			System.out.print(currentTime);
			return;
		}
		System.out.print(currentTime);
		// current task
		//if(taskLength == tasks.length)
		//{
	    
		//}
	    
		
		for(i=currentTaskCount;i< tasks.length;i++)
		{
				
				RunTask(tasks,intervals,i+1,currentTime+intervals[i]);
	
			
		}
		
		
	}

}
