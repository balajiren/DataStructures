package DeckOfCards;

import java.util.ArrayList;
import java.util.List;

import DeckOfCards.Suite.SuiteType;

public class DeckOfCards {

	private static int DeckSize = 52;
	static List<Card> cards = new ArrayList<Card>(); 
	
	public DeckOfCards() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   int suiteSize = Math.abs(DeckSize / SuiteType.values().length);
	   Suite suite = new Suite();
	   List<Suite> suites = suite.getSuites();
       for(int i=0; i<suites.size();i++)
       {
    	   Card card = null;
    	   for(int j=0;j<suiteSize;j++)
    	   
    		    card = new Card(suites.get(i), j);
    	        cards.add(card);
       }
		
       System.out.print(cards);

	}
	

	
	
	

}


