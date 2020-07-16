package RuleEngine;

public class NullActionDispatcher implements ActionDispatcher{
	 @Override
	    public void fire()
	    {
	        // send patient to in_patient
	        System.out.println("Send patient to IN");
	    }
}
