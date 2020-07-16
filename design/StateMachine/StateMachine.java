package StateMachine;

public class StateMachine {
	
	private State state;
	
	public static void main(String args[])
	{
		StateMachine m = new StateMachine();
		m.ProcessState("START");
	}
	
	StateMachine()
	{
		state = state.START;
	}
	
	public void ProcessState(String param)
	{
		state = state.doSomething(param);
		
		
	}

}
