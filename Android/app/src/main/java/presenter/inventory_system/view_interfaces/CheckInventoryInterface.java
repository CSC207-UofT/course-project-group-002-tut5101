package presenter.inventory_system.view_interfaces;
/**
 * Check Inventory interface between view and presenter
 */
public interface CheckInventoryInterface {
    /**
     * Show the information and pass information to other pages
     *
     * @param info the message of action of checking
     */
    void CheckValidity(String info);
}
