//package ShoppingCart;
//
//public class SP {
//	
//	class Product {
//	    private Integer pid;
//	    private String name;
//	    private Double price;
//	    private Integer stock;
//	    
//	    public Product () {       
//	    }
//	    
//	    public Product (Integer pid, String name, Double price, Integer stock) {
//	        this.pid = pid;
//	        this.name = name;
//	        this.price = price;
//	        this.stock = stock;
//	    }
//	    /**
//	     * @return the name
//	     */
//	    public String getName() {
//	        return name;
//	    }
//
//	    /**
//	     * @param name the name to set
//	     */
//	    public void setName(String name) {
//	        this.name = name;
//	    }
//
//	    /**
//	     * @return the price
//	     */
//	    public Double getPrice() {
//	        return price;
//	    }
//
//	    /**
//	     * @param price the price to set
//	     */
//	    public void setPrice(Double price) {
//	        this.price = price;
//	    }
//
//	    /**
//	     * @return the stock
//	     */
//	    public Integer getStock() {
//	        return stock;
//	    }
//
//	    /**
//	     * @param stock the stock to set
//	     */
//	    public void setStock(Integer stock) {
//	        this.stock = stock;
//	    }
//
//	    /**
//	     * @return the pid
//	     */
//	    public Integer getPid() {
//	        return pid;
//	    }
//
//	    @Override
//	    public int hashCode() {
//	        int hash = 7;
//	        hash = 29 * hash + Objects.hashCode(this.pid);
//	        hash = 29 * hash + Objects.hashCode(this.name);
//	        hash = 29 * hash + Objects.hashCode(this.price);
//	        hash = 29 * hash + Objects.hashCode(this.stock);
//	        return hash;
//	    }
//
//	    @Override
//	    public boolean equals(Object obj) {
//	        if (this == obj) {
//	            return true;
//	        }
//	        if (obj == null) {
//	            return false;
//	        }
//	        if (getClass() != obj.getClass()) {
//	            return false;
//	        }
//	        final Product other = (Product) obj;
//	        if (!Objects.equals(this.name, other.name)) {
//	            return false;
//	        }
//	        if (!Objects.equals(this.pid, other.pid)) {
//	            return false;
//	        }
//	        if (!Objects.equals(this.price, other.price)) {
//	            return false;
//	        }
//	        if (!Objects.equals(this.stock, other.stock)) {
//	            return false;
//	        }
//	        return true;
//	    }
//
//	    /**
//	     * @param pid the pid to set
//	     */
//	    public void setPid(Integer pid) {
//	        this.pid = pid;
//	    }   
//	}
//
//}

//
//public class Products {
//    private final List<Product> products = new ArrayList<Product>();
//
//    public Products () {
//        this.initStoreItems();
//    }
//    
//    public List<Product> getProducts() {
//        return products;
//    }
//    
//    public void initStoreItems() {
//        String [] productNames = {"Lux Soap", "Fair n Lovely", "MTR"};
//        Double [] productPrice = {40.00d, 60.00d, 30.00d};
//        Integer [] stock = {10, 6, 10};
//        
//        for (int i=0; i < productNames.length; i++) {
//            this.products.add(new Product(i+1, productNames[i], productPrice[i], stock[i]));
//        }
//    }
//}

//class Cart {
//
//    List<Product> cartItems = new ArrayList<Product>();
//    
//    public void addProductToCartByPID(int pid) {
//        Product product = getProductByProductID(pid);
//        addToCart(product);
//    }
//
//    private Product getProductByProductID(int pid) {
//        Product product = null;
//        List<Product> products = new Products().getProducts();
//        for (Product prod: products) {
//            if (prod.getPid() == pid) {
//                product = prod;
//                break;
//            }
//        }
//        return product;
//    }
//
//    private void addToCart(Product product) {
//        cartItems.add(product);
//    }
//
//    public void removeProductByPID(int pid) {
//        Product prod = getProductByProductID(pid);
//        cartItems.remove(prod);
//    }
//
//    void printCartItems() {
//        for (Product prod: cartItems) {
//            System.out.println(prod.getName());
//        }
//    }
//    
//}


//public class UI {
//
//    Cart cart = new Cart();
//    private int ch = 0;
//    
//    public UI () {
//        menu();
//    }
//    
//    public void startScreen () {
//        System.out.println("1. Display Store Products");
//        System.out.println("2. Display Cart");
//        System.out.println("0. Exit");
//    }
//    
//    public void storeProductsMenu() {
//        System.out.println("1. Add to Cart");
//        System.out.println("2. Remove From Cart");
//        System.out.println("0. Exit");
//    }
//    
//    public void menu () {
//        do {
//            startScreen();
//            getUserInput();
//            
//            switch (ch) {
//                case 1: 
//                    displayStoreProducts();
//                    storeProductsMenu();
//                    getUserInput();
//                    innerChoice1();
//                    break;
//                case 2:
//                    showCart();
//                    break;
//                case 0:
//                    System.exit(0);
//                    break;
//                default:
//                    
//                    break;
//            }
//        } while (ch != 0);
//    }
//
//    private void innerChoice1() {
//        switch (ch) {
//            case 1:
//                addProductToCart();
//                showCart();
//                break;
//            case 2:
//                removeProductFromCart();
//                break;
//            default:
//                
//                break;
//        }
//    }
//
//    private int getUserInput() throws NumberFormatException {
//        Scanner in = new Scanner (System.in);
//        ch = Integer.parseInt(in.nextLine());
//        return ch;
//    }
//
//    private void displayStoreProducts() {
//        List<Product> products = new Products().getProducts();
//        for (Product prod: products) {
//            System.out.println(
//                    prod.getPid() + "- " +
//                            prod.getName() + " " +
//                            prod.getPrice() + " " +
//                            prod.getStock()
//            );
//        }
//    }
//
//    private void addProductToCart() {
//        int pid = getUserInput();
//        cart.addProductToCartByPID(pid);      
//    }
//
//    private void showCart() {
//        cart.printCartItems();
//    }
//
//    private void removeProductFromCart() {
//        int pid = getUserInput();
//        cart.removeProductByPID(pid);
//    }
//}