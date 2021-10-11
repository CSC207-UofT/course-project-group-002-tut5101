package entities;

public class Seasoner extends Material{
    public Seasoner(String name, boolean usedup, double price, double quantity, String freshness,
                    int ImportDate){
        super(name, usedup, price, quantity, freshness, ImportDate);
        this.freshness = freshness;
        this.ImportDate = ImportDate;
    }


}
