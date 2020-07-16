package StateMachine;

public enum State {
	
	START
	{
		@Override
		State doSomething(String aParameter) {
            System.out.println("Doing Something in INITIAL state and jumping to NEXT_STEP, argument = " + aParameter);
            return NEXT_STEP;
        }
		
	},
	NEXT_STEP
	{
		@Override
		State doSomething(String aParameter) {
            System.out.println("Doing Something in INITIAL state and jumping to NEXT_STEP, argument = " + aParameter);
            return this;
        }
		
	};
	
	abstract State doSomething(String input);
	
}

