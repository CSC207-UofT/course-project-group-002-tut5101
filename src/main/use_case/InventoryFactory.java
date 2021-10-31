package use_case;
import entity.*;
public class InventoryFactory {
    public Inventory getInventory(String[] paras){
        Inventory item = null;
        if(paras.length == 6){
            if(paras[0].equals("meat")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                item = new Meat(name, price, quantity, freshness, importdate);
            }
            else if(paras[0].equals("dairysoy")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                item = new DairySoy(name, price, quantity, freshness, importdate);
            }
            else if(paras[0].equals("grain")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                item = new Grain(name, price, quantity, freshness, importdate);
            }
            else if(paras[0].equals("seafood")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                item = new Seafood(name, price, quantity, freshness, importdate);
            }
            else if(paras[0].equals("seasoner")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                item = new Seasoner(name, price, quantity, freshness, importdate);
            }
            else if(paras[0].equals("vegefruit")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                item = new VegeFruit(name, price, quantity, freshness, importdate);
            }}
        if(paras.length == 5){
            if(paras[0].equals("alcohol")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                int expiry = Integer.parseInt(paras[4]);
                item = new Alcohol(name, price, quantity, expiry);
            }
            else if(paras[0].equals("softdrink")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                int expiry = Integer.parseInt(paras[4]);
                item = new SoftDrink(name, price, quantity, expiry);
            }
            else if(paras[0].equals("semifinished")){
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                int expiry = Integer.parseInt(paras[4]);
                item = new SemiFinished(name, price, quantity, expiry);
            }
            }
        return item;
    }
    }
