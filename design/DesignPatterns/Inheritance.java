package DesignPatterns;


class BaseClass  {
	
	BaseClass(int x) {
		System.out.println("in base class constructor");
	}
	
	BaseClass() {
		System.out.println("in base class default constructor");
	}
	
}


class DerivedClass extends BaseClass {
	
	DerivedClass(int x) {
	
		System.out.println("in derived class constructor");
	}
	
	DerivedClass() {
		super(2);
		System.out.println("in derived class default constructor");
	}
	
	public int Test() {
		return 1;
	}
	
}

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DerivedClass dc = new DerivedClass();
		dc.Test();

	}
	


}
