package constant;

/**
 * Constant class for Inventory Manager.
 */

public class InventoryManagerMessage {
    public static final String SELECT_ACTION = "Action List\n1. Check inventory item information\n2. Add new item\n" +
            "3. Set freshness\n"+"4. Set quantity\n"+ "0. Logout";
    public static final String REQUEST_NAME = "Please enter the inventory item name";
    public static final String REQUEST_INFO = "Please enter the following info of this new inventory item in one line" +
            " separated by comma and no space between:\n" +
            "Type (e.g. Grain, Meat, Seafood, etc)\n" +
            "Name\n" +
            "Price\n" +
            "Quantity (no unit needed)\n" +
            "and one of the following two options:\n" +
            "Freshness (a, b, c, d),Import date (e.g. 20211107)\n" +
            "Expiry (e.g. 20211107)";
    public static final String REQUEST_FRESH = "Please enter the name of inventory item and its new freshness " +
            "(i.e. a, b, c, d), separated by comma and no space between";
    public static final String REQUEST_USAGE = "Please enter the name of inventory item and its usage, separated by " +
            "comma and no space between";
}
