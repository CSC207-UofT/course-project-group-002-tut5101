package entity.orderList;

import constant.orderSystem.ItemStatus;

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
    private String category;

    /**
     * A Hashmap that maps ingredient name to the quantity needed for this dish.
     */
    private HashMap<String, Double> ingredients;
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
    public Dish(String name, double price, HashMap<String, Double> ingredients, double calories) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.calories = calories;
        this.features = new HashMap<String, Boolean>();
        this.allergyInformation = "none";
    }

    /**
     * Constructor of entities.Dish with name, price, ingredients and calories provided.
     *
     * @param name        name of the entities.Dish
     * @param price       price of the entities.Dish
     * @param ingredients ingredients of the entities.Dish
     * @param calories    calories of the entities.Dish
     * @param category    category of the entities.Dish, ie Food/Soup/Drink
     */
    public Dish(String name, double price, HashMap<String, Double> ingredients, double calories, String category) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.calories = calories;
        this.features = new HashMap<String, Boolean>();
        this.allergyInformation = "none";
        this.category = category;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    /**
     * Return category of entities.Dish
     * @return category of entities.Dish
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the table number for this dish.
     */
    public int getTableNum() { return tableNum;}

    /**
     * Set category of entities.Dish
     * @param category category of entities.Dish
     */
    public void setCategory(String category) {
        this.category = category;
    }

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
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Return ingredients of entities.Dish
     *
     * @return the ingredients of entities.Dish
     */
    public HashMap<String, Double> getIngredients() {
        return ingredients;
    }

    /**
     * Set ingredients of entities.Dish
     *
     * @param ingredients
     */
    public void setIngredients(HashMap<String, Double> ingredients) {
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
     * @param features
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
     * @param calories
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
     * @param allergyInformation
     */
    public void setAllergyInformation(String allergyInformation) {
        this.allergyInformation = allergyInformation;
    }

    /**
     * Override the toString method of Object and return a fine illustration of a entities.Dish information
     *
     * @return a string representation of this dish
     */
    @Override
    public String toString() {

        StringBuilder ingString = new StringBuilder();
        for (String ing: ingredients.keySet()){
            ingString.append(ingredients.get(ing) + " " + ing + "  ");
        }

        return name +
                "\n\t\t$$" + price +
//                "\n\t\tIngredients: " + ingString +
//                "\n\t\tfeatures: " + features +
                "\n\t\tcalories: " + calories + " cal/100g" +
                "\n\t\tallergyInformation: " + allergyInformation +
                "\n------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.getPrice(), getPrice()) == 0 && Double.compare(dish.getCalories(), getCalories()) == 0 && getTableNum() == dish.getTableNum() && getName().equals(dish.getName()) && getCategory().equals(dish.getCategory()) && getIngredients().equals(dish.getIngredients()) && getFeatures().equals(dish.getFeatures()) && getAllergyInformation().equals(dish.getAllergyInformation()) && getStatus() == dish.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getCategory(), getIngredients(), getFeatures(), getCalories(), getAllergyInformation(), getStatus(), getTableNum());
    }
}