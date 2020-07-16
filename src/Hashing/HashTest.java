package Hashing;
import java.util.*;



class A {
	int id;
}

class B {
	int id;
}

public class HashTest {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test();
	}
	
	public static void Test() {
		
		Set set = new HashSet();
	    A a = new A();
	    B b = new B();
	    set.add(a);
	    set.add(b);
	    System.out.println(set.size());
		set = new HashSet();
	    set.add(b);
	    set.add(a);
	    System.out.println(set.size());
		
		
		
	}

}
