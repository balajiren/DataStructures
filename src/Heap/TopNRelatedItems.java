package Heap;
import java.util.*;
import java.util.stream.Collectors;




class Product{
	
	int ProductId;
	String name;
	int rating;
	String category;
	List<Product> relatedProducts;
	Map<Integer,List<Product>> map = new HashMap<>();
	
	Product(int _id, String _category, String _name, int _rating) {
		
	}
	
	public void addProduct(int id, String name, String category, int rating) {
		
		if(map.containsKey(id)) {
			map.get(id).add(new Product(id,name,category,rating));
		} else {
			
			List<Product> prod = new ArrayList<Product>();
			prod.add(new Product(id,name,category,rating));
			map.put(id, prod);
		}
	}
	
	public List<Product> getRelatedProduct(int id) {
		return map.get(id);
		
	}
	
	
	
}


public class TopNRelatedItems {

	List<Product> relatedProducts = new ArrayList<Product>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Product> GetTopRelatedProducts(int N)
	{
	     List<Product> visitedProducts = new ArrayList<Product>();
	     Queue<Product> ProductsQueue = new LinkedList<Product>();
	     //visitedProducts.add(this);
	     for (Product prod : relatedProducts)
	         if(prod != null) //if a product can't be related to itself then remove this if statement
	             ProductsQueue.offer(prod); 

	     //for now visitedproducts contains only our main product and ProductsQueue contains the product related to it.


	     while(ProductsQueue.size() > 0)
	     {
	          Product p = ProductsQueue.poll();
	          visitedProducts.add(p);
	          for (Product prod : p.relatedProducts)
	          {
	              if( !visitedProducts.contains(prod) && !ProductsQueue.contains(prod))//if we haven't visited the product already or if it is not in the queue so we are going to visit it.
	                  ProductsQueue.offer(prod);
	          }

	     }
	     //now visitedProducts contains all the products that are related (somehow :P) to your first product

	     visitedProducts.remove(this);// to remove the main product from the results
	     
	     //all what is left to do is to take the top N products.
	     visitedProducts.sort(new Comparator<Product>() {
	    	 @Override
	    	 public int compare(Product p1, Product p2) {
	    		 
	    		 return p1.rating - p2.rating;
	    	 }
	    	 
	     });
	     return visitedProducts.stream().limit(N).collect(Collectors.toList());
	}

}
