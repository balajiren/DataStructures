package DeckOfCards;

import java.util.ArrayList;
import java.util.List;



public class Suite
{
 
	 private SuiteType suite;
	 
     private List<Suite> suites;
     
     public Suite()
     {
    
    	
     }
     public Suite(SuiteType type)
     {
    	 suite = type;
    	
     }
     public List<Suite> getSuites()
     {
    	 suites = new ArrayList<Suite>();
         for(SuiteType type : SuiteType.values())
         {
        	 Suite suite = new Suite(type);
        	 suites.add(suite);
        	 
         }
         return suites;
     }
     
     
     public enum Day {
    	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    	    THURSDAY, FRIDAY, SATURDAY 
    	}

    	 public enum  SuiteType
    	   {
    	       HEART (1),
    	       CLUBS (2),
    	       SPADE (3),
    	       DIAMOND (4);
    		 private final int suiteType;
    		 SuiteType(Integer _suiteType)
    		 {
    			 suiteType = _suiteType;
    		 }
    	   }
	
	
}

