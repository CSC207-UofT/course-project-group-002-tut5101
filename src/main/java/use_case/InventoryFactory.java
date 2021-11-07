package use_case;

import entity.*;

public class InventoryFactory {
    public Inventory getInventory(String[] paras) {
        if (paras.length == 6) {
            if (paras[0].equalsIgnoreCase("meat")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                return new Meat(name, price, quantity, freshness, importdate);

            } else if (paras[0].equalsIgnoreCase("dairysoy")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                return new DairySoy(name, price, quantity, freshness, importdate);

            } else if (paras[0].equalsIgnoreCase("grain")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                return new Grain(name, price, quantity, freshness, importdate);

            } else if (paras[0].equalsIgnoreCase("seafood")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                return new Seafood(name, price, quantity, freshness, importdate);

            } else if (paras[0].equalsIgnoreCase("seasoner")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                return new Seasoner(name, price, quantity, freshness, importdate);
            } else if (paras[0].equalsIgnoreCase("vegefruit")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                String freshness = paras[4];
                int importdate = Integer.parseInt(paras[5]);
                return new VegeFruit(name, price, quantity, freshness, importdate);
            }
        } else if (paras.length == 5) {
            if (paras[0].equalsIgnoreCase("alcohol")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                int expiry = Integer.parseInt(paras[4]);
                return new Alcohol(name, price, quantity, expiry);
            } else if (paras[0].equalsIgnoreCase("softdrink")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                int expiry = Integer.parseInt(paras[4]);
                return new SoftDrink(name, price, quantity, expiry);
            } else if (paras[0].equalsIgnoreCase("semifinished")) {
                String name = paras[1];
                double price = Double.parseDouble(paras[2]);
                double quantity = Double.parseDouble(paras[3]);
                int expiry = Integer.parseInt(paras[4]);
                return new SemiFinished(name, price, quantity, expiry);
            }
        }
        return null;
    }
}
