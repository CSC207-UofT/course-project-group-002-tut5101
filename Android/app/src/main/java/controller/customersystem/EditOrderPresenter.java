package controller.customersystem;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is the Edit Order Presenter corresponding to the Edit Order Activity, which takes the input from the activity,
 * does stuff to it, then tells the activity what to show to the user.
 */
public class EditOrderPresenter {
    private EditOrderViewInterface editOrderViewInterface;

    private HashMap<String, Integer> dishesOrdered;
    private ArrayList<String> collectedDishes;

    /**
     * Constructor of this class
     */
    public EditOrderPresenter(){

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
        collectDishes();
    }

    /**
     * Takes the dishes ordered and collects them in string format into an array before updating the options to be picked
     */
   public void collectDishes() {
        collectedDishes = new ArrayList<>();
        String dishNameAndQuantity;
        if (dishesOrdered != null) {
            for (String dishName : dishesOrdered.keySet()) {
                dishNameAndQuantity = dishName + " x " + dishesOrdered.get(dishName);
                collectedDishes.add(dishNameAndQuantity);
            }
        }

        setOrderedDishesPicker();
    }

    /**
     * Set the number of options
     */
    private void setOrderedDishesPicker(){
        if (collectedDishes.size() >= 1) {
            editOrderViewInterface.setOrderedDishesPickerMax(collectedDishes.size() - 1);
        }
        else {
            editOrderViewInterface.setOrderedDishesPickerMax(0);
        }
        editOrderViewInterface.setOrderedDishesPickerValues(collectedDishes.toArray(new String[0]));
    }

    /**
     * Display the dishes available to edit
     */
    public void displayDishesOrdered() {
        editOrderViewInterface.displayDishesOrdered(collectedDishes.toArray(new String[0]));
    }

    /**
     * Remove a dish from the current order
     * @param dishIndex the index corresponding to the dish to be removed
     */
    public void removeOrderedDish(int dishIndex) {
        String dishName = collectedDishes.get(dishIndex).split(" x ")[0];
        dishesOrdered.remove(dishName);
        collectDishes();
        displayDishesOrdered();
    }

    /**
     * Update the dishes to be ordered on the view
     */
    public void updateDishesOrdered() {
        editOrderViewInterface.updateDishesOrdered(dishesOrdered);
    }
}
