package ArrayQuestions;
import java.util.*;



public class TestHash {

public static void  main(String args[])
{
	
	TestHash h = new TestHash();
	System.out.println(h.TestSet());
	
}
public class Country
	{
		String name;
		Country(String _name)
		{
			name = _name;
		}
		
		
	}

	public int TestSet()
	{
		Set<Country> c = new HashSet<Country>();
		Country c1 = new Country("India");
		Country c2 = new Country("USA");
		c.add(c1);
		c.add(c2);
		//c.remove(c2);
		return c.size();
		
		
		
		
		
	}
}


