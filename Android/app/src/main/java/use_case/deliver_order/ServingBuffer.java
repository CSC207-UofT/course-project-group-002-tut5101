package use_case.deliver_order;

import entity.order.Dish;

import java.util.ArrayDeque;
import java.util.Queue;

public class ServingBuffer {
    /**
     * The buffer queue where each element is a "tuple" of table number and a dish; the serving
     * staff calls method to access the next dish to be served.
     */
    private static Queue<Dish> servingBuffer = new ArrayDeque<>();

    /**
     * Reset the Serving buffer for tests
     */
    public static void reset() {
        servingBuffer = new ArrayDeque<>();
    }

    /**
     * The getter method for ServingStaff to call to get the next dish to serve.
     *
     * @return a UseCase.DishInfo instance, which contains the table number of the dish and the dish itself.
     */
    public static Dish getNextToServe() throws Exception {
        Dish dish = servingBuffer.poll();
        if (dish == null) {
            throw new Exception("No dish to serve");
        }

        return dish;
    }

    /**
     * Add dish to serving buffer
     *
     * @param dish the dish to be added
     */
    public static void addDish(Dish dish) {
        servingBuffer.add(dish);
    }

}
