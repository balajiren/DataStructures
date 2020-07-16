package Social_Graph;
import java.util.*;

public class PersonServer {
	
	List<Person> lstPeople;
	PersonServer() {
		lstPeople = new ArrayList<Person>();
	}
	public void addPeople(List<Integer> ids) {
		
		for(int id : ids) {
			Person p = new Person(id,null);
			lstPeople.add(p);
			
				
		}
	}

}
