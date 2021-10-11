import java.util.Arrays;
import java.util.HashMap;

public class Dish {
    private String name;
    private double price;
    private String[] ingredients;
    private HashMap<String, Boolean> features;
    private double calories;
    private String allergyInformation;
    private String status;

//    public Dish() {
//        this.name = "food";
//        this.price = 0.0;
//        this.ingredients = new String[10];
//        this.calories = 0.0;
//        this.features = new HashMap<String, Boolean>();
//        this.allergyInformation = "none";
//    }

    public Dish(String name, double price, String[] ingredients, double calories) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.calories = calories;
        this.features = new HashMap<String, Boolean>();
        this.allergyInformation = "none";
        this.status = "ordered";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public HashMap<String, Boolean> getFeatures() {
        return features;
    }

    public void setFeatures(HashMap<String, Boolean> features) {
        this.features = features;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getAllergyInformation() {
        return allergyInformation;
    }

    public void setAllergyInformation(String allergyInformation) {
        this.allergyInformation = allergyInformation;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", features=" + features +
                ", calories=" + calories +
                ", allergyInformation='" + allergyInformation + '\'' +
                ", status='" + status +
                '}';
    }
}