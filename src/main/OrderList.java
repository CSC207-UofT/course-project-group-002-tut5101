package main;
/**
This is the class of Orderlist, it is used to keep track of all orders of the restaurant
 */
public class OrderList {

    private List<Order> orderList;

    public void OrderList() {
        orderList = new ArrayList<Order>();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}