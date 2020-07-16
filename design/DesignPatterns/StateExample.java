package DesignPatterns;


public class StateExample 
{
    public static void main(String[] args) 
    {
//        DeliveryContext ctx = new DeliveryContext(null, "Test123");
//         
//        ctx.update();
//        ctx.update();
//        ctx.update();
//        ctx.update();
//        ctx.update();
    }
}

//interface PackageState 
//{
//    public void updateState(DeliveryContext ctx);
//}

//   


//public class Acknowledged implements PackageState 
//{
//    //Singleton
//    private static Acknowledged instance = new Acknowledged();
// 
//    private Acknowledged() {}
// 
//    public static Acknowledged instance() {
//        return instance;
//    }
//     
//    //Business logic and state transition
//    @Override
//    public void updateState(DeliveryContext ctx) 
//    {
//        System.out.println("Package is acknowledged !!");
//        ctx.setCurrentState(Shipped.instance());
//    }
//}
//
//public class InTransition implements PackageState 
//{
//    //Singleton
//    private static InTransition instance = new InTransition();
// 
//    private InTransition() {}
// 
//    public static InTransition instance() {
//        return instance;
//    }
//     
//    //Business logic and state transition
//    @Override
//    public void updateState(DeliveryContext ctx) 
//    {
//        System.out.println("Package is in transition !!");
//        ctx.setCurrentState(OutForDelivery.instance());
//    }
//}


//public class DeliveryContext {
//    
//    private PackageState currentState;
//    private String packageId;
//     
//    public DeliveryContext(PackageState currentState, String packageId) 
//    {
//        super();
//        this.currentState = currentState;
//        this.packageId = packageId;
//         
//        if(currentState == null) {
//            this.currentState = Acknowledged.instance();
//        }
//    }
// 
//    public PackageState getCurrentState() {
//        return currentState;
//    }
// 
//    public void setCurrentState(PackageState currentState) {
//        this.currentState = currentState;
//    }
//     
//    public String getPackageId() {
//        return packageId;
//    }
// 
//    public void setPackageId(String packageId) {
//        this.packageId = packageId;
//    }
// 
//    public void update() {
//        currentState.updateState(this);
//    }
//}