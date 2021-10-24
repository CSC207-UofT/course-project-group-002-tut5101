package boundary;

import use_case.DishList;
import use_case.InventoryList;

public interface ManagerInputBoundary {
    boolean assignServingStaff(String staffId);
    boolean manageMenu(DishList menu);
    boolean requestInventory(InventoryList inventoryList);
    boolean deleteReview();
}
