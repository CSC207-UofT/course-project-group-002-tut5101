package entity.order;


import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import constant.order_system.ItemStatus;
import constant.order_system.OrderType;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**This is the Order class, which holds all the dishes the customer placed in the order
 * by Evelyn Chou
 * 2021-11-03
 */

public abstract class Order {
    private final HashMap<String, List<Dish>> dishes;
    private ItemStatus orderStatus;

    /**
     * Initialize an order (used by subclasses)
     * @param dishes the dishes ordered
     */
    public Order(HashMap<String, List<Dish>> dishes) {
        this.dishes = dishes;
    }


    /**
     * sets the status uncooked dish with name as cooked, and checks if the entire order is done cooking
     * @param name the name of the dish that was cooked and needs to be updated
     * @return the Dish that was updated
     */
    public Dish setDishStatus(String name) {
        for (Dish d : Objects.requireNonNull(dishes.get(name))) {
            if (d.getStatus().equals(ItemStatus.DISH_PLACED)) {
                d.setStatus(ItemStatus.DISH_COOKED);
                updateOrderStatus();
                return d;
            }
        }
        return null;
    }

    /**
     * Update the order status to complete if all dishes are complete
     */
    private void updateOrderStatus() {
        // Check if all dishes are complete.
        boolean allComplete = true;

        for (List<Dish> dishAsList : dishes.values()) {
            for (Dish dish : dishAsList) {
                if (!dish.getStatus().equals(ItemStatus.DISH_COOKED)) {
                    allComplete = false;
                    break;
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

    /**
     * @return the total price of the order
     */
    public double getOrderPrice() {
        DecimalFormat df = new DecimalFormat("0.00");

        int price = 0;
        for (List<Dish> dishAsList : dishes.values()) {
            for (Dish dish : dishAsList) {
                price += dish.getPrice() * 100;
            }
        }
        double p = price / 100.0;
        return Double.parseDouble(df.format(p));
    }

    /**
     * Return all the dishes in the order with duplication
     * @return The list of all the dishes in the order with duplication
     */
    public List<Dish> getDishes() {
        List<Dish> dishList = new ArrayList<>();
        for (List<Dish> dishAsList : dishes.values()) {
            dishList.addAll(dishAsList);
        }
        return dishList;
    }

    /**
     * @return A hashmap of dishes with its corresponding quantity.
     */
    public HashMap<String, Integer> getDishAndQuantity() {
        HashMap<String, Integer> dishAndQuantity = new HashMap<>();
        for (String dishName : dishes.keySet()) {
            for (Dish dish : Objects.requireNonNull(dishes.get(dishName))) {
                if (dish.getStatus() == ItemStatus.DISH_PLACED) {
                    if (dishAndQuantity.containsKey(dishName)) {
                        dishAndQuantity.put(dishName, Objects.requireNonNull(dishAndQuantity.get(dishName)) + 1);
                    } else {
                        dishAndQuantity.put(dishName, 1);
                    }
                }
            }
        }
        return dishAndQuantity;
    }

    /**
     * @return information on the dishes in the order
     */
    public String getOrderContent() {
        StringBuilder content = new StringBuilder();
        content.append("Order contents: \n");
        for (String dishName : dishes.keySet()) {
            content.append("\tDish: ");
            content.append(dishName);
            content.append(" Quantity: ");
            content.append(Objects.requireNonNull(dishes.get(dishName)).size());
            content.append("\n");
        }
        content.append("====================");
        return content.toString();
    }


    /**
     *
     * @return String containing the dish names, quantity, ingredients, price for each dish, and total price of the Order
     */
    @NonNull
    public String toString() {
        StringBuilder orderString = new StringBuilder();
        String dishInfo;
        double totalPrice = 0;

        orderString.append("ORDER DETAILS");
        orderString.append("\n------------------------------\n");

        for (String key : dishes.keySet()) {
            Dish dish = Objects.requireNonNull(dishes.get(key)).get(0);
            dishInfo = "Dish Name: " + dish.getName() +
                    "\n Quantity: " + Objects.requireNonNull(dishes.get(key)).size() +
                    "\n Ingredients: " + dish.getIngredients() +
                    "\n Price: $" + dish.getPrice() +
                    "\n------------------------------\n";
            totalPrice += dish.getPrice();
            orderString.append(dishInfo);
        }
        orderString.append("Total Price: $").append(Math.round(totalPrice * 100.0) / 100.0);
        return orderString.toString();
    }

    /**
     *
     * @param o the Dish to compare to
     * @return whether the attributes of the Order are the same.
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getDishes(), order.getDishes()) && getOrderStatus() == order.getOrderStatus();
    }

    /**
     * @return the type of order
     */
    public abstract OrderType getOrderType();
}