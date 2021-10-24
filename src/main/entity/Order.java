package entity;


import java.util.List;
import java.util.Objects;


public class Order {
    private ArrayList<String[]> dishes;
    private boolean dineIn;
    private Status orderStatus;
    private int tableNum;
    private String address;

    // initialize dine-in order
    public Order(int tableNum, List<Dish> dishes){
        this.dishes = dishes;
        this.dineIn = true;
        this.orderStatus = Status.PLACED;
        this.tableNum = tableNum;
    }

    // initialize delivery order
    public Order(String address, List<Dish> dishes){
        this.dishes = dishes;
        this.dineIn = false;
        this.orderStatus = Status.PLACED;
        this.address = address;
    }

    public String getOrderStatus() {
        return orderStatus.toString();
    }

    public String getOrderDineInOrTakeOut() {
        if (!this.dineIn){
            return "Take Out";
        } else {
            return "Dine In";
        }
    }


    public void setDishStatus(String dishName) throws Exception {
        boolean updated = false;
        for (String[] dishAndStatus: dishes) {
            if (dishAndStatus[0].equals(dishName) && dishAndStatus[1].equals(ItemStatus.DISH_PLACED)){
                dishAndStatus[1] = ItemStatus.DISH_COOKED;
                updated = true;
                break;
            }
        }

        if (!updated) {
            throw new Exception("No such dish:" + dishName + " in the order");
        }

        updateOrderStatus();
    }


    private void updateOrderStatus() {
        // Check if all dishes are complete.
        for (String[] dishAndStatus: dishes) {
            if (!dishAndStatus[1].equals(ItemStatus.DISH_COOKED)) {
                return;
            }
        }

        // If all dishes are complete, update the order status and return true
        this.orderStatus = Status.COOKED;
        return true;
    }

    /**
     * Returns provided STRING argument.
     * @param status is the status to set the order as
     * @throws Exception status is not one of the allowable status in statuses
     */
    public void setOrderStatus(Status status) {
        //TODO: throw exception if status is not one of the allowable status in statuses
        this.orderStatus = status;
    }

    /**
     * Get the order status of the order
     * @return order status as type ItemStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    // TODO: add a method to access all the information of a dish given the dish name.

    public double getOrderPrice() {
        double price = 0;
        for (String[] dishAndStatus: dishes) {
            price += DishList.getDishInfo(dishAndStatus[0]).getPrice();
        }
        return price;
    }

    public int getTableNum() {
        return this.tableNum;
    }

    public String getAddress() {
        return this.address;
    }

    public List<Dish> getDishes() {
        return this.dishes;
    }

}
