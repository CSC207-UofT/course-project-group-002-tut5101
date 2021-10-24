package use_case;

import java.util.ArrayDeque;
import java.util.Queue;
import entity.Dish;
// import boundary.ServeBufferInterface;

public class ServingBuffer {
    /**
     * The buffer queue where each element is a "tuple" of table number and a dish; the serving
     * staff calls method to access the next dish to be served.
     */
    private static Queue<String[]> servingBuffer = new ArrayDeque<>();

    /**
     * The getter method for UseCase.ServingStaff to call to get the next dish to serve.
     * @return a UseCase.DishInfo instance, which contains the table number of the dish and the dish itself.
     */
    public static String[] getNextToServe() throws Exception{
        String[] dish = servingBuffer.poll();
        if (dish == null){
            throw new Exception("No dish to serve");
        }

        return dish;
    }

    public static void addDish(int tableNum, String dishName) {
        servingBuffer.add(new String[]{String.valueOf(tableNum), dishName});
    }

}
