package Social_Graph;
import java.util.*;

public class Person {
	
	int id;
	String name;
	List<Integer> friendIds;
	Person(int _id, List<Integer> _friendIds) {
		this.id = _id;
		this.friendIds = _friendIds;	

	}

}
