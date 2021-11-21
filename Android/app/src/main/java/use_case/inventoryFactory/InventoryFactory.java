package use_case.inventoryFactory;
import entity.inventory.*;

public class InventoryFactory {
    /**
     * Use getInventory method to get the inventory by a string array.
     */
    public Inventory getInventory(String[] paras){
        if(paras.length == 5){
                String name = paras[0];
                double price = Double.parseDouble(paras[1]);
                double quantity = Double.parseDouble(paras[2]);
                String freshness = paras[3];
                int importdate = Integer.parseInt(paras[4]);
                return new HasFreshness(name, price, quantity, freshness, importdate);
            }

        else if(paras.length == 4){
                String name = paras[0];
                double price = Double.parseDouble(paras[1]);
                double quantity = Double.parseDouble(paras[2]);
                int expiry = Integer.parseInt(paras[3]);
                return new HasExpiryDate(name, price, quantity, expiry);
            }
        return null;
    }
    }
