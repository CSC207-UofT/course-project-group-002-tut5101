package boundary;

import use_case.DishList;
import use_case.InventoryList;

public interface ManagerInputBoundary {
    void manageMenu(DishList menu);
    String requestInventory(InventoryList inventoryList);
    void deleteReview();
}
