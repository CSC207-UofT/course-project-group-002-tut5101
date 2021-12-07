package presenter.order_system;

import presenter.order_system.view_interfaces.EditOrderViewInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * This is the Edit Order Presenter corresponding to the Edit Order Activity, which takes the input from the activity,
 * does stuff to it, then tells the activity what to show to the user.
 */
public class EditOrderPresenter {
    private EditOrderViewInterface editOrderViewInterface;

    private HashMap<String, Integer> dishesOrdered;
    private HashMap<String, Double> dishPrices;
    private ArrayList<String> collectedDishes;

    /**
     * Constructor for this class
     */
    public EditOrderPresenter() {
        this.collectedDishes = new ArrayList<>();
        this.dishesOrdered = new HashMap<>();
        this.dishPrices = new HashMap<>();
    }

    /**
     * Set the EditOrderViewInterface attribute of this class
     * @param editOrderViewInterface the EditOrderViewInterface
     */
    public void setEditOrderViewInterface(EditOrderViewInterface editOrderViewInterface) {
        this.editOrderViewInterface = editOrderViewInterface;
    }

    /**
     * set the dishes ordered
     * @param dishesOrdered dishes ordered
     */
    public void setDishesOrdered(HashMap<String, Integer> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }

    public void setDishPrices(HashMap<String, Double> dishPrices) {
        this.dishPrices = dishPrices;
    }

    /**
     * Takes the dishes ordered and collects them in string format into an array before updating the options to be picked
     */
   public void collectDishes() {
       collectedDishes = new ArrayList<>();
       String dishNameAndQuantity;
       if (!dishesOrdered.isEmpty()) {
           for (String dishName : dishesOrdered.keySet()) {
               dishNameAndQuantity = dishName + " x " + dishesOrdered.get(dishName) + "   $" +
                       dishPrices.get(dishName) + "\t each";
               collectedDishes.add(dishNameAndQuantity);
           }
       }
   }


    /**
     * Set the number of options
     */
    private void setOrderedDishesPicker(){
        collectDishes();
        if (collectedDishes.size() >= 1) {
            editOrderViewInterface.setOrderedDishesPickerMax(collectedDishes.size() - 1);
            editOrderViewInterface.setOrderedDishesPickerValues(collectedDishes.toArray(new String[0]));
        }
        else {
            editOrderViewInterface.setOrderedDishesPickerMax(0);
            editOrderViewInterface.setOrderedDishesPickerValues(new String[]{"No Dishes"});
        }
    }

    /**
     * Display the dishes available to edit
     */
    public void displayDishesOrdered() {
        setOrderedDishesPicker();
        if (!collectedDishes.isEmpty()) {
            ArrayList<String> dishesString = new ArrayList<>(collectedDishes);
            dishesString.add(getTotalPriceString());
            editOrderViewInterface.displayDishesOrdered(dishesString.toArray(new String[0]));
        }
        else {
            editOrderViewInterface.displayDishesOrdered(new String[0]);
        }
    }

    private String getTotalPriceString() {
        double totalPrice = 0;
        for (String dishName : dishesOrdered.keySet()) {
            Integer tempQuantity = dishesOrdered.get(dishName);
            Double tempPrice = dishPrices.get(dishName);
            if (tempQuantity != null && tempPrice != null){
                int quantity = tempQuantity;
                double price = tempPrice;
                for (int i = 1; i <= quantity; i++) {
                    totalPrice += price * 100;
                }
            }
        }
        totalPrice = totalPrice / 100;
        String s = String.format(Locale.CANADA, "%.2f", totalPrice);
        return "\n\nTOTAL PRICE: " + s;
    }

    /**
     * Remove a dish from the current order
     * @param dishIndex the index corresponding to the dish to be removed
     */
    public void removeOrderedDish(int dishIndex) {
        collectDishes();
        if (!collectedDishes.isEmpty()) {
            String dishName = collectedDishes.get(dishIndex).split(" x ")[0];
            dishesOrdered.remove(dishName);
            collectDishes();
            displayDishesOrdered();
        }
    }

    /**
     * Update the dishes to be ordered on the view
     */
    public void updateDishesOrdered() {
        editOrderViewInterface.updateDishesOrdered(dishesOrdered);
    }
}
