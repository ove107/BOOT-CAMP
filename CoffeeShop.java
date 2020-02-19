package JavaIntro2;

interface pendingOrderQueue {
    public void addOrder(Order o);

    public Order getNextOrder();
}
interface FinishedOrderQueue{}
class customer{
    String name;
    String contact;
    public void waitForCoffee()
    {}
    public void CollectCoffee()
    {}
}
class Cashier{
    String name;
    int empid;
    public int takeOrder(double cash){ }
    public placeOrderToQueue(Order o){}

}
class Barista{
    int empid;
    public void prepareCoffee(){}
    public void addOrderToCompleteQueue(Order o){}
    public void notifyOrderComplete(Order o){}
}
class Order{
    int orderid;
    String CoffeeType;

}
public class CoffeeShop {
    public static void main(String[] args) {
        
    }
}
