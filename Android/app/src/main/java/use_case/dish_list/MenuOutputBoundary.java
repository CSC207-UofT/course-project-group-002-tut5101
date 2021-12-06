package use_case.dish_list;
/**
 * The output presenter.boundary for Menu presenter.
 */
public interface MenuOutputBoundary {
    /**
     * update the display to show dishes in menu
     * @param menuItems the items in the menu as a string
     */
    void updateMenuItemsDisplay(String menuItems);
}
