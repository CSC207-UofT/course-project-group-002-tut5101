package entity;

/**
 * This is the Order class, which holds all the dishes the customer placed in the order
 * @Author Evelyn Chou
 * 2021-11-03
 */
import constant.ItemStatus;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


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

    /**
     *
     * @return whether the order is dine in or take out
     */
    public String getOrderDineInOrTakeOut() {
        if (!this.dineIn){
            return "Take Out";
        } else {
            return "Dine In";
        }
    }


    /**
     * sets the status uncooked dish with name as cooked, and checks if the entire order is done cooking
     * @param name the name of the dish that was cooked and needs to be updated
     * @return the Dish that was updated
     */
    public Dish setDishStatus(String name) {
        for(Dish d : dishes.get(name)){
            if (d.getStatus().equals(ItemStatus.DISH_PLACED)) {
                d.setStatus(ItemStatus.DISH_COOKED);
                updateOrderStatus();
                return d;
            }
        }
        return null;
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

    /**
     * @return A hashmap of dishes with its corresponding quantity.
     */
    public HashMap<String, Integer> getDishAndQuantity() {
        HashMap<String, Integer> dishAndQuantity = new HashMap<>();
        for (String dishName: dishes.keySet()) {
            dishAndQuantity.put(dishName, dishes.get(dishName).size());
        }
        return dishAndQuantity;
    }

    public String getOrderContent() {
        StringBuilder content = new StringBuilder();
        content.append("Order contents: \n");
        for (String dishName: dishes.keySet()) {
            content.append("\tDish: ");
            content.append(dishName);
            content.append(" Quantity: ");
            content.append(dishes.get(dishName).size());
            content.append("\n");
        }
        content.append("====================");
        return content.toString();
    }


    /**
     *
     * @return String containing the dish names, quantity, ingredients, price for each dish, and total price of the Order
     */
    public String toString() {
        StringBuilder orderString = new StringBuilder();
        String dishInfo;
        double totalPrice = 0;

        orderString.append("ORDER DETAILS");
        orderString.append("\n------------------------------\n");

        for (String key: dishes.keySet()) {
            Dish dish = dishes.get(key).get(0);
            dishInfo = "Dish Name: " + dish.getName() +
                    "\n Quantity: " + dishes.get(key).size() +
                    "\n Ingredients: " + dish.getIngredients() +
                    "\n Price: $" + dish.getPrice() +
                    "\n------------------------------\n";
            totalPrice += dish.getPrice();
            orderString.append(dishInfo);
        }
        orderString.append("Total Price: $" + (Math.round(totalPrice*100.0) /100.0));
        return orderString.toString();
    }

    /**
     *
     * @param o the Dish to compare to
     * @return whether the attributes of the Order are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return dineIn == order.dineIn && getTableNum() == order.getTableNum() && Objects.equals(getDishes(), order.getDishes()) && getOrderStatus() == order.getOrderStatus() && Objects.equals(getAddress(), order.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDishes(), dineIn, getOrderStatus(), getTableNum(), getAddress());
    }
}
