package RuleEngine;

import java.util.HashMap;
import java.util.Map;

public class Entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // create a singleton container for operations
        Operations operations = Operations.INSTANCE;

        // register new operations with the previously created container
        operations.registerOperation(new And());
        operations.registerOperation(new Equals());
        operations.registerOperation(new Not());

        // defines the triggers when a rule should fire
        Expression ex3 = ExpressionParser.fromString("PATIENT_TYPE = 'A' AND NOT ADMISSION_TYPE = 'O'");
        Expression ex1 = ExpressionParser.fromString("PATIENT_TYPE = 'A' AND ADMISSION_TYPE = 'O'");
        Expression ex2 = ExpressionParser.fromString("PATIENT_TYPE = 'B'");

        // define the possible actions for rules that fire
        //ActionDispatcher inPatient = new InPatientDispatcher();
       //ActionDispatcher outPatient = new OutPatientDispatcher();

        // create the rules and link them to the accoridng expression and action
        Rule rule1 = new Rule.Builder()
                            .withExpression(ex1)
                            //.withDispatcher(outPatient)
                            .build();

        Rule rule2 = new Rule.Builder()
                            .withExpression(ex2)
                            .withExpression(ex3)
                            //.withDispatcher(inPatient)
                            .build();

        // add all rules to a single container
        Rules rules = new Rules();
        rules.addRule(rule1);
        rules.addRule(rule2);

        // for test purpose define a variable binding ...
        Map<String, String> bindings = new HashMap<>();
        bindings.put("PATIENT_TYPE", "'A'");
        bindings.put("ADMISSION_TYPE", "'O'");
        // ... and evaluate the defined rules with the specified bindings
       // boolean triggered = rules..eval(bindings);
        //System.out.println("Action triggered: "+triggered);

	}

}
