package entity.order;


import androidx.annotation.NonNull;
import constant.order_system.ItemStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * Public class  that contains basic features of a single dish
 *
 * @author Chan Yu & Naihe Xiao
 */
public class Dish implements Serializable {
    private String name;
    private double price;

    /**
     * A Hashmap that maps ingredient name to the quantity needed for this dish.
     */
    private HashMap<String, Integer> ingredients;
    private HashMap<String, Boolean> features;
    private double calories;
    private String allergyInformation;
    private ItemStatus status = ItemStatus.DISH_PLACED;
    private int tableNum;

    private static final long serialVersionUID = 1L;


    /**
     * Constructor of entities.Dish with name, price, ingredients and calories provided.
     *
     * @param name        name of the entities.Dish
     * @param price       price of the entities.Dish
     * @param ingredients ingredients of the entities.Dish
     * @param calories    calories of the entities.Dish
     */
    public Dish(String name, double price, HashMap<String, Integer> ingredients, double calories) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.calories = calories;
        this.features = new HashMap<>();
        this.allergyInformation = "none";
    }


    /**
     * Set the table number of the dish
     * @param tableNum the table number of the dish
     */
    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    /**
     * @return the table number for this dish.
     */
    public int getTableNum() { return tableNum;}

    /**
     * Return status of entities.Dish
     *
     * @return the status of entities.Dish
     */
    public ItemStatus getStatus() {
        return status;
    }

    /**
     * Set status of entities.Dish
     *
     * @param status entities.Dish status
     */
    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    /**
     * Return name of entities.Dish
     *
     * @return the name of entities.Dish
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of entities.Dish
     *
     * @param name entities.Dish name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return price of entities.Dish
     *
     * @return the price of entities.Dish
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price of entities.Dish
     *
     * @param price the price of the dish
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Return ingredients of entities.Dish
     *
     * @return the ingredients of entities.Dish
     */
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }

    /**
     * Set ingredients of entities.Dish
     *
     * @param ingredients the ingredients of the dish
     */
    public void setIngredients(HashMap<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Return features of entities.Dish
     *
     * @return the feature of entities.Dish
     */
    public HashMap<String, Boolean> getFeatures() {
        return features;
    }

    /**
     * Set features of entities.Dish
     *
     * @param features special features of the dish
     */
    public void setFeatures(HashMap<String, Boolean> features) {
        this.features = features;
    }

    /**
     * Return calories of entities.Dish
     *
     * @return the calories of entities.Dish
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Set calories of entities.Dish
     *
     * @param calories the number of calories the dish has
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * Return allergy information of entities.Dish
     *
     * @return the allergy information of entities.Dish
     */
    public String getAllergyInformation() {
        return allergyInformation;
    }

    /**
     * Set allergy information of entities.Dish
     *
     * @param allergyInformation allergy information of the dish
     */
    public void setAllergyInformation(String allergyInformation) {
        this.allergyInformation = allergyInformation;
    }

    /**
     * Override the toString method of Object and return a fine illustration of entities.Dish information
     *
     * @return a string representation of this dish
     */
    @Override
    @NonNull
    public String toString() {

        return name +
                "\n\t\t$$" + price +
                "\n\t\tcalories: " + calories + " cal/100g" +
                "\n\t\tallergyInformation: " + allergyInformation +
                "\n------------------------------\n";
    }

    /**
     * increases the price of the dish by $1
     */
    public void increasePrice(double j) {
        double price = this.price;
        this.setPrice(price + j);
    }

    /**
     * decreases the price of the dish by $1
     */
    public void decreasePrice(double j) {
        double price = this.price;
        this.setPrice(price - j);
    }

    /**
     * decreases the number of calories of the dish by 100
     */
    public void decreaseCalories(double j) {
        double calories = this.calories;
        this.setCalories(calories - j);
    }

    /**
     * increases the number of calories of the dish by 100
     */
    public void increaseCalories(double j) {
        double calories = this.calories;
        this.setCalories(calories + j);
    }

    /**
     * compares two dishes to see if contents are the same
     * @param o The dish to compare to
     * @return whether the contents (e.g. ingredients, name, price) of the two dishes are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return (-0.1 <= dish.price - price && dish.price - price <= 0.1) && (-0.1 <= dish.calories - calories && dish.calories - calories <= 0.1) && tableNum == dish.tableNum && Objects.equals(name, dish.name) && Objects.equals(ingredients, dish.ingredients) && Objects.equals(features, dish.features) && Objects.equals(allergyInformation, dish.allergyInformation);
    }

}