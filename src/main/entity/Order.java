package entity;


import constant.ItemStatus;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Order {
    private HashMap<String, List<Dish>> dishes;
    private boolean dineIn;
    private ItemStatus orderStatus;
    private int tableNum;
    private String address;

    // initialize dine-in order
    public Order(int tableNum, HashMap<String, List<Dish>> dishes){
        this.dishes = dishes;
        this.dineIn = true;
        this.orderStatus = ItemStatus.ORDER_PLACED;
        this.tableNum = tableNum;
    }

    // initialize delivery order
    public Order(String address, HashMap<String, List<Dish>> dishes){
        this.dishes = dishes;
        this.dineIn = false;
        this.orderStatus = ItemStatus.ORDER_PLACED;
        this.address = address;
    }

    public String getOrderDineInOrTakeOut() {
        if (!this.dineIn){
            return "Take Out";
        } else {
            return "Dine In";
        }
    }

    public Dish setDishStatus(String name) throws Exception {
        for(Dish d : dishes.get(name)){
            if (d.getStatus().equals(ItemStatus.DISH_PLACED)) {
                d.setStatus(ItemStatus.DISH_COOKED);
                updateOrderStatus();
                return d;
            }
        }
        throw new Exception("No such dish:" + name + " in the order, or all dishes are cooked.");
    }


    private void updateOrderStatus() {
        // Check if all dishes are complete.
        boolean allComplete = true;

        for (List<Dish> dishAsList: dishes.values()) {
            for (Dish dish: dishAsList) {
                if (!dish.getStatus().equals(ItemStatus.DISH_COOKED)){
                    allComplete = false;
                }

            }
        }

        // If all dishes are complete, update the order status and return true
        if (allComplete) {
            this.orderStatus = ItemStatus.ORDER_COOKED;
        }
    }

    /**
     * Returns provided STRING argument.
     * @param status is the status to set the order as
     * @throws Exception status is not one of the allowable status in statuses
     */
    public void setOrderStatus(ItemStatus status) {
        this.orderStatus = status;
    }

    /**
     * Get the order status of the order
     * @return order status as type ItemStatus
     */
    public ItemStatus getOrderStatus() {
        return orderStatus;
    }

    // TODO: add a method to access all the information of a dish given the dish name.

    public double getOrderPrice() {
        double price = 0;
        for (List<Dish> dishAsList : dishes.values()) {
            for (Dish dish : dishAsList) {
                price += dish.getPrice();
            }
        }
        return price;
    }

    /**
     * Get the table number to be delivered for the order
     * @return the table number of the dine-in order.
     */
    public int getTableNum() {
        return this.tableNum;
    }

    /**
     * Get the address of the destination of the delivery order
     * @return the address of the destination of the order
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Return all the dishes in the order with duplication
     * @return The list of all the dishes in the order with duplication
     */
    public List<Dish> getDishes() {
        List<Dish> dishList = new ArrayList<Dish>();
        for (List<Dish> dishAsList: dishes.values()) {
            for (Dish dish: dishAsList) {
                dishList.add(dish);
                }
            }
        return dishList;
    }

}
