package DesignPatterns;


 interface Shape {
	   void draw();
	}

 class Rectangle implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Inside Rectangle::draw() method.");
	   }
	}
 
  class Square implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Inside Square::draw() method.");
	   }
	}
  
  class Circle implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Inside circle::draw() method.");
	   }
	}

public class Factory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Factory shapeFactory = new Factory();

	      //get an object of Circle and call its draw method.
	      Shape shape1 = shapeFactory.getShape("CIRCLE");

	      //call draw method of Circle
	      shape1.draw();

	}
	
	//use getShape method to get object of type shape 
	   public Shape getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("CIRCLE")){
	         return new Circle();
	         
	      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();
	         
	      } else if(shapeType.equalsIgnoreCase("SQUARE")){
	         return new Square();
	      }
	      
	      return null;
	   }

}
