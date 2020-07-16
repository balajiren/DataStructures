package Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class Person implements Comparable<Person> {
	
	public static void main(String args[])
	{
		ArrayList<Person> lst = new ArrayList<Person>();
		Person person = new Person();
		person.age = 1;
		Person person2 = new Person();
		person.age = 100;
		lst.add(person);
		lst.add(person2);
		lst.sort(Person.PersonComparator);
	    //System.out.print(Arrays.toString(lst.toArray()));
	}
	
	public static Comparator<Person> PersonComparator = new Comparator<Person>() {
		
		@Override
		public int compare(Person o1, Person o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
	};
	
	
	public String name;
	public int age;
	
	@Override
	public int compareTo(Person person) {
		// TODO Auto-generated method stub
		if( person.name == this.name)
		{
			return 1;
		}
		return -1;
	}

}
