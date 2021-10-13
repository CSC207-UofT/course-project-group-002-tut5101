import java.util.Arrays;
import java.util.HashMap;


/**
 * Public class  that contains basic features of a single dish
 *
 * @author Chan Yu & Naihe Xiao
 */
public class Dish {
    private String name;
    private double price;
    private HashMap<String, Double> ingredients;
    private HashMap<String, Boolean> features;
    private double calories;
    private String allergyInformation;
    private String status;

    /**
     * Constructor of Dish with name, price, ingredients and calories provided.
     *
     * @param name
     * @param price
     * @param ingredients
     * @param calories
     */
    public Dish(String name, double price, HashMap<String, Double> ingredients, double calories) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.calories = calories;
        this.features = new HashMap<String, Boolean>();
        this.allergyInformation = "none";
        this.status = "ordered";
    }

    /**
     * Return status of Dish
     *
     * @return the status of Dish
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set status of Dish
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Return name of Dish
     *
     * @return the name of Dish
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of Dish
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return price of Dish
     *
     * @return the price of Dish
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price of Dish
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Return ingredients of Dish
     *
     * @return the ingredients of Dish
     */
    public HashMap<String, Double> getIngredients() {
        return ingredients;
    }

    /**
     * Set ingredients of Dish
     *
     * @param ingredients
     */
    public void setIngredients(HashMap<String, Double> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Return features of Dish
     *
     * @return the feature of Dish
     */
    public HashMap<String, Boolean> getFeatures() {
        return features;
    }

    /**
     * Set features of Dish
     *
     * @param features
     */
    public void setFeatures(HashMap<String, Boolean> features) {
        this.features = features;
    }

    /**
     * Return calories of Dish
     *
     * @return the calories of Dish
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Set calories of Dish
     *
     * @param calories
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * Return allergy information of Dish
     *
     * @return the allergy information of Dish
     */
    public String getAllergyInformation() {
        return allergyInformation;
    }

    /**
     * Set allergy information of Dish
     *
     * @param allergyInformation
     */
    public void setAllergyInformation(String allergyInformation) {
        this.allergyInformation = allergyInformation;
    }

    /**
     * Override the toString method of Object and return a fine illustration of a Dish information
     *
     * @return a string representation of this dish
     */
    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients.toString() +
                ", features=" + features +
                ", calories=" + calories +
                ", allergyInformation='" + allergyInformation + '\'' +
                ", status='" + status +
                '}';
    }
}